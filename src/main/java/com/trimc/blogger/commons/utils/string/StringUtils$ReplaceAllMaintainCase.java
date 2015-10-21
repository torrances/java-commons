package com.trimc.blogger.commons.utils.string;

import com.trimc.blogger.commons.LogManager;

public class StringUtils$ReplaceAllMaintainCase {

	public static LogManager logger = new LogManager(StringUtils.class);

	protected static String replaceAllMaintainCase(String line, String key, String value) {

		String _line = line.toLowerCase();
		String _key = key.toLowerCase();

		int x = _line.indexOf(_key);
		if (x == -1)
			return line;

		int y = x + _key.length();

		StringBuilder sb = new StringBuilder();
		sb.append(line.substring(0, x));

		sb.append(" ");
		if (StringUtils.hasValue(value)) {
			sb.append(value);
			sb.append(" ");
		}

		sb.append(line.substring(y));

		return StringUtils.trim(sb.toString());
	}
}
