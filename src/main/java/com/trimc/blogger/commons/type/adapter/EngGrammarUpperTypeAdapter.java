package com.trimc.blogger.commons.type.adapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.AdapterValidationException;
import com.trimc.blogger.commons.type.EngGrammarUpperType;

public final class EngGrammarUpperTypeAdapter {

	public static LogManager logger = new LogManager(EngGrammarUpperTypeAdapter.class);

	public static EngGrammarUpperType findByName(String name) {
		for (EngGrammarUpperType value : EngGrammarUpperType.values()) {
			if (value.toString().equalsIgnoreCase(name)) {
				return value;
			}
		}

		return null;
	}

	/**
	 * transforms common abbreviations found in etymological sources 
	 * @param tag
	 * @return {@link EngGrammarUpperType}
	 * @throws AdapterValidationException
	 */
	public static EngGrammarUpperType findByAbbreviation(String tag) throws AdapterValidationException {
		tag = tag.toLowerCase().trim();

		if ("adj.".equals(tag)) return EngGrammarUpperType.ADJECTIVE;
		if ("adj.1".equals(tag)) return EngGrammarUpperType.ADJECTIVE;
		if ("adj.2".equals(tag)) return EngGrammarUpperType.ADJECTIVE;
		if ("adj.3".equals(tag)) return EngGrammarUpperType.ADJECTIVE;

		else if ("adv".equals(tag)) return EngGrammarUpperType.ADVERB;
		else if ("adv.".equals(tag)) return EngGrammarUpperType.ADVERB;
		else if ("adv.1".equals(tag)) return EngGrammarUpperType.ADVERB;
		else if ("adv.2".equals(tag)) return EngGrammarUpperType.ADVERB;

		else if ("conj".equals(tag)) return EngGrammarUpperType.CONJUNCTION;
		else if ("conj.".equals(tag)) return EngGrammarUpperType.CONJUNCTION;

		else if ("int".equals(tag)) return EngGrammarUpperType.INTERJECTION;
		else if ("int.".equals(tag)) return EngGrammarUpperType.INTERJECTION;
		else if ("int.1".equals(tag)) return EngGrammarUpperType.INTERJECTION;
		else if ("int.2".equals(tag)) return EngGrammarUpperType.INTERJECTION;

		else if ("n".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.1".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.2".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.3".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.4".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.5".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.6".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.7".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.8".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.9".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.10".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.11".equals(tag)) return EngGrammarUpperType.NOUN;
		else if ("n.12".equals(tag)) return EngGrammarUpperType.NOUN;

		else if ("prep".equals(tag)) return EngGrammarUpperType.PREPOSITION;
		else if ("prep.".equals(tag)) return EngGrammarUpperType.PREPOSITION;
		else if ("prep.1".equals(tag)) return EngGrammarUpperType.PREPOSITION;
		else if ("prep.2".equals(tag)) return EngGrammarUpperType.PREPOSITION;

		else if ("pron".equals(tag)) return EngGrammarUpperType.PRONOUN;
		else if ("pron.".equals(tag)) return EngGrammarUpperType.PRONOUN;
		else if ("pron.1".equals(tag)) return EngGrammarUpperType.PRONOUN;
		else if ("pron.2".equals(tag)) return EngGrammarUpperType.PRONOUN;
		else if ("pron.3".equals(tag)) return EngGrammarUpperType.PRONOUN;
		else if ("pron.4".equals(tag)) return EngGrammarUpperType.PRONOUN;
		else if ("pron.5".equals(tag)) return EngGrammarUpperType.PRONOUN;

		else if ("phr".equals(tag)) return EngGrammarUpperType.PHRASE;
		else if ("phr.".equals(tag)) return EngGrammarUpperType.PHRASE;
		else if ("phr.1".equals(tag)) return EngGrammarUpperType.PHRASE;
		else if ("phr.2".equals(tag)) return EngGrammarUpperType.PHRASE;

		else if ("prefix".equals(tag)) return EngGrammarUpperType.OTHER;
		else if ("prefix1".equals(tag)) return EngGrammarUpperType.OTHER;
		else if ("prefix2".equals(tag)) return EngGrammarUpperType.OTHER;
		else if ("prefix3".equals(tag)) return EngGrammarUpperType.OTHER;

		else if ("suffix".equals(tag)) return EngGrammarUpperType.OTHER;
		else if ("suffix1".equals(tag)) return EngGrammarUpperType.OTHER;
		else if ("suffix2".equals(tag)) return EngGrammarUpperType.OTHER;
		else if ("suffix3".equals(tag)) return EngGrammarUpperType.OTHER;

		else if ("v".equals(tag)) return EngGrammarUpperType.VERB;
		else if ("v.".equals(tag)) return EngGrammarUpperType.VERB;
		else if ("v.1".equals(tag)) return EngGrammarUpperType.VERB;
		else if ("v.2".equals(tag)) return EngGrammarUpperType.VERB;
		else if ("v.3".equals(tag)) return EngGrammarUpperType.VERB;
		else if ("v.4".equals(tag)) return EngGrammarUpperType.VERB;
		else if ("v.5".equals(tag)) return EngGrammarUpperType.VERB;

		else if ("comb. form".equals(tag)) return EngGrammarUpperType.OTHER;
		else if ("comb. form1".equals(tag)) return EngGrammarUpperType.OTHER;
		else if ("comb. form2".equals(tag)) return EngGrammarUpperType.OTHER;

		return null;
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
