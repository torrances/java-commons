package com.trimc.blogger.commons.utils;

import org.junit.Test;
import static org.junit.Assert.*;

public final class RegexUtilsTest {

	@Test
	public void useDotNotationForAbbreviations1() throws Throwable {
		String line = "That was it.";
		line = RegexUtils.useDotNotationForAbbreviations(line);
		assertEquals(line, "That was it.");
	}

	@Test
	public void useDotNotationForAbbreviations2() throws Throwable {
		String line = "This is my sentence. That was it.";
		line = RegexUtils.useDotNotationForAbbreviations(line);
		assertEquals(line, "This is my sentence. That was it.");
	}

	@Test
	public void useDotNotationForAbbreviations3() throws Throwable {
		String line = "That was it. Here goes nothing!";
		line = RegexUtils.useDotNotationForAbbreviations(line);
		assertEquals(line, "That was it. Here goes nothing!");
	}

	@Test
	public void useDotNotationForAbbreviations4() throws Throwable {
		String line = "This is my sentence. That was it. Here goes nothing!";
		line = RegexUtils.useDotNotationForAbbreviations(line);
		assertEquals(line, "This is my sentence. That was it. Here goes nothing!");
	}
}
