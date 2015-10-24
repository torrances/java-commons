package com.trimc.blogger.commons.type;

import com.trimc.blogger.commons.exception.AdapterValidationException;

public final class EngGrammarSerAdapter {

	public static EngGrammarSer transform(EngGrammar type) throws AdapterValidationException {
		EngGrammarSer ser = new EngGrammarSer();

		ser.setLongName(type.getLabel());
		ser.setMetaType(type.getMetaType().toString());
		ser.setUpperType(type.getUpperType().toString());
		ser.setTags(type.getTags());

		return ser;
	}
}
