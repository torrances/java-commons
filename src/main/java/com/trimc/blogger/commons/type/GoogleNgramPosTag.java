package com.trimc.blogger.commons.type;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.utils.string.StringUtils;

/**
 * Purpose:
 * Part-of-Speech Tags used in the Google n-Grams Corpus
 * A full list of the tags can be found here:
 * 	<https://books.google.com/ngrams/info>
 * 	<https://code.google.com/p/universal-pos-tags/>
 * 	<http://www.petrovi.de/data/universal.pdf>
 * 	<http://universaldependencies.github.io/docs/u/pos/index.html>
 *
 */
public enum GoogleNgramPosTag {

	/*
		1. 	ADJ: adjective
		2. 	ADP: adposition
		3. 	ADV: adverb
		4. 	AUX: auxiliary verb
		5. 	CONJ: coordinating conjunction
		6. 	DET: determiner
		7. 	INTJ: interjection
		8. 	NOUN: noun
		9. 	NUM: numeral
		10.	PART: particle
		11.	PRON: pronoun
		12. PROPN: proper noun
		13. PUNCT: punctuation
		14. SCONJ: subordinating conjunction
		15. SYM: symbol
		16. VERB: verb
		17. X: other
	© 2014 Universal Dependencies contributors. Site powered by Annodoc and brat.*/

	/*1*/ADJECTIVE("ADJ", EngGrammarUpperType.ADJECTIVE),

	/* an adposition: either a preposition or a postposition */
	/*2*/ADPOSITION("ADP", EngGrammarUpperType.PREPOSITION),

	/*3*/ADVERB("ADV", EngGrammarUpperType.ADVERB),

	/*4*/AUXILIARY_VERB("AUX", null),

	/*5*/CONJUNCTION("CONJ", EngGrammarUpperType.CONJUNCTION),

	/* determiner or article */
	/*6*/DETERMINER("DET", EngGrammarUpperType.DETERMINER),

	/*7*/INTERJECTION("INTJ", EngGrammarUpperType.INTERJECTION),

	/*8*/NOUN("NOUN", EngGrammarUpperType.NOUN),

	/*9*/NUMERAL("NUM", EngGrammarUpperType.NUMBER),

	/*16*/OTHER("X", EngGrammarUpperType.OTHER),

	/*10*/PARTICLE("PART", EngGrammarUpperType.OTHER),

	/*11*/PRONOUN("PRON", EngGrammarUpperType.PRONOUN),

	/*12*/PROPER_NOUN("PROPN", EngGrammarUpperType.NOUN),

	/*13*/PUNCTUATION("PUNCT", EngGrammarUpperType.PUNCTUATION),

	/*14*/SUBORDINATING_CONJUCTION("SCONJ", EngGrammarUpperType.OTHER),

	/*15*/SYMBOL("SYM", EngGrammarUpperType.OTHER),

	/*17*/VERB("VERB", EngGrammarUpperType.VERB);

	public static LogManager logger = new LogManager(GoogleNgramPosTag.class);

	public static GoogleNgramPosTag find(String tag) {

		if (!StringUtils.hasValue(tag)) return null;

		for (GoogleNgramPosTag value : GoogleNgramPosTag.values())
			if (value.getName().equalsIgnoreCase(tag)) return value;

		if ("verb".equalsIgnoreCase(tag)) return VERB;
		if ("pronoun".equalsIgnoreCase(tag)) return PRONOUN;
		if ("particle".equalsIgnoreCase(tag)) return PARTICLE;
		if ("prt".equalsIgnoreCase(tag)) return PARTICLE;
		if ("numeral".equalsIgnoreCase(tag)) return NUMERAL;
		if ("determiner".equalsIgnoreCase(tag)) return DETERMINER;
		if ("conjunction".equalsIgnoreCase(tag)) return CONJUNCTION;
		if ("adverb".equalsIgnoreCase(tag)) return ADVERB;
		if ("adposition".equalsIgnoreCase(tag)) return ADPOSITION;
		if ("adjective".equalsIgnoreCase(tag)) return ADJECTIVE;
		if (".".equalsIgnoreCase(tag)) return PUNCTUATION;

		logger.debug("GoogleNgramPosTag value not recognized (tag = %s)", tag);
		return null;
	}

	private EngGrammarUpperType engGrammarUpperType;

	private String name;

	private GoogleNgramPosTag(String name, EngGrammarUpperType engGrammarUpperType) {
		setName(name);
		setEngGrammarUpperType(engGrammarUpperType);
	}

	public EngGrammarUpperType getEngGrammarUpperType() {
		return engGrammarUpperType;
	}

	private String getName() {
		return name;
	}

	public boolean hasEngGrammarUpperType() {
		return null != getEngGrammarUpperType();
	}

	private void setEngGrammarUpperType(EngGrammarUpperType engGrammarUpperType) {
		this.engGrammarUpperType = engGrammarUpperType;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
