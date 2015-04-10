package com.trimc.blogger.commons.type;import com.trimc.blogger.commons.LogManager;
public enum EngGrammar {

	ADJECTIVE("Adjective", "Adjective", EngGrammarUpperType.ADJECTIVE, EngGrammarMetaType.OPEN_WORD, "JJ"),

	ADJECTIVEPHRASE("Adjective Phrase", "AdjectivePhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "ADJP"),

	ADVERB("Adverb", "Adverb", EngGrammarUpperType.ADVERB, EngGrammarMetaType.OPEN_WORD, "RB"),

	ADVERB_PHRASE("Adverb Phrase", "AdverbPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "ADVP"),

	ARTICLE("Article", "Article", EngGrammarUpperType.DETERMINER, EngGrammarMetaType.OPEN_WORD, "ART"),

	AUXILIARY_VERB("Auxiliary Verb", "AuxiliaryVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "AUX"), // extended tag

	CARDINAL_NUMBER("Cardinal Number", "CardinalNumber", EngGrammarUpperType.NUMBER, EngGrammarMetaType.NUMBER, "CD"),

	COMPARATIVE_ADJECTIVE("Comparative Adjective", "ComparativeAdjective", EngGrammarUpperType.ADJECTIVE, EngGrammarMetaType.OPEN_WORD, "JJR"),

	COMPARATIVE_ADVERB("Comparative Adverb", "ComparativeAdverb", EngGrammarUpperType.ADVERB, EngGrammarMetaType.OPEN_WORD, "RBR"),

	CONJUNCTION_PHRASE("Conjunction Phrase", "ConjunctionPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "CONJP"),

	COORDINATING_CONJUNCTION("Coordinating Conjunction", "CoordinatingConjunction", EngGrammarUpperType.CONJUNCTION, EngGrammarMetaType.CLOSED_WORD, "CC"),

	DETERMINER("Determiner", "Determiner", EngGrammarUpperType.DETERMINER, EngGrammarMetaType.CLOSED_WORD, "DT"),

	EXISTENTIAL_THERE("Existential There", "ExistentialThere", EngGrammarUpperType.OTHER, EngGrammarMetaType.OPEN_WORD, "EX"),

	FOREIGN_WORD("Foreign Word", "ForeignWord", EngGrammarUpperType.OTHER, EngGrammarMetaType.OPEN_WORD, "FW"),

	FRAGMENT("Fragment", "Fragment", EngGrammarUpperType.CLAUSE, EngGrammarMetaType.PHRASE, "FRAG"),

	INTERJECTION("Interjection", "Interjection", EngGrammarUpperType.INTERJECTION, EngGrammarMetaType.CLOSED_WORD, "UH"),

	INTERJECTION_PHRASE("Interjection Phrase", "InterjectionPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "INTJ"),

	INVERTED_DECLARATIVE_CLAUSE("Inverted Declarative Clause", "InvertedDeclarativeClause", EngGrammarUpperType.CLAUSE, EngGrammarMetaType.CLAUSE, "SINV"),

	INVERTED_QUESTION("Inverted Question", "InvertedQuestion", EngGrammarUpperType.CLAUSE, EngGrammarMetaType.CLAUSE, "SQ"),

	INVERTED_SENTENCE("Inverted Sentence", "InvertedSentence", EngGrammarUpperType.CLAUSE, EngGrammarMetaType.CLAUSE, "SQ"),

	INVERTED_YES_NO_QUESTION("Inverted Yes/No Question", "InvertedYes/NoQuestion", EngGrammarUpperType.PHRASE, EngGrammarMetaType.CLAUSE, "SQ"),

	LEFT_BRACKET("Left Bracket", "LeftBracket", EngGrammarUpperType.PUNCTUATION, EngGrammarMetaType.PUNCTUATION, "-LRB-"),

	LINKING_VERB("Linking Verb", "LinkingVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "LV"),

	LIST_ITEM_MARKER("List Item Marker", "ListItemMarker", EngGrammarUpperType.OTHER, EngGrammarMetaType.OPEN_WORD, "LS"),

	LIST_MARKER("List Marker", "ListMarker", EngGrammarUpperType.OTHER, EngGrammarMetaType.PHRASE, "LST"),

	MODAL("Modal", "Modal", EngGrammarUpperType.MODAL, EngGrammarMetaType.CLOSED_WORD, "MD"),

	NON_CONSTITUENT_PHRASE("Non Constituent Phrase", "NonConstituentPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "NAC"),

	NON_THIRD_PERSON_PRESENT_TENSE_VERB("Non-Third Person Present Tense Verb", "Non-ThirdPersonPresentTenseVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "VBP"),

	NOT_A_CONSTITUENT_PHRASE("Not-a-Constituent Phrase", "Not-a-ConstituentPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "NAC"),

	NOUN_PHRASE("Noun Phrase", "NounPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "NP"),

	NOUN_PHRASE_MARKER("Noun Phrase Marker", "NounPhraseMarker", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "NX"),

	PARENTHETICAL_PHRASE("Parenthetical Phrase", "ParentheticalPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "PRN"),

	PART_PARTICIPLE_VERB("Part Participle Verb", "PastParticipleVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "VBN"),

	PARTICLE("Particle", "Particle", EngGrammarUpperType.OTHER, EngGrammarMetaType.OPEN_WORD, "RP"),

	PARTICLE_PHRASE("Particle Phrase", "ParticlePhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "PRT"),

	PAST_TENSE_LINKING_VERB("Past Tense Linking Verb", "PastTenseLinkingVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "LVD"),

	PAST_TENSE_VERB("Past Tense Verb", "PastTenseVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "VBD"),

	PERSONAL_PRONOUN("Personal Pronoun", "PersonalPronoun", EngGrammarUpperType.PRONOUN, EngGrammarMetaType.OPEN_WORD, "PRP"),

	PLURAL_NOUN("Plural Noun", "PluralNoun", EngGrammarUpperType.NOUN, EngGrammarMetaType.OPEN_WORD, "NNS"),

	POSSESSIVE_PRONOUN("Possessive Pronoun", "PossessivePronoun", EngGrammarUpperType.PRONOUN, EngGrammarMetaType.OPEN_WORD, "PRP$", "PRP-S"),

	POSSESSIVE_WH_PRONOUN("Possessive WH-Pronoun", "PossessiveWH-Pronoun", EngGrammarUpperType.PRONOUN, EngGrammarMetaType.OPEN_WORD, "WP$", "WP-S"),

	POSSESSIVEENDING("Possessive Ending", "PossessiveEnding", EngGrammarUpperType.OTHER, EngGrammarMetaType.OPEN_WORD, "POS"),

	PREDETERMINER("Predeterminer", "Predeterminer", EngGrammarUpperType.DETERMINER, EngGrammarMetaType.CLOSED_WORD, "PDT"),

	PREPOSITION("Preposition", "Preposition", EngGrammarUpperType.PREPOSITION, EngGrammarMetaType.CLOSED_WORD, "IN"),

	PREPOSITIONAL_PHRASE("Prepositional Phrase", "PrepositionalPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "PP"),

	PRESENT_PARTICIPLE_VERB("Present Participle Verb", "PresentParticipleVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "VBG"),

	PROPER_PLURAL_NOUN("Proper Plural Noun", "ProperPluralNoun", EngGrammarUpperType.NOUN, EngGrammarMetaType.OPEN_WORD, "NNPS"),

	PROPER_SINGULAR_NOUN("Proper Singular Noun", "ProperSingularNoun", EngGrammarUpperType.NOUN, EngGrammarMetaType.OPEN_WORD, "NNP"),

	QUANTIFIER_PHRASE("Quantifier Phrase", "QuantifierPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "QP"),

	REDUCED_RELATIVE_CLAUSE("Reduced Relative Clause", "ReducedRelativeClause", EngGrammarUpperType.CLAUSE, EngGrammarMetaType.PHRASE, "RRC"),

	RIGHT_BRACKET("Right Bracket", "RightBracket", EngGrammarUpperType.PUNCTUATION, EngGrammarMetaType.PUNCTUATION, "-RRB-"),

	ROOT("Root", "Root", EngGrammarUpperType.PHRASE, EngGrammarMetaType.CLAUSE, "INC", "ROOT", "TOP"),

	SBAR_CLAUSE("SBAR-Clause", "SBAR-Clause", EngGrammarUpperType.CLAUSE, EngGrammarMetaType.CLAUSE, "SBAR"),

	SBARQ_CLAUSE("SBARQ-Clause", "SBARQ-Clause", EngGrammarUpperType.CLAUSE, EngGrammarMetaType.CLAUSE, "SBARQ"),

	SIMPLE_DECLARATIVE_CLAUSE("Simple Declarative Clause", "SimpleDeclarativeClause", EngGrammarUpperType.CLAUSE, EngGrammarMetaType.CLAUSE, "S"),

	SINGULAR_NOUN("Singular Noun", "SingularNoun", EngGrammarUpperType.NOUN, EngGrammarMetaType.OPEN_WORD, "NN"),

	SUBORDINATING_CONJUNCTION("Subordinating Conjunction", "SubordinatingConjunction", EngGrammarUpperType.CONJUNCTION, EngGrammarMetaType.CLOSED_WORD, "IN"),

	SUPERLATIVE_ADJECTIVE("Superlative Adjective", "SuperlativeAdjective", EngGrammarUpperType.ADJECTIVE, EngGrammarMetaType.OPEN_WORD, "JJS"),

	SUPERLATIVE_ADVERB("Superlative Adverb", "SuperlativeAdverb", EngGrammarUpperType.ADVERB, EngGrammarMetaType.OPEN_WORD, "RBS"),

	SYMBOL("Symbol", "Symbol", EngGrammarUpperType.OTHER, EngGrammarMetaType.OPEN_WORD, "SYM"),

	THIRD_PERSON_PRESENT_TENSE_VERB("Third Person Present Tense Verb", "ThirdPersonPresentTenseVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "VBZ"),

	TO_BE_VERB("To Verb", "ToVerb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "TO"),

	UNKNOWN("Unknown", "Unknown", EngGrammarUpperType.OTHER, EngGrammarMetaType.OTHER, "UNKNOWN"),

	UNKNOWN_PHRASE("Unknown Phrase", "UnknownPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "X"),

	UNKNOWN_PUNCTUATION("Unknown Punctuation", "UnknownPunctuation", EngGrammarUpperType.PUNCTUATION, EngGrammarMetaType.PUNCTUATION, "#", "$", "''", ",", ".", ":", ";", "``"),

	UNLIKE_COORDINATED_PHRASE("Unlike Coordinated Phrase", "UnlikeCoordinatedPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "UCP"),

	VERB("Verb", "Verb", EngGrammarUpperType.VERB, EngGrammarMetaType.OPEN_WORD, "VB"),

	VERB_PHRASE("Verb Phrase", "VerbPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "VP"),

	WH_ADJECTIVE_PHRASE("WH-Adjective Phrase", "WH-AdjectivePhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.OPEN_WORD, "WHADJP"),

	WH_ADVERB("WH-Adverb", "WH-Adverb", EngGrammarUpperType.ADVERB, EngGrammarMetaType.OPEN_WORD, "WRB"),

	WH_ADVERB_PHRASE("WH-Adverb Phrase", "WH-AdverbPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.OPEN_WORD, "WHADVP", "WHAVP"),

	WH_DETERMINER("WH-Determiner", "WH-Determiner", EngGrammarUpperType.DETERMINER, EngGrammarMetaType.CLOSED_WORD, "WDT"),

	WH_NOUN_PHRASE("WH-Noun Phrase", "WH-Noun Phrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.OPEN_WORD, "WHNP"),

	WH_PREPOSITIONAL_PHRASE("WH-Prepositional Phrase", "WH-PrepositionalPhrase", EngGrammarUpperType.PHRASE, EngGrammarMetaType.PHRASE, "WHPP"),

	WH_PRONOUN("WH-Pronoun", "WH-Pronoun", EngGrammarUpperType.PRONOUN, EngGrammarMetaType.OPEN_WORD, "WP");

	public static LogManager	logger	= new LogManager(EngGrammar.class);

	public static EngGrammar find(String value) {
		for (EngGrammar engGrammar : EngGrammar.values()) {

			for (String tag : engGrammar.getTags()) {
				if (tag.equalsIgnoreCase(value)) {
					return engGrammar;
				}
			}

			if (engGrammar.getLabel().equalsIgnoreCase(value)) {
				return engGrammar;
			} else if (engGrammar.getId().toString().equalsIgnoreCase(value)) {
				return engGrammar;
			} else if (engGrammar.getUpperType().toString().equalsIgnoreCase(value)) {
				return engGrammar;
			} else if (engGrammar.getMetaType().toString().equalsIgnoreCase(value)) {
				return engGrammar;
			} else if (engGrammar.toString().equalsIgnoreCase(value)) {
				return engGrammar;
			}

			// the passed-in value might be "ComparativeAdjective" and the display value is "Comparative Adjective"
			String modifiedlabel = engGrammar.getLabel().replaceAll(" ", "");
			if (modifiedlabel.equalsIgnoreCase(value)) {
				return engGrammar;
			}

			// the passed-in value might be "NonThirdPersonPresentTenseVerb" and the display value is "Non-Third Person Present Tense Verb" 
			modifiedlabel = modifiedlabel.replaceAll("-", "");
			if (modifiedlabel.equalsIgnoreCase(value)) {
				return engGrammar;
			}
		}

		if ("unknown".equals(value.toLowerCase())) {
			return EngGrammar.UNKNOWN_PUNCTUATION;
		}

		logger.trace("No EngGrammar found for value (value = %s)", value);
		return null;

	}

	private String				id;

	private String				label;

	private EngGrammarMetaType	metaType;

	private String[]			tags;

	private EngGrammarUpperType	upperType;

	private EngGrammar(String label, String id, EngGrammarUpperType upperType, EngGrammarMetaType metaType, String... tags) {
		setLabel(label);
		setId(id);
		setTags(tags);
		setUpperType(upperType);
		setMetaType(metaType);
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public EngGrammarMetaType getMetaType() {
		return metaType;
	}

	public String[] getTags() {
		return tags;
	}

	public EngGrammarUpperType getUpperType() {
		return upperType;
	}

	private void setId(String id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setMetaType(EngGrammarMetaType metaType) {
		this.metaType = metaType;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public void setUpperType(EngGrammarUpperType upperType) {
		this.upperType = upperType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(toString(getTags()));
		sb.append("	");
		sb.append(getLabel());
		sb.append("	");
		sb.append(getUpperType().toString());
		sb.append("	");
		sb.append(getMetaType().toString());

		return sb.toString();
	}

	private String toString(String... tags) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tags.length; i++) {
			sb.append(tags[i]);
			if (i + i < tags.length) {
				sb.append(",");
			}
		}

		return sb.toString();
	}
}
