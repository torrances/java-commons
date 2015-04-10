package com.trimc.blogger.commons.utils;

import java.util.Collection;
import java.util.Iterator;

public final class TurtleUtils {

	public static final String	TYPE_VALUE_TEMPLATE	= ":%s\n\trdf:type :%s ;\n\trdfs:label \"%s\"^^xsd:string .";

	public static String toTtl(String type, Collection<String> values) {
		StringBuilder sb = new StringBuilder();

		Iterator<String> iter = values.iterator();
		while (iter.hasNext()) {

			sb.append(toTtl(type, iter.next()));
			sb.append(System.lineSeparator());

			if (iter.hasNext()) sb.append(System.lineSeparator());
		}

		return sb.toString();
	}

	public static String toTtl(String type, String value) {
		String id = GraphUtils.toId(value);
		return String.format(TYPE_VALUE_TEMPLATE, id, type, value);
	}
}
