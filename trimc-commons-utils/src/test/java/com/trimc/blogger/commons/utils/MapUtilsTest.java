package com.trimc.blogger.commons.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.trimc.blogger.commons.dto.KeyValue;
import com.trimc.blogger.commons.utils.map.MapUtils;

public final class MapUtilsTest {

	@Test
	public void asc() throws Throwable {
		KeyValue<Object, Integer>[] sorted = MapUtils.asc(getMap());
		assertNotNull(sorted);

		assertEquals(10, sorted.length);

		assertEquals("eta", sorted[9].key());
		assertEquals("gamma", sorted[8].key());
		assertEquals("alpha", sorted[7].key());
		assertEquals("epsilon", sorted[6].key());
		assertEquals("delta", sorted[5].key());
		assertEquals("beta", sorted[4].key());
		assertEquals("digamma", sorted[3].key());
		assertEquals("theta", sorted[2].key());
		assertEquals("omega", sorted[1].key());
		assertEquals("ka", sorted[0].key());
	}

	@Test
	public void desc() throws Throwable {
		KeyValue<Object, Integer>[] sorted = MapUtils.desc(getMap());
		assertNotNull(sorted);

		assertEquals(10, sorted.length);

		assertEquals("eta", sorted[0].key());
		assertEquals("gamma", sorted[1].key());
		assertEquals("alpha", sorted[2].key());
		assertEquals("epsilon", sorted[3].key());
		assertEquals("delta", sorted[4].key());
		assertEquals("beta", sorted[5].key());
		assertEquals("digamma", sorted[6].key());
		assertEquals("theta", sorted[7].key());
		assertEquals("omega", sorted[8].key());
		assertEquals("ka", sorted[9].key());
	}

	private Map<String, String> getMap() throws Throwable {
		Map<String, String> map = new TreeMap<String, String>();

		map.put("alpha", "100");
		map.put("beta", "10");
		map.put("gamma", "200");
		map.put("delta", "20");
		map.put("epsilon", "50");
		map.put("digamma", "5");
		map.put("theta", "1");
		map.put("eta", "999");
		map.put("ka", "-23");
		map.put("omega", "0");

		return map;
	}
}
