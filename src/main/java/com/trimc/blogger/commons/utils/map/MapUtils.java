package com.trimc.blogger.commons.utils.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.trimc.blogger.commons.utils.string.StringUtils;

public final class MapUtils {

	public static void add2Map(Map<String, String> map, Map<String, String> _map) {
		MapUtils$Add.add2Map(map, _map);
	}

	public static void add2Map(Map<String, String> map, String str) {
		MapUtils$Add.add2Map(map, str);
	}

	public static void add2Map2(Map<String, Double> map, String str) {
		MapUtils$Add.add2Map2(map, str);
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
		return MapUtils$ToString.toString1(map, delimiter);
	}

	public static String toString1ValueFirst(Map<?, ?> map, String delimiter) {
		return MapUtils$ToString.toString1ValueFirst(map, delimiter);
	}

	public static String toString2(Map<String, Collection<String>> map, String delimiter) {
		return MapUtils$ToString.toString2(map, delimiter);
	}

	public static String toString2ValueFirst(Map<String, Collection<String>> map, String delimiter) {
		return MapUtils$ToString.toString2ValueFirst(map, delimiter);
	}

	public static String toString3(Map<String, Set<String>> map, String delimiter) {
		return MapUtils$ToString.toString3(map, delimiter);
	}

	public static String toString3ValueFirst(Map<String, Set<String>> map, String delimiter) {
		return MapUtils$ToString.toString3ValueFirst(map, delimiter);
	}

	public static String toString4(Map<Integer, String> map, String delimiter) {
		return MapUtils$ToString.toString4(map, delimiter);
	}

	public static String toString4ValueFirst(Map<Integer, String> map, String delimiter) {
		return MapUtils$ToString.toString4ValueFirst(map, delimiter);
	}
}
