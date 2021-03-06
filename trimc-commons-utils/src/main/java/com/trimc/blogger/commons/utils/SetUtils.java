package com.trimc.blogger.commons.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.trimc.blogger.commons.utils.string.StringUtils;

public final class SetUtils {

	public static boolean memberOf(char value, char... chs) {
		for (char ch : chs)
			if (value == ch) return true;
		return false;
	}

	public static boolean memberOf(String value, Collection<String> array) {
		// Note that this is an extremely inefficient method of determining
		// membership on large collections; it should be used only for very small data sets
		return memberOf(value, (String[]) array.toArray(new String[array.size()]));
	}

	public static boolean memberOf(String value, String[] array) {
		for (String token : array) {
			if (token.equals(value)) {
				return true;
			}
		}

		return false;
	}

	public static boolean memberOfCaseInsensitive(String value, Collection<String> tokens) {
		return memberOfCaseInsensitive(value, toArray1(tokens));
	}

	public static boolean memberOfCaseInsensitive(String value, String... tokens) {
		if (!StringUtils.hasValue(value)) return false;

		value = value.toLowerCase();
		for (String token : tokens) {
			if (token.equalsIgnoreCase(value)) {
				return true;
			}
		}

		return false;
	}

	public static Set<Integer> merge(@SuppressWarnings("unchecked") Set<Integer>... sets) {
		Set<Integer> universal = new TreeSet<Integer>();

		for (Set<Integer> set : sets)
			universal.addAll(set);

		return universal;
	}

	public static Collection<String> reverse(Collection<String> set) {
		List<String> list = new ArrayList<String>();

		String[] values = (String[]) set.toArray(new String[set.size()]);
		for (int i = values.length - 1; i >= 0; i--)
			list.add(values[i]);

		return list;
	}

	public static String[] toArray1(Collection<String> collection) {
		return (String[]) collection.toArray(new String[collection.size()]);
	}

	public static Object[] toArray2(Collection<Object> collection) {
		Set<Object> set = new TreeSet<Object>();

		for (Object obj : collection)
			set.add(obj);

		return (Object[]) set.toArray(new Object[set.size()]);
	}

	public static List<String> toList(Iterable<String> iterable) {
		List<String> list = new ArrayList<String>();

		Iterator<String> iter = iterable.iterator();
		while (iter.hasNext())
			list.add(iter.next());

		return list;
	}

	public static List<String> toList(String... values) {
		List<String> list = new ArrayList<String>();

		for (String value : values)
			list.add(value.trim());

		return list;
	}

	public static Set<String> toSet(Iterable<String> iterable) {
		Set<String> set = new TreeSet<String>();

		Iterator<String> iter = iterable.iterator();
		while (iter.hasNext())
			set.add(iter.next());

		return set;
	}

	public static Set<String> toSet(String... values) {
		Set<String> set = new TreeSet<String>();

		for (String value : values)
			set.add(value);

		return set;
	}

	public static String toString(Iterable<?> collection, String delimiter) {
		return toString(collection.iterator(), delimiter);
	}

	public static String toString(Iterator<?> iter, String delimiter) {
		StringBuilder sb = new StringBuilder();

		while (iter.hasNext()) {
			sb.append(iter.next());
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}
}
