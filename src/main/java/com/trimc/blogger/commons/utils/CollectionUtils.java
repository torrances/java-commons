package com.trimc.blogger.commons.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {

	public static Collection<String> reverse(Collection<String> collection) {
		List<String> list = toList(collection);

		List<String> reversed = new ArrayList<String>();
		for (int i = list.size() - 1; i >= 0; i--)
			reversed.add(list.get(i));

		return reversed;
	}

	public static Collection<String> toLowerCase(Collection<String> collection) {
		List<String> master = new ArrayList<String>();

		for (String value : collection)
			master.add(value.toLowerCase());

		return master;
	}

	public static Collection<String> toUpperCase(Collection<String> collection) {
		List<String> master = new ArrayList<String>();

		for (String value : collection)
			master.add(value.toUpperCase());

		return master;
	}

	public static List<String> toList(Collection<String> collection) {
		List<String> list = new ArrayList<String>();

		for (String value : collection)
			list.add(value);

		return list;
	}

	public static List<String> toList2(Collection<? extends Collection<String>> collections) {
		List<String> list = new ArrayList<String>();

		for (Collection<String> collection : collections)
			list.addAll(toList(collection));

		return list;
	}
}
