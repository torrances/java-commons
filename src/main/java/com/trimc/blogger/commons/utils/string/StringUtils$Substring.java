package com.trimc.blogger.commons.utils.string;

import com.trimc.blogger.commons.LogManager;

public class StringUtils$Substring {

	public static LogManager logger = new LogManager(StringUtils.class);

	protected static String substringAfter(String text, String... delims) {
		for (String delimiter : delims) {
			if (text.indexOf(delimiter) != -1) {
				text = substringAfter(text, delimiter);
			}
		}

		return text.trim();
	}

	protected static String substringAfter(String text, String del) {
		String result = "";

		if (text != null) {
			int pos = text.indexOf(del);
			if (pos != -1) {
				if (pos < text.length()) {
					result = text.substring(pos + del.length());
				}
			}
		}

		return result.trim();
	}

	protected static String substringAfterLast(String text, String delim) {
		String returnStr = "";

		if (text != null && text.length() > 0) {
			int lastPos = text.lastIndexOf(delim);
			if ((lastPos != -1) && (lastPos < text.length())) {
				returnStr = text.substring(lastPos + delim.length());
			}
		}

		return returnStr;
	}

	protected static String substringBefore(String text, String del) {
		String result = "";

		if (text != null) {
			int pos = text.indexOf(del);
			if (pos > 0) {
				result = text.substring(0, pos);
			}
		}

		return result;
	}

	protected static String substringBeforeLast(String text, String delim) {
		String returnStr = "";

		if (text != null && text.length() > 0) {
			int lastPos = text.lastIndexOf(delim);
			if ((lastPos != -1) && (lastPos > 0)) {
				returnStr = text.substring(0, lastPos);
			}
		}

		return returnStr.trim();
	}
}
