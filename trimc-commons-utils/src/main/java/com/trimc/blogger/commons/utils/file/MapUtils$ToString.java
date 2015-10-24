package com.trimc.blogger.commons.utils.file;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.utils.SetUtils;

public class MapUtils$ToString {

	public static LogManager logger = new LogManager(MapUtils.class);

	protected static String toString1(Map<?, ?> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<?> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			sb.append(key + ", " + map.get(key));
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	protected static String toString1ValueFirst(Map<?, ?> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<?> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			sb.append(map.get(key) + ", " + key);
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	protected static String toString2(Map<String, Collection<String>> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			sb.append(key + ", " + SetUtils.toString(map.get(key), ","));
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	protected static String toString2ValueFirst(Map<String, Collection<String>> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			sb.append(SetUtils.toString(map.get(key), ",") + ", " + key);
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	protected static String toString3(Map<String, Set<String>> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			sb.append(key + ", " + SetUtils.toString(map.get(key), ","));
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	protected static String toString3ValueFirst(Map<String, Set<String>> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			sb.append(SetUtils.toString(map.get(key), ",") + ", " + key);
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	protected static String toString4(Map<Integer, String> map, String delimiter) {
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

	protected static String toString4ValueFirst(Map<Integer, String> map, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Integer key = iter.next();
			String value = map.get(key);
			sb.append(value + ", " + key);
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}
}
