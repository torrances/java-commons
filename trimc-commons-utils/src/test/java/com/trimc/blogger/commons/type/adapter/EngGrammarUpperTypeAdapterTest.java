package com.trimc.blogger.commons.type.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.trimc.blogger.commons.type.EngGrammarUpperType;
import com.trimc.blogger.commons.type.adapter.EngGrammarUpperTypeAdapter;

public final class EngGrammarUpperTypeAdapterTest {

	@Test
	public void findByAbbreviation() throws Throwable {
		assertEquals(EngGrammarUpperType.NOUN, EngGrammarUpperTypeAdapter.findByAbbreviation("n."));
	}
}
