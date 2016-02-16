package com.lee.vrg.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component("redisUtil")
public class RedisUtil {
	private static Logger LOG = LoggerFactory.getLogger(RedisUtil.class);
	@Autowired
	private StringRedisTemplate writeRedisTemplate;

	@Autowired
	private StringRedisTemplate readRedisTemplate;

	@Value("${redis.expire}")
	private String expire;

	ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool(5);

	private Map<String, Set<String>> cacheSetmMap = new HashMap<String, Set<String>>();

	/**
	 * 设置存活时间，默认一个月
	 * 
	 * @param key
	 * @param sec
	 * @return
	 */
	public boolean expire(String key, long sec) {
		return writeRedisTemplate.expire(key, sec, TimeUnit.SECONDS);
	}

	public boolean expire(String key) {
		return writeRedisTemplate.expire(key, Long.valueOf(expire), TimeUnit.SECONDS);
	}

	/**
	 * 压栈
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Long push(String key, String value) {
		long res = writeRedisTemplate.opsForList().leftPush(key, value);
		expire(key);
		return res;
	}

	/**
	 * 出栈
	 * 
	 * @param key
	 * @return
	 */
	public String pop(String key) {
		String res = writeRedisTemplate.opsForList().leftPop(key);
		expire(key);
		return res;
	}

	/**
	 * 入队
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Long in(String key, String value) {
		Long res = writeRedisTemplate.opsForList().rightPush(key, value);
		expire(key);
		return res;
	}

	/**
	 * 出队
	 * 
	 * @param key
	 * @return
	 */
	public String out(String key) {
		String res = writeRedisTemplate.opsForList().leftPop(key);
		expire(key);
		return res;
	}

	/**
	 * 栈/队列长
	 * 
	 * @param key
	 * @return
	 */
	public Long length(String key) {
		return readRedisTemplate.opsForList().size(key);
	}

	/**
	 * 范围检索
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public List<String> range(String key, int start, int end) {
		return readRedisTemplate.opsForList().range(key, start, end);
	}

	/**
	 * 移除
	 * 
	 * @param key
	 * @param i
	 * @param value
	 */
	public void remove(String key, long i, String value) {
		writeRedisTemplate.opsForList().remove(key, i, value);
	}

	/**
	 * 检索
	 * 
	 * @param key
	 * @param index
	 * @return
	 */
	public String index(String key, long index) {
		return readRedisTemplate.opsForList().index(key, index);
	}

	/**
	 * 置值
	 * 
	 * @param key
	 * @param index
	 * @param value
	 */
	public void set(String key, long index, String value) {
		writeRedisTemplate.opsForList().set(key, index, value);
	}

	public boolean exist(String key) {
		return readRedisTemplate.hasKey(key);
	}

	public void delKey(String key) {
		writeRedisTemplate.delete(key);
	}

	public void inMap(String key, String hashKey, String value) {
		writeRedisTemplate.opsForHash().put(key, hashKey, value);
		expire(key);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void inMap(String key, Map map) {
		writeRedisTemplate.opsForHash().putAll(key, map);
	}

	public long getMapSize(String key) {
		return readRedisTemplate.opsForHash().size(key);
	}

	public void outMap(String key, String hashKey) {
		if (exist(key) && hashKey != null) {
			writeRedisTemplate.opsForHash().delete(key, hashKey);
		}
	}

	public String getFromMap(String key, String hashKey) {
		if (exist(key) && hashKey != null) {
			return (String) readRedisTemplate.opsForHash().get(key, hashKey);
		} else {
			return null;
		}
	}

	public String getAndReMoveMap(String key, String hashKey) {
		if (exist(key) && hashKey != null) {
			String value = (String) writeRedisTemplate.opsForHash().get(key, hashKey);
			writeRedisTemplate.opsForHash().delete(key, hashKey);
			return value;
		} else {
			return null;
		}
	}

	public Map<Object, Object> getMap(String key) {
		if (exist(key)) {
			return readRedisTemplate.opsForHash().entries(key);
		} else {
			return null;
		}

	}

	public boolean isInMap(String key, String hashKey) {
		return readRedisTemplate.opsForHash().hasKey(key, hashKey);
	}

	/**
	 * 裁剪
	 * 
	 * @param key
	 * @param start
	 * @param end
	 */
	public void trim(String key, long start, int end) {
		writeRedisTemplate.opsForList().trim(key, start, end);
	}

	public void addToSet(String key, String value, Double score) {
		writeRedisTemplate.opsForZSet().add(key, value, score);
		expire(key);
	}

	public void addToSet(String key, String value, Double score, int sec) {
		writeRedisTemplate.opsForZSet().add(key, value, score);
		expire(key, sec);
	}

	public long getSetSize(String key) {
		if (!exist(key)) {
			return 0;
		}
		return readRedisTemplate.opsForZSet().size(key);
	}

	public String getFromSet(String key) {
		if (!exist(key)) {
			return null;
		}

		Set<String> s = readRedisTemplate.opsForZSet().reverseRange(key, 0, 1);
		if (s.size() == 0) {
			return null;
		} else {
			Object[] strings = s.toArray();
			return (String) strings[0];
		}
	}

	public String getAndRemoveFromSet(String key) {
		if (!exist(key)) {
			return null;
		}
		Set<String> s = writeRedisTemplate.opsForZSet().range(key, 0, 0);

		if (s.size() == 0) {
			return null;
		} else {
			Object[] strings = s.toArray();
			writeRedisTemplate.opsForZSet().remove(key, strings[0]);
			return (String) strings[0];
		}
	}

	/**
	 * 将时间转为double
	 * 
	 * @return
	 */
	double getScore() {
		DateFormat df = new SimpleDateFormat("yyyyMMdd.HHmmss");
		try {
			return Double.parseDouble(df.format(new Date()));
		} catch (Exception e) {

		}
		return 0D;
	}

	public void rebaseCache() {
		Set<Entry<String, Set<String>>> mEntries = cacheSetmMap.entrySet();
		for (Entry<String, Set<String>> entry : mEntries) {
			String redisKey = entry.getKey();
			Set<String> hashKeySet = entry.getValue();
			for (String hashKey : hashKeySet) {
				writeRedisTemplate.opsForZSet().add(redisKey, hashKey, getScore());
			}
		}
		cacheSetmMap.clear();
	}

	public String getAndRemoveFromSetCache(String key) {

		if (cacheSetmMap.get(key) == null || cacheSetmMap.get(key).size() == 0) {
			if (!exist(key)) {
				return null;
			}
			Set<String> s = writeRedisTemplate.opsForZSet().reverseRange(key, 0, 20);
			if (s.size() != 0) {
				Object[] strings = s.toArray();
				writeRedisTemplate.opsForZSet().remove(key, strings);
				cacheSetmMap.put(key, s);
				return (String) strings[0];
			} else {
				return null;
			}
		} else {
			Set<String> set = cacheSetmMap.get(key);
			Object[] strings = set.toArray();
			set.remove(strings[0]);
			return (String) strings[0];
		}

	}

	public String getFromSetCache(String key) {

		if (cacheSetmMap.get(key) == null || cacheSetmMap.get(key).size() == 0) {
			if (!exist(key)) {
				return null;
			}
			Set<String> s = readRedisTemplate.opsForZSet().reverseRange(key, 0, 20);
			if (s.size() != 0) {
				Object[] strings = s.toArray();
				cacheSetmMap.put(key, s);
				return (String) strings[0];
			} else {
				return null;
			}
		} else {
			Set<String> set = cacheSetmMap.get(key);
			Object[] strings = set.toArray();
			return (String) strings[0];
		}

	}

	public Long removeFromSet(String key, String value) {
		if (exist(key) && value != null) {
			return writeRedisTemplate.opsForZSet().remove(key, value);
		}
		return 0L;

	}

	public void inMap(String key, String hashKey, String value, int sec) {
		writeRedisTemplate.opsForHash().put(key, hashKey, value);
		expire(key, sec);
	}

	public void addToSetDelay(final String key, final String value, final Double score) {
		Runnable task = new Runnable() {
			public void run() {
				writeRedisTemplate.opsForZSet().add(key, value, score);
				expire(key);
			}
		};

		scheduExec.schedule(task, 60, TimeUnit.SECONDS);

	}

	public StringRedisTemplate getWriteRedisTemplate() {
		return writeRedisTemplate;
	}

	public void setWriteRedisTemplate(StringRedisTemplate writeRedisTemplate) {
		this.writeRedisTemplate = writeRedisTemplate;
	}

	public StringRedisTemplate getReadRedisTemplate() {
		return readRedisTemplate;
	}

	public void setReadRedisTemplate(StringRedisTemplate readRedisTemplate) {
		this.readRedisTemplate = readRedisTemplate;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public ScheduledExecutorService getScheduExec() {
		return scheduExec;
	}

	public void setScheduExec(ScheduledExecutorService scheduExec) {
		this.scheduExec = scheduExec;
	}

	public Map<String, Set<String>> getCacheSetmMap() {
		return cacheSetmMap;
	}

	public void setCacheSetmMap(Map<String, Set<String>> cacheSetmMap) {
		this.cacheSetmMap = cacheSetmMap;
	}
	
	
	

}
