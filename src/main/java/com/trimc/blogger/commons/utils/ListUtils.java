package com.trimc.blogger.commons.utils;

import java.util.ArrayList;
import java.util.List;

public final class ListUtils {

	public static List<String> toList(String... values) {
		List<String> list = new ArrayList<String>();

		for (String value : values)
			list.add(value);

		return list;
	}
}
