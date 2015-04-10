package com.trimc.blogger.commons.type;

import com.trimc.blogger.commons.LogManager;

public enum EngGrammarMetaType {

	CLAUSE("Clause"),

	CLOSED_WORD("Closed Word"),

	NUMBER("Number"),

	OPEN_WORD("Open Word"),

	OTHER("Other"),

	OTHER_WORD("Other"),

	PHRASE("Phrase"),

	PUNCTUATION("Punctuation");

	public static LogManager	logger	= new LogManager(EngGrammarMetaType.class);

	public static EngGrammarMetaType find(String name) {
		for (EngGrammarMetaType value : EngGrammarMetaType.values()) {
			if (value.toString().equalsIgnoreCase(name)) {
				return value;
			}
		}

		logger.error("No EngGrammarMetaType found by value (value = %s)", name);
		return null;
	}

	private String	name;

	private EngGrammarMetaType(String name) {
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
