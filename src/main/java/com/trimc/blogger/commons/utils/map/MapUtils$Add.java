package com.trimc.blogger.commons.utils.map;

import java.util.Map;

import com.trimc.blogger.commons.LogManager;

public class MapUtils$Add {

	public static LogManager logger = new LogManager(MapUtils.class);

	protected static void add2Map(Map<String, String> map, Map<String, String> _map) {
		for (Map.Entry<String, String> entry : _map.entrySet()) {
			Integer _value = (map.containsKey(entry.getKey())) ? Integer.parseInt(map.get(entry.getKey())) : 0;
			map.put(entry.getKey(), String.valueOf((_value + Integer.parseInt(entry.getValue()))));
		}
	}

	protected static void add2Map(Map<String, String> map, String str) {
		int x = 0;
		if (map.containsKey(str)) x = (int) Integer.parseInt((String) map.get(str));
		map.put(str, String.valueOf(++x));
	}

	protected static void add2Map2(Map<String, Double> map, String str) {
		Double x = 0d;
		if (map.containsKey(str)) x = map.get(str);
		map.put(str, ++x);
	}
}
