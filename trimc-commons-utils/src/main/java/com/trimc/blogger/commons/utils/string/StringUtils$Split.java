package com.trimc.blogger.commons.utils.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.trimc.blogger.commons.LogManager;

public class StringUtils$Split {

	public static LogManager logger = new LogManager(StringUtils.class);

	protected static Collection<String> split(String value, int length, boolean force) {
		List<String> list = new ArrayList<String>();

		int total = 0;
		StringBuilder sb = new StringBuilder();

		String[] tokens = value.split(" ");
		for (int i = 0; i < tokens.length; i++) {

			total += tokens[i].length();
			sb.append(tokens[i] + " ");

			if (total >= length) {
				list.add(StringUtils.trim(sb.toString()));
				sb = new StringBuilder();
				total = 0;
			}
		}

		list.add(sb.toString().trim());
		return list;
	}
}
