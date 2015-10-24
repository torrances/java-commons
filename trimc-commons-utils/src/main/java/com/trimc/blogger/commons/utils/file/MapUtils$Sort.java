package com.trimc.blogger.commons.utils.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.dto.KeyValue;
import com.trimc.blogger.commons.dto.adapter.KeyValueAdapter;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.utils.SetUtils;
import com.trimc.blogger.commons.utils.string.StringUtils;

public class MapUtils$Sort {

	public static LogManager logger = new LogManager(MapUtils.class);

	@SuppressWarnings("unchecked")
	protected static KeyValue<Object, Integer>[] asc(Map<?, ?> map) throws BusinessException {
		List<KeyValue<Object, Integer>> list = new ArrayList<KeyValue<Object, Integer>>();

		Map<String, List<Object>> tmp = invert(map);
		for (String sIntKey : tmp.keySet())
			for (Object value : tmp.get(sIntKey))
				list.add(KeyValueAdapter.transform(value, toInteger(sIntKey)));

		return (KeyValue<Object, Integer>[]) list.toArray(new KeyValue[list.size()]);
	}

	@SuppressWarnings("unchecked")
	protected static KeyValue<Object, Integer>[] desc(Map<?, ?> map) throws BusinessException {
		List<KeyValue<Object, Integer>> list = new ArrayList<KeyValue<Object, Integer>>();

		Map<String, List<Object>> tmp = invert(map);
		for (String sIntKey : SetUtils.reverse(tmp.keySet()))
			for (Object value : tmp.get(sIntKey))
				list.add(KeyValueAdapter.transform(value, toInteger(sIntKey)));

		return (KeyValue<Object, Integer>[]) list.toArray(new KeyValue[list.size()]);
	}

	private static Map<String, List<Object>> invert(Map<?, ?> map) throws BusinessException {
		Map<String, List<Object>> tmp = new TreeMap<String, List<Object>>();

		for (Map.Entry<?, ?> entry : map.entrySet()) {
			String sIntKey = toString(entry.getValue());
			List<Object> innerList = tmp.containsKey(sIntKey) ? tmp.get(sIntKey) : new ArrayList<Object>();
			innerList.add(entry.getKey());
			tmp.put(sIntKey, innerList);
		}

		return tmp;
	}

	private static Integer toInteger(String sIntKey) throws BusinessException {
		while (sIntKey.startsWith("0") && sIntKey.length() > 1)
			sIntKey = sIntKey.substring(1, sIntKey.length());
		return Integer.parseInt(sIntKey);
	}

	private static String toString(Object value) throws BusinessException {
		Integer nObj = Integer.parseInt(String.valueOf(value));
		return StringUtils.pad(nObj, 50);
	}
}
