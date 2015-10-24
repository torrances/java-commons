package com.trimc.blogger.commons.utils;

import java.util.List;

import com.trimc.blogger.commons.type.EngGrammar;

/**
 * @author Craig Trim
 *
 */
public final class EngGrammarHelper {

	public static boolean isAnyAdjective(EngGrammar type) {
		if (EngGrammar.ADJECTIVE == type || EngGrammar.ADJECTIVEPHRASE == type || EngGrammar.COMPARATIVE_ADJECTIVE == type || EngGrammar.SUPERLATIVE_ADJECTIVE == type || EngGrammar.WH_ADJECTIVE_PHRASE == type) {
			return true;
		}

		return false;
	}

	public static boolean isAnyAdjective(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyAdjective(type)) return true;

		return false;
	}

	public static boolean isAnyAdverb(EngGrammar type) {
		if (EngGrammar.ADVERB == type || EngGrammar.ADVERB_PHRASE == type) {
			return true;
		}

		return false;
	}

	public static boolean isAnyAdverb(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyAdverb(type)) return true;

		return false;
	}

	public static boolean isAnyDeterminer(EngGrammar type) {
		if (EngGrammar.DETERMINER == type || EngGrammar.PREDETERMINER == type || EngGrammar.WH_DETERMINER == type) {
			return true;
		}

		return false;
	}

	public static boolean isAnyDeterminer(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyDeterminer(type)) return true;

		return false;
	}

	public static boolean isAnyNoun(EngGrammar type) {
		if (EngGrammar.PLURAL_NOUN == type || EngGrammar.PROPER_PLURAL_NOUN == type || EngGrammar.SINGULAR_NOUN == type || EngGrammar.PROPER_SINGULAR_NOUN == type) {
			return true;
		}

		return false;
	}

	public static boolean isAnyNoun(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyNoun(type)) return true;

		return false;
	}

	public static boolean isAnyNounOrAdjective(EngGrammar type) {
		return isAnyNoun(type) || isAnyAdjective(type);
	}

	public static boolean isAnyNounOrAdjective(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyNounOrAdjective(type)) return true;

		return false;
	}

	public static boolean isAnyNounOrNounPhrase(EngGrammar type) {
		return isAnyNoun(type) || isAnyNounPhrase(type);
	}

	public static boolean isAnyNounOrNounPhrase(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyNounOrNounPhrase(type)) return true;

		return false;
	}

	public static boolean isAnyNounPhrase(EngGrammar type) {
		if (EngGrammar.NOUN_PHRASE == type || EngGrammar.NOUN_PHRASE_MARKER == type || EngGrammar.WH_NOUN_PHRASE == type) {
			return true;
		}

		return false;
	}

	public static boolean isAnyNounPhrase(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyNounPhrase(type)) return true;

		return false;
	}

	public static boolean isAnyPrepositionalPhrase(EngGrammar type) {
		if (EngGrammar.PREPOSITIONAL_PHRASE == type || EngGrammar.WH_PREPOSITIONAL_PHRASE == type) return true;

		return false;
	}

	public static boolean isAnyPrepositionalPhrase(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyPrepositionalPhrase(type)) return true;

		return false;
	}

	public static boolean isAnyVerb(EngGrammar type) {
		if (EngGrammar.AUXILIARY_VERB == type || EngGrammar.LINKING_VERB == type || EngGrammar.NON_THIRD_PERSON_PRESENT_TENSE_VERB == type || EngGrammar.PART_PARTICIPLE_VERB == type || EngGrammar.PAST_TENSE_LINKING_VERB == type || EngGrammar.PAST_TENSE_VERB == type
				|| EngGrammar.THIRD_PERSON_PRESENT_TENSE_VERB == type || EngGrammar.TO_BE_VERB == type || EngGrammar.VERB == type || EngGrammar.VERB_PHRASE == type || EngGrammar.PRESENT_PARTICIPLE_VERB == type) {
			return true;
		}

		return false;
	}

	public static boolean isAnyVerb(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyVerb(type)) return true;

		return false;
	}

	public static boolean isAnyVerbPhrase(EngGrammar type) {
		if (EngGrammar.VERB_PHRASE == type) return true;

		return false;
	}

	public static boolean isAnyVerbPhrase(List<EngGrammar> types) {
		for (EngGrammar type : types)
			if (isAnyVerbPhrase(type)) return true;

		return false;
	}
}
