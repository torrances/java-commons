package com.trimc.blogger.commons.utils.string;

import com.trimc.blogger.commons.LogManager;

public class StringUtils$UnicodeNormalization {

	public static LogManager logger = new LogManager(StringUtils.class);

	protected static char unicodeNormalization(char ch) {

		if ('á' == ch)
			return 'a';
		if ('ã' == ch)
			return 'a';

		if ('é' == ch)
			return 'e';

		if ('í' == ch)
			return 'i';

		if ('ñ' == ch)
			return 'n';

		if ('ó' == ch)
			return 'o';

		if ('ú' == ch)
			return 'u';
		if ('ü' == ch)
			return 'u';

		return ch;
	}

	protected static String unicodeNormalization(String text) {
		StringBuilder sb = new StringBuilder();

		for (char ch : text.toCharArray())
			sb.append(String.valueOf(unicodeNormalization(ch)));

		return sb.toString();
	}
}
