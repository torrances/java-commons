package com.trimc.blogger.commons.type.adapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.AdapterValidationException;
import com.trimc.blogger.commons.type.EngGrammarUpperType;

public final class EngGrammarUpperTypeAdapter {

	public static LogManager logger = new LogManager(EngGrammarUpperTypeAdapter.class);

	public static EngGrammarUpperType findByAbbreviation(String tag) throws AdapterValidationException {
		tag = tag.toLowerCase();

		if ("n".equals(tag)) return EngGrammarUpperType.NOUN;
		if ("n.".equals(tag)) return EngGrammarUpperType.NOUN;
		if ("n.2".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("v".equals(tag)) return EngGrammarUpperType.VERB;

		throw new AdapterValidationException("Unrecognized Abbreviation (tag = %s)", tag);
	}

	public static String toString(Collection<EngGrammarUpperType> engGrammarUpperTypes) {
		StringBuilder sb = new StringBuilder();

		Iterator<EngGrammarUpperType> iter = engGrammarUpperTypes.iterator();
		while (iter.hasNext()) {
			sb.append(iter.next().toString());
			if (iter.hasNext()) sb.append(", ");
		}

		return sb.toString();
	}

	public static String toString(EngGrammarUpperType... engGrammarUpperTypes) {
		return toString(Arrays.asList(engGrammarUpperTypes));
	}
}
