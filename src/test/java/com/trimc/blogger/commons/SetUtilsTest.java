package com.trimc.blogger.commons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.trimc.blogger.commons.utils.SetUtils;

public final class SetUtilsTest {

	@Test
	public void memberOf_Char() throws Throwable {
		assertTrue(SetUtils.memberOf('a', 'a', 'b', 'c'));
		assertFalse(SetUtils.memberOf('z', 'a', 'b', 'c'));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void merge() throws Throwable {

		Set<Integer> s1 = new TreeSet<Integer>();
		s1.add(100);
		s1.add(200);

		Set<Integer> s2 = new TreeSet<Integer>();
		s2.add(200);
		s2.add(300);

		assertEquals(3, SetUtils.merge(s1, s2).size());
	}

	@Test
	public void reverse() throws Throwable {
		Collection<String> set1 = SetUtils.toSet("010", "020", "030", "040", "050");
		Collection<String> set2 = SetUtils.reverse(set1);
		assertEquals("050, 040, 030, 020, 010", SetUtils.toString(set2, ", "));
	}

	@Test
	public void toStringTest() throws Throwable {
		Set<Integer> set = new TreeSet<Integer>();
		set.add(124134);
		set.add(98984);
		set.add(127);
		set.add(0);
		assertEquals("0, 127, 98984, 124134", SetUtils.toString(set, ", "));
	}
}
