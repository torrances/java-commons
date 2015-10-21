package com.trimc.blogger.commons.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.trimc.blogger.commons.utils.TextUtils;

public final class TextUtilsTest {

	@Test
	public void containsPunctuationExcept() throws Throwable {
		assertFalse(TextUtils.containsPunctuationExcept("stephenmaturin", ' '));
		assertFalse(TextUtils.containsPunctuationExcept("stephen maturin", ' '));

		assertTrue(TextUtils.containsPunctuationExcept("stephen maturin!", ' '));
	}
	
	@Test
	public void isAlphaPunctuationOnly() throws Throwable {
		assertTrue(TextUtils.isAlphaPunctuationOnly("jack"));
		assertTrue(TextUtils.isAlphaPunctuationOnly("jack aubrey"));
		assertTrue(TextUtils.isAlphaPunctuationOnly("jack "));

		assertFalse(TextUtils.isAlphaPunctuationOnly("jack 3"));
	}
}
