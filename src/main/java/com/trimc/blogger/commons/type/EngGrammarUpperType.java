package com.trimc.blogger.commons.type;

import com.trimc.blogger.commons.LogManager;

public enum EngGrammarUpperType {

	ADJECTIVE("Adjective"),

	ADVERB("Adverb"),

	CLAUSE("Clause"),

	COMPLEMENT("Complement"),

	CONJUNCTION("Conjunction"),

	DETERMINER("Determiner"),

	INTERJECTION("Interjection"),

	MODAL("Modal"),

	NOUN("Noun"),

	NUMBER("Number"),

	OTHER("Other"),

	PHRASE("Phrase"),

	PREPOSITION("Preposition"),

	PRONOUN("Pronoun"),

	PUNCTUATION("Punctuation"),

	VERB("Verb");

	public static LogManager logger = new LogManager(EngGrammarUpperType.class);

	public static EngGrammarUpperType find(String name) {
		for (EngGrammarUpperType value : EngGrammarUpperType.values()) {
			if (value.toString().equalsIgnoreCase(name)) {
				return value;
			}
		}

		logger.error("No EngGrammarUpperType found by value (value = %s)", name);
		return null;
	}

	private String name;

	private EngGrammarUpperType(String name) {
		setName(name);
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
