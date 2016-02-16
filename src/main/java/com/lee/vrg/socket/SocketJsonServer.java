package com.lee.vrg.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SocketJsonServer implements Runnable {
	@Value("${socket.nio.server.port:6090}")
	private int port = 6090;

	@Autowired
	private SocketJsonServerInitializer socketJsonServerInitializer;

	private Thread runThread;

	public void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(socketJsonServerInitializer);

			b.bind(port).sync().channel().closeFuture().sync();

		} catch (InterruptedException close) {

		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	@PostConstruct
	public void init() {
		this.runThread = new Thread(this, "start netty thread");
		this.runThread.start();
	}

	@PreDestroy
	public void shutdown() {
		this.runThread.interrupt();
	}
}
