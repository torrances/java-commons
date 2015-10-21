package com.trimc.blogger.commons.type.adapter;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.AdapterValidationException;
import com.trimc.blogger.commons.type.EngGrammarUpperType;

public final class EngGrammarUpperTypeAdapter {

	public static LogManager logger = new LogManager(EngGrammarUpperTypeAdapter.class);

	public static EngGrammarUpperType findByAbbreviation(String tag) throws AdapterValidationException {
		tag = tag.toLowerCase();
		
		if ("n".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("v".equals(tag)) return EngGrammarUpperType.VERB;

		throw new AdapterValidationException("Unrecognized Abbreviation (tag = %s)", tag);
	}
}
