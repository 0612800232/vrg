package com.lee.vrg.socket;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class Global {
	public static Map<String, ChannelGroup> groups = new HashMap<String, ChannelGroup>();

	static {
		groups.put("sh", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groups.put("sz", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groups.put("us", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groups.put("hk", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
		groups.put("zs", new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
	}

}
