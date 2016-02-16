package com.lee.vrg.common.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.util.Pool;

public class JedisSalveSentinelPool extends Pool<Jedis> {

	protected GenericObjectPoolConfig poolConfig;

	protected int timeout = Protocol.DEFAULT_TIMEOUT;

	protected String password;

	protected int database = Protocol.DEFAULT_DATABASE;

	protected Set<SalveListener> salveListeners = new HashSet<SalveListener>();

	protected Logger log = Logger.getLogger(getClass().getName());

	public JedisSalveSentinelPool(String masterName, Set<String> sentinels, final GenericObjectPoolConfig poolConfig) {
		this(masterName, sentinels, poolConfig, Protocol.DEFAULT_TIMEOUT, null, Protocol.DEFAULT_DATABASE);
	}

	public JedisSalveSentinelPool(String masterName, Set<String> sentinels) {
		this(masterName, sentinels, new GenericObjectPoolConfig(), Protocol.DEFAULT_TIMEOUT, null,
				Protocol.DEFAULT_DATABASE);
	}

	public JedisSalveSentinelPool(String masterName, Set<String> sentinels, String password) {
		this(masterName, sentinels, new GenericObjectPoolConfig(), Protocol.DEFAULT_TIMEOUT, password);
	}

	public JedisSalveSentinelPool(String masterName, Set<String> sentinels, final GenericObjectPoolConfig poolConfig,
			int timeout, final String password) {
		this(masterName, sentinels, poolConfig, timeout, password, Protocol.DEFAULT_DATABASE);
	}

	public JedisSalveSentinelPool(String masterName, Set<String> sentinels, final GenericObjectPoolConfig poolConfig,
			final int timeout) {
		this(masterName, sentinels, poolConfig, timeout, null, Protocol.DEFAULT_DATABASE);
	}

	public JedisSalveSentinelPool(String masterName, Set<String> sentinels, final GenericObjectPoolConfig poolConfig,
			final String password) {
		this(masterName, sentinels, poolConfig, Protocol.DEFAULT_TIMEOUT, password);
	}

	public JedisSalveSentinelPool(String masterName, Set<String> sentinels, final GenericObjectPoolConfig poolConfig,
			int timeout, final String password, final int database) {
		this.poolConfig = poolConfig;
		this.timeout = timeout;
		this.password = password;
		this.database = database;

		HostAndPort salve = initSentinels(sentinels, masterName);
		initPool(salve);
	}

	public void returnBrokenResource(final Jedis resource) {
		returnBrokenResourceObject(resource);
	}

	public void returnResource(final Jedis resource) {
		resource.resetState();
		returnResourceObject(resource);
	}

	private volatile HostAndPort currentHostSalve;

	public void destroy() {
		for (SalveListener m : salveListeners) {
			m.shutdown();
		}

		super.destroy();
	}

	public HostAndPort getCurrentHostSalve() {
		return currentHostSalve;
	}

	private void initPool(HostAndPort salve) {
		if (!salve.equals(currentHostSalve)) {
			currentHostSalve = salve;
			log.info("Created JedisPool to salve at " + salve);
			initPool(poolConfig, new JedisSalveFactory(salve.getHost(), salve.getPort(), timeout, password, database));
		}
	}

	private HostAndPort initSentinels(Set<String> sentinels, final String masterName) {

		HostAndPort salve = null;
		boolean running = true;

		outer: while (running) {

			log.info("Trying to find salve from available Sentinels...");

			for (String sentinel : sentinels) {

				final HostAndPort hap = toHostAndPort(Arrays.asList(sentinel.split(":")));

				log.fine("Connecting to Sentinel " + hap);

				try {
					Jedis jedis = new Jedis(hap.getHost(), hap.getPort());

					if (salve == null) {
						salve = toHostAndPortSalve(jedis.sentinelSlaves(masterName));
						if (salve == null) {
							log.fine("do not Found Redis salve ");
						} else {
							log.fine("Found Redis salve at " + salve);
						}

						jedis.disconnect();
						break outer;
					}
				} catch (JedisConnectionException e) {
					log.warning("Cannot connect to sentinel running @ " + hap + ". Trying next one.");
				}
			}

			try {
				log.severe("All sentinels down, cannot determine where is " + masterName
						+ " salve is running... sleeping 1000ms.");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		log.info("Redis salve running at " + salve + ", starting Sentinel listeners...");

		for (String sentinel : sentinels) {
			final HostAndPort hap = toHostAndPort(Arrays.asList(sentinel.split(":")));
			SalveListener salveListener = new SalveListener(masterName, hap.getHost(), hap.getPort());
			salveListeners.add(salveListener);
			salveListener.start();
		}

		return salve;
	}

	private HostAndPort toHostAndPortSalve(List<Map<String, String>> sentinelSlaves) {
		for (Map<String, String> map : sentinelSlaves) {
			if (map.get("flags").equals("slave")) {
				String host = map.get("ip");
				int port = Integer.parseInt(map.get("port"));
				return new HostAndPort(host, port);
			}
		}
		return null;
	}

	private HostAndPort toHostAndPort(List<String> getMasterAddrByNameResult) {
		String host = getMasterAddrByNameResult.get(0);
		int port = Integer.parseInt(getMasterAddrByNameResult.get(1));

		return new HostAndPort(host, port);
	}

	protected class JedisPubSubAdapter extends JedisPubSub {
		@Override
		public void onMessage(String channel, String message) {
		}

		@Override
		public void onPMessage(String pattern, String channel, String message) {
		}

		@Override
		public void onPSubscribe(String pattern, int subscribedChannels) {
		}

		@Override
		public void onPUnsubscribe(String pattern, int subscribedChannels) {
		}

		@Override
		public void onSubscribe(String channel, int subscribedChannels) {
		}

		@Override
		public void onUnsubscribe(String channel, int subscribedChannels) {
		}
	}

	protected class SalveListener extends Thread {

		protected String masterName;
		protected String host;
		protected int port;
		protected long subscribeRetryWaitTimeMillis = 5000;
		protected Jedis j;
		protected AtomicBoolean running = new AtomicBoolean(false);

		protected SalveListener() {
		}

		public SalveListener(String masterName, String host, int port) {
			this.masterName = masterName;
			this.host = host;
			this.port = port;
		}

		public SalveListener(String masterName, String host, int port, long subscribeRetryWaitTimeMillis) {
			this(masterName, host, port);
			this.subscribeRetryWaitTimeMillis = subscribeRetryWaitTimeMillis;
		}

		public void run() {

			running.set(true);

			while (running.get()) {

				j = new Jedis(host, port);

				try {
					j.subscribe(new JedisPubSubAdapter() {
						@Override
						public void onMessage(String channel, String message) {
							log.fine("Sentinel " + host + ":" + port + " published: " + message + ".");

							String[] switchMasterMsg = message.split(" ");

							if (switchMasterMsg.length > 3) {

								if (masterName.equals(switchMasterMsg[0])) {
									log.fine("master change ,find salve");
									Jedis jedis = new Jedis(host, port);
									HostAndPort salve = toHostAndPortSalve(jedis.sentinelSlaves(masterName));
									initPool(salve);

								} else {
									log.fine("Ignoring message on +switch-master for master name " + switchMasterMsg[0]
											+ ", our master name is " + masterName);
								}

							} else {
								log.severe("Invalid message received on Sentinel " + host + ":" + port
										+ " on channel +switch-master: " + message);
							}
						}
					}, "+switch-master");

				} catch (JedisConnectionException e) {

					if (running.get()) {
						log.severe("Lost connection to Sentinel at " + host + ":" + port
								+ ". Sleeping 5000ms and retrying.");
						try {
							Thread.sleep(subscribeRetryWaitTimeMillis);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					} else {
						log.fine("Unsubscribing from Sentinel at " + host + ":" + port);
					}
				}
			}
		}

		public void shutdown() {
			try {
				log.fine("Shutting down listener on " + host + ":" + port);
				running.set(false);
				// This isn't good, the Jedis object is not thread safe
				j.disconnect();
			} catch (Exception e) {
				log.severe("Caught exception while shutting down: " + e.getMessage());
			}
		}
	}
}