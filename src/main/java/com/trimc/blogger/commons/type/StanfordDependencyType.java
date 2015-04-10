package com.trimc.blogger.commons.type;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.utils.StringUtils;

public enum StanfordDependencyType {

	ABBREV("abbrev", "abbreviation modifier", false, UpperDependencyType.PHRASE, "An abbreviation modifier of an NP is a parenthesized NP that serves to abbreviate the NP (or to define an abbreviation)."),

	ACOMP("acomp", "adjectival complement", false, UpperDependencyType.PHRASE, "An adjectival complement of a verb is an adjectival phrase which functions as the complement (like an object of the verb)."),

	ADVCL("advcl", "adverbial clause modifier", false, UpperDependencyType.CLAUSE, "An adverbial clause modifier of a VP or S is a clause modifying the verb (temporal clause, consequence, conditional clause, purpose clause, etc.)."),

	ADVMOD("advmod", "adverbial modifier", false, UpperDependencyType.ADVERB, "An adverbial modifier of a word is a (non-clausal) adverb or adverbial phrase (ADVP) that serves to modify the meaning of the word"),

	AGENT("agent", "agent", false, UpperDependencyType.COMPLEMENT,
			"An agent is the complement of a passive verb which is introduced by the preposition 'by' and does the action. This relation only appears in the collapsed dependencies, where it can replace prep by, where appropriate."),

	AMOD("amod", "adjectival modifier", false, UpperDependencyType.PHRASE, "An adjectival modifier of an NP is any adjectival phrase that serves to modify the meaning of the NP."),

	APPOS("appos", "appositional modifier", false, UpperDependencyType.PHRASE,
			"An appositional modifier of an NP is an NP immediately to the right of the first NP that serves to define ne or modify that NP. It includes parenthesized examples, as well as defining abbreviations in one of these structures."),

	AUX("aux", "auxiliary", false, UpperDependencyType.MODAL, "An auxiliary of a clause is a non-main verb of the clause, e.g., a modal auxiliary, or a form of 'be', 'do' or 'have' in a periphrastic tense."),

	AUXPASS("auxpass", "passive auxiliary", false, UpperDependencyType.VERB, "A passive auxiliary of a clause is a non-main verb of the clause which contains the passive information."),

	CC("cc", "coordination", false, UpperDependencyType.CONJUNCTION, "A coordination is the relation between an element of a conjunct and the coordinating conjunction word of the conjunct."),

	CCOMP("ccomp", "clausal complement", false, UpperDependencyType.CLAUSE, "A clausal complement of a verb or adjective is a dependent clause with an internal subject which functions like an object of the verb, or adjective."),

	CONJ("conj", "conjunct", false, UpperDependencyType.CONJUNCTION, "A conjunct is the relation between two elements connected by a coordinating conjunction, such as 'and', 'or', etc."),

	COP("cop", "copula", false, UpperDependencyType.OTHER, "A copula is the relation between the complement of a copular verb and the copular verb."),

	CSUBJ("csubj", "clausal subject", false, UpperDependencyType.CLAUSE, "A clausal subject is a clausal syntactic subject of a clause, i.e., the subject is itself a clause."),

	CSUBJPASS("csubjpass", "clausal passive subject", false, UpperDependencyType.CLAUSE, "A clausal passive subject is a clausal syntactic subject of a passive clause."),

	DEP("dep", "dependent", false, UpperDependencyType.OTHER, "A dependency is labeled as dep when the system is unable to determine a more precise dependency relation between two words."),

	DET("det", "determiner", false, UpperDependencyType.OTHER, "A determiner is the relation between the head of an NP and its determiner."),

	DISCOURSE("discourse", "discourse element", false, UpperDependencyType.OTHER, "This is used for interjections and other discourse particles and elements (which are not clearly linked to the structure of the sentence, except in an expressive way)."),

	DOBJ("dobj", "direct object", false, UpperDependencyType.OTHER, "The direct object of a VP is the noun phrase which is the (accusative) object of the verb."),

	EXPL("expl", "expletive", false, UpperDependencyType.OTHER, "This relation captures an existential 'there'. The main verb of the clause is the governor."),

	GOESWITH("goeswith", "goes with", false, UpperDependencyType.OTHER, "This relation links two parts of a word that are separated in text that is not well edited."),

	IOBJ("iobj", "indirect object", false, UpperDependencyType.OTHER, "The indirect object of a VP is the noun phrase which is the (dative) object of the verb."),

	MARK("mark", "mark", false, UpperDependencyType.OTHER, "A marker is the word introducing a finite clause subordinate to another clause."),

	MWE("mwe", "multi-word expression", false, UpperDependencyType.OTHER, "The multi-word expression (modifier) relation is used for certain multi-word idioms that behave like a single function word."),

	NEG("neg", "negation modifier", false, UpperDependencyType.OTHER, "The negation modifier is the relation between a negation word and the word it modifies."),

	NN("nn", "noun compound modifier", false, UpperDependencyType.OTHER, "A noun compound modifier of an NP is any noun that serves to modify the head noun."),

	NPADVMOD("npadvmod", "noun phrase as adverbial modifier", false, UpperDependencyType.OTHER, "This relation captures various places where something syntactically a noun phrase (NP) is used as an adverbial modifier in a sentence."),

	NSUBJ("nsubj", "nominal subject", false, UpperDependencyType.OTHER, "A nominal subject is a noun phrase which is the syntactic subject of a clause."),

	NSUBJPASS("nsubjpass", "passive nominal subject", false, UpperDependencyType.OTHER, "A passive nominal subject is a noun phrase which is the syntactic subject of a passive clause."),

	NUM("num", "numeric modifier", false, UpperDependencyType.OTHER, "A numeric modifier of a noun is any number phrase that serves to modify the meaning of the noun with a quantity."),

	NUMBER("number", "element of a compound number", false, UpperDependencyType.OTHER, "An element of compound number is a part of a number phrase or currency amount."),

	PARATAXIS("parataxis", "preposition-at", false, UpperDependencyType.OTHER, "The parataxis relation (from Greek for 'place side by side') is a relation between the main verb of a clause and other sentential elements."),

	PCOMP("pcomp", "prepositional complement", false, UpperDependencyType.OTHER, "This is used when the complement of a preposition is a clause or prepositional phrase (or occasionally, an adverbial phrase)."),

	POBJ("pobj", "object of a preposition", false, UpperDependencyType.OTHER, "The object of a preposition is the head of a noun phrase following the preposition, or the adverbs 'here' and 'there'."),

	POSS("poss", "possession modifier", false, UpperDependencyType.OTHER, "The possession modifier relation holds between the head of an NP and its possessive determiner, or a genitive's complement."),

	POSSESSIVE("possessive", "possessive modifier", false, UpperDependencyType.OTHER, "The possessive modifier relation appears between the head of an NP and the genitive's."),

	PRECONJ("preconj", "preconjunct", false, UpperDependencyType.OTHER, "A preconjunct is the relation between the head of an NP and a word that appears at the beginning bracketing a conjunction (and puts emphasis on it)"),

	PREDET("predet", "predeterminer", false, UpperDependencyType.OTHER, "A predeterminer is the relation between the head of an NP and a word that precedes and modifies the meaning of the NP determiner."),

	PREP("prep", "prepositional modifier", false, UpperDependencyType.PREPOSITION, "A prepositional modifier of a verb, adjective, or noun is any prepositional phrase that serves to modify the meaning of the verb, adjective, noun, or even another prepositon."),

	PREP_0("prep_0", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_ABOUT("prep_about", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_ABOVE("prep_above", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_ACROSS("prep_across", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_AFTER("prep_after", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_AGAINST("prep_against", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_ALONG("prep_along", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_ALTHOUGH("prep_although", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_AROUND("prep_around", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_AS("prep_as", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_AS_FOR("prep_as_for", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_AS_TO("prep_as_to", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_AT("prep_at", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_BECAUSE("prep_because", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_BECAUSE_OF("prep_because_of", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_BEFORE("prep_before", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_BELOW("prep_below", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_BETWEEN("prep_between", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_BEYOND("prep_beyond", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_BY("prep_by", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_DESPITE("prep_despite", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_DUE_TO("prep_due_to", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_DURING("prep_during", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_EXCEPT("prep_except", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_FOLLOWING("prep_following", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_FOR("prep_for", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_FROM("prep_from", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_IN("prep_in", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_INCLUDING("prep_including", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_INSIDE("prep_inside", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_INSTEAD_OF("prep_instead_of", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_INTO("prep_into", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_INVOLVING("prep_involving", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_LIKE("prep_like", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_NEAR("prep_near", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_OF("prep_of", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_ON("prep_on", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_ONTO("prep_onto", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_OUTSIDE("prep_outside", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_OVER("prep_over", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_PER("prep_per", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_PRIOR_TO("prep_prior_to", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_REGARDING("prep_regarding", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_SUCH_AS("prep_such_as", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_THAN("prep_than", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_THAT("prep_that", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_THROUGH("prep_through", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_THROUGHOUT("prep_throughout", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_TO("prep_to", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_TOWARD("prep_toward", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_UNDER("prep_under", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_UNTIL("prep_until", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_UPON("prep_upon", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_WITH("prep_with", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_WITHIN("prep_within", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREP_WITHOUT("prep_without", "collapsed prepositional modifier", false, UpperDependencyType.PREPOSITION, "a collapsed prepositional modifier"),

	PREPC("prepc", "prepositional clause modifier", false, UpperDependencyType.PREPOSITION, "A prepositional clausal modifier of a verb, adjective, or noun is a clause introduced by a preposition which serves to modify the meaning of the verb, adjective, or noun."),

	PRT("prt", "phrasal verb particle", false, UpperDependencyType.OTHER, "The phrasal verb particle relation identifies a phrasal verb, and holds between the verb and its particle."),

	PUNCT("punct", "punctuation", false, UpperDependencyType.OTHER, "This is used for any piece of punctuation in a clause, if punctuation is being retained in the typed dependencies."),

	QUANTMOD("quantmod", "quantifier phrase modifier", false, UpperDependencyType.OTHER, "A quantifier modifier is an element modifying the head of a QP constituent."),

	RCMOD("rcmod", "relative clause modifier", false, UpperDependencyType.OTHER, "relative clause modifier"),

	REF("ref", "reference", true, UpperDependencyType.OTHER, "A referent of the head of an NP is the relative word introducing the relative clause modifying the NP."),

	ROOT("root", "root", false, UpperDependencyType.OTHER, "The root grammatical relation points to the root of the sentence. A fake node 'ROOT' is used as the governor. The ROOT node is indexed with '0', since the indexation of real words in the sentence starts at 1."),

	TMOD("tmod", "temporal modifier", false, UpperDependencyType.OTHER, "A temporal modifier (of a VP, NP, or an ADJP is a bare noun phrase constituent that serves to modify the meaning of the constituent by specifying a time."),

	VMOD("vmod", "reduced non-finite verbal modifier", false, UpperDependencyType.VERB, "A reduced non-finite verbal modifier is a participial or infinitive form of a verb heading a phrase (which may have some arguments, roughly like a VP)."),

	XCOMP("xcomp", "open clausal complement", false, UpperDependencyType.CLAUSE, "An open clausal complement (xcomp) of a VP or an ADJP is a clausal complement without its own subject, whose reference is determined by an external subject."),

	XSUBJ("xsubj", "controlling subject", false, UpperDependencyType.OTHER, "A controlling subject is the relation between the head of a open clausal complement (xcomp) and the external subject of that clause.");

	public static LogManager	logger	= new LogManager(StanfordDependencyType.class);

	public static StanfordDependencyType find(String name) {
		if (!StringUtils.hasValue(name)) return null;
		return findByName(name);
	}

	private static StanfordDependencyType findByName(String name) {
		for (StanfordDependencyType value : StanfordDependencyType.values()) {
			if (value.getShortName().equalsIgnoreCase(name)) return value;
			if (value.getLongName().equalsIgnoreCase(name)) return value;
		}

		if (name.toLowerCase().startsWith("prep_")) return PREPC;
		if (name.toLowerCase().startsWith("prepc_")) return PREPC;
		if (name.toLowerCase().startsWith("conj_")) return CONJ;

		logger.error("Dependency Predicate Not Recognized (name = %s)", name);
		return null;
	}

	private String				description;

	private boolean				isCollapsed;

	private String				longName;

	private String				shortName;

	private UpperDependencyType	upperType;

	StanfordDependencyType(String aShortName, String aLongName, boolean isCollapsed, UpperDependencyType upperType, String description) {
		setShortName(aShortName);
		setLongName(aLongName);
		setCollapsed(isCollapsed);
		setUpperType(upperType);
		setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public String getLongName() {
		return longName;
	}

	public String getShortName() {
		return shortName;
	}

	public UpperDependencyType getUpperType() {
		return upperType;
	}

	public boolean isCollapsed() {
		return isCollapsed;
	}

	private void setCollapsed(boolean isCollapsed) {
		this.isCollapsed = isCollapsed;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private void setLongName(String longName) {
		this.longName = longName;
	}

	private void setShortName(String shortName) {
		this.shortName = shortName;
	}

	private void setUpperType(UpperDependencyType upperType) {
		this.upperType = upperType;
	}

	@Override
	public String toString() {
		return getShortName();
	}
}
