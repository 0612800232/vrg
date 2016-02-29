package com.lee.vrg.common.log;

import org.apache.log4j.*;


public class LogAppender extends DailyRollingFileAppender {
	@Override
	public boolean isAsSevereAsThreshold(Priority priority) {
		return this.getThreshold().equals(priority);
	}
}
