package org.tartarus.snowball;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.tartarus.snowball.custom.Stemmer;

import com.trimc.blogger.commons.utils.SetUtils;

public class StemmerTest {

	@Test
	public void cluster() throws Throwable {
		assertEquals(2, new Stemmer().cluster("location", "locations", "locator", "clustering", "clustered", "clusters").size());

		Map<String, Set<String>> map = new Stemmer().cluster("location", "locations", "locator", "clustering", "clustered", "clusters");
		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {

			if ("cluster".equals(entry.getKey())) assertEquals("clustered, clustering, clusters", SetUtils.toString(entry.getValue(), ", "));
			else if ("locat".equals(entry.getKey())) assertEquals("location, locations, locator", SetUtils.toString(entry.getValue(), ", "));
		}
	}

	@Test
	public void stem() throws Throwable {
		String stem = new Stemmer().stem("seacaves");
		assertNotNull(stem);
		assertEquals("seacav", stem);
	}

	@Test
	public void stemToList() throws Throwable {
		List<String> list = new Stemmer().stemToList("chlorine demand resistance against".split(" "));
		assertNotNull(list);
		assertFalse(list.isEmpty());
		assertEquals("chlorin, demand, resist, against", SetUtils.toString(list, ", "));
	}

	@Test
	public void stemToSet() throws Throwable {
		assertEquals(1, new Stemmer().stemToSet("location", "locations", "locator", "locating", "located").size());
	}
}
