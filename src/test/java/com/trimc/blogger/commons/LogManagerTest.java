package com.trimc.blogger.commons;

import org.junit.Test;

public final class LogManagerTest {

	public static LogManager	logger	= new LogManager(LogManagerTest.class);

	@Test
	public void run() throws Throwable {
		logger.info("test: %s", 42);
	}
}
