package com.trimc.blogger.commons.utils;

public final class GraphUtils {

	public static String toId(String value) {
		if (!StringUtils.hasValue(value)) return null;

		value = StringUtils.trim(value.toUpperCase());
		value = value.replaceAll(" ", "_");

		return value;
	}
}
