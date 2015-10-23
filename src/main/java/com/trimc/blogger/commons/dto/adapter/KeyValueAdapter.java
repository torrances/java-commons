package com.trimc.blogger.commons.dto.adapter;

import com.trimc.blogger.commons.dto.KeyValue;
import com.trimc.blogger.commons.exception.AdapterValidationException;

public final class KeyValueAdapter {

	public static String toString(KeyValue<?, ?> keyValue) throws AdapterValidationException {
		StringBuilder sb = new StringBuilder();

		sb.append(keyValue.key() + ", " + keyValue.value());

		return sb.toString();
	}
	
	public static String toString(KeyValue<?, ?>[] keyValues, String delimiter) throws AdapterValidationException {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < keyValues.length; i++) {
			sb.append(KeyValueAdapter.toString(keyValues[i]));
			if (i + 1 < keyValues.length) sb.append(delimiter);
		}

		return sb.toString();
	}

	public static KeyValue<Object, Integer> transform(Object key, Integer value) throws AdapterValidationException {
		return new KeyValue<Object, Integer>(key, value);
	}
}
