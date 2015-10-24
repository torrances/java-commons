package com.trimc.blogger.commons.utils.string;

import com.trimc.blogger.commons.LogManager;

public class StringUtils$Pad {

	public static LogManager logger = new LogManager(StringUtils.class);

	protected static String pad(int x, int places, String padding) {
		String value = String.valueOf(x);

		while (value.length() < places)
			value = padding.concat(value);

		return value;
	}

	protected static String pad(String x, int places, String padding) {
		try {

			String value = String.valueOf(x);
			while (value.length() < places)
				value = padding.concat(value);

			return value;

		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}
}
