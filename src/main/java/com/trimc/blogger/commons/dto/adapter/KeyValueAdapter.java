package com.trimc.blogger.commons.dto.adapter;

import com.trimc.blogger.commons.dto.KeyValue;
import com.trimc.blogger.commons.exception.AdapterValidationException;

public final class KeyValueAdapter {

	public static KeyValue<Object, Integer> transform(Object key, Integer value) throws AdapterValidationException {
		return new KeyValue<Object, Integer>(key, value);
	}
}
