package com.trimc.blogger.commons.type;

public enum QuestionCategoryType {

	CausalAntecedent("Causal antecedent", "Why/how did X occur?", QuestionCategoryUpperType.CommonGround),

	CausalConsequence("Causal consequence", "What next? What if?", QuestionCategoryUpperType.CommonGround),

	Comparison("Comparison", "How is X similar to Y?", QuestionCategoryUpperType.CommonGround),

	ConceptCompletion("Concept completion", "Who? What? When? Where?", QuestionCategoryUpperType.CommonGround),

	Definition("Definition", "What does X mean?", QuestionCategoryUpperType.CommonGround),

	Disjunctive("Disjunctive", "Is X, Y, or Z the case?", QuestionCategoryUpperType.CommonGround),

	Enablement("Enablement", "What enabled X to occur?", QuestionCategoryUpperType.CommonGround),

	Example("Example", "What is an example of X?", QuestionCategoryUpperType.CommonGround),

	Expectation("Expectation", "Why didn't X occur?", QuestionCategoryUpperType.CommonGround),

	FeatureSpecification("Feature specification", "What are the properties of X?", QuestionCategoryUpperType.CommonGround),

	GoalOrientation("Goal orientation", "Why did an agent do X?", QuestionCategoryUpperType.CommonGround),

	InstrumentalOrProcedural("Instrumental/procedural", "How did an agent do X?", QuestionCategoryUpperType.CommonGround),

	Interpretation("Interpretation", "What is the significance of X?", QuestionCategoryUpperType.CommonGround),

	Judgmental("Judgmental", "What do you think of X?", QuestionCategoryUpperType.CommonGround),

	Quantification("Quantification", "How much? How many?", QuestionCategoryUpperType.CommonGround),

	Verification("Verification", "invites a yes or no answer", QuestionCategoryUpperType.CommonGround);

	private String name;

	private String overview;
	
	private QuestionCategoryUpperType upperType;

	private QuestionCategoryType(String name, String overview, QuestionCategoryUpperType upperType) {
		setName(name);
		setOverview(overview);
		setUpperType(upperType);
	}

	public String description() {
		return getOverview();
	}

	private String getName() {
		return name;
	}

	private String getOverview() {
		return overview;
	}

	public QuestionCategoryUpperType getUpperType() {
		return upperType;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setOverview(String overview) {
		this.overview = overview;
	}

	private void setUpperType(QuestionCategoryUpperType upperType) {
		this.upperType = upperType;
	}

	@Override
	public String toString() {
		return getName();
	}
}
