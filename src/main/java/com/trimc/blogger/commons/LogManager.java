package com.trimc.blogger.commons;

import org.apache.log4j.Logger;

public class LogManager {

	private Logger	logger;

	public LogManager(Class<?> clazz) {
		setLogger(Logger.getLogger(clazz));
	}

	public void debug(String statement, Object... args) {
		getLogger().debug(format(statement, args));
	}

	public void error(String statement, Object... args) {
		getLogger().error(format(statement, args));
	}

	public void error(Throwable t) {
		getLogger().error("", t);
	}

	public void error(Throwable t, String statement, Object... args) {
		getLogger().error(format(statement, args), t);
	}

	private String format(String query, Object... args) {
		StringBuilder sb = new StringBuilder();

		if (0 != args.length) {
			sb.append(String.format(query, args));
		} else {
			sb.append(query);
		}

		return sb.toString();
	}

	private Logger getLogger() {
		return logger;
	}

	public void info(String statement, Object... args) {
		getLogger().info(format(statement, args));
	}

	private void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void trace(String statement, Object... args) {
		getLogger().trace(format(statement, args));
	}

	public void warn(String statement, Object... args) {
		getLogger().warn(format(statement, args));
	}
}
