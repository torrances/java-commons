package com.trimc.blogger.commons.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.trimc.blogger.commons.utils.string.StringUtils;

public final class MapUtils {

	public static void add2Map(Map<String, String> map, Map<String, String> _map) {
		for (Map.Entry<String, String> entry : _map.entrySet()) {
			Integer _value = (map.containsKey(entry.getKey())) ? Integer.parseInt(map.get(entry.getKey())) : 0;
			map.put(entry.getKey(), String.valueOf((_value + Integer.parseInt(entry.getValue()))));
		}
	}

	public static void add2Map(Map<String, String> map, String str) {
		int x = 0;
		if (map.containsKey(str)) x = (int) Integer.parseInt((String) map.get(str));
		map.put(str, String.valueOf(++x));
	}

	public static void add2Map2(Map<String, Double> map, String str) {
		Double x = 0d;
		if (map.containsKey(str)) x = map.get(str);
		map.put(str, ++x);
	}

	public static void merge(Map<String, Set<String>> master, Map<String, Set<String>> map) {
		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
			Set<String> inner = (master.containsKey(entry.getKey())) ? master.get(entry.getKey()) : new TreeSet<String>();
			inner.addAll(entry.getValue());
			master.put(entry.getKey(), inner);
		}
	}

	public static void putIntoSet(Map<String, Set<String>> map, String key, String value) {
		if (!StringUtils.hasValue(key)) return;
		if (!StringUtils.hasValue(value)) return;
		if (null == map) return;

		Set<String> set = map.containsKey(key) ? map.get(key) : new TreeSet<String>();
		set.add(value);
		map.put(key, set);
	}

	public static String toString1(Map<?, ?> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<?> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			sb.append(key + ", " + map.get(key));
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	public static String toString2(Map<String, Collection<String>> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			sb.append(key + ", " + SetUtils.toString(map.get(key), ","));
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	public static String toString3(Map<String, Set<String>> map, String delimiter) {

		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			sb.append(key + ", " + SetUtils.toString(map.get(key), ","));
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	public static String toString4(Map<Integer, String> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Integer key = iter.next();
			String value = map.get(key);
			sb.append(key + ", " + value);
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}
}
