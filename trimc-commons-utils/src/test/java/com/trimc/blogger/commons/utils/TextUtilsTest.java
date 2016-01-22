package com.trimc.blogger.commons.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public final class TextUtilsTest {

	@Test
	public void containsPunctuationExcept() throws Throwable {
		assertFalse(TextUtils.containsPunctuationExcept("stephenmaturin", ' '));
		assertFalse(TextUtils.containsPunctuationExcept("stephen maturin", ' '));
		assertTrue(TextUtils.containsPunctuationExcept("stephen maturin!", ' '));
	}

	@Test
	public void endsWithPunctuation() throws Throwable {
		assertTrue(TextUtils.endsWithPunctuation("natividad!"));
		assertFalse(TextUtils.endsWithPunctuation("cacafuego"));
	}

	@Test
	public void isAlphaOnly() throws Throwable {
		assertFalse(TextUtils.isAlphaOnly("placental mammal"));
		assertTrue(TextUtils.isAlphaOnly("placentalmammal"));
		assertTrue(TextUtils.isAlphaOnly("placental mammal", ' '));
		assertFalse(TextUtils.isAlphaOnly("placental_mammal", ' '));
	}

	@Test
	public void isAlphaPunctuationOnly() throws Throwable {
		assertTrue(TextUtils.isAlphaPunctuationOnly("jack"));
		assertTrue(TextUtils.isAlphaPunctuationOnly("jack aubrey"));
		assertTrue(TextUtils.isAlphaPunctuationOnly("jack "));
		assertFalse(TextUtils.isAlphaPunctuationOnly("jack 3"));
	}

	@Test
	public void removeSpecialCharacters() throws Throwable {
		assertEquals("jumpsuit shop", TextUtils.removeSpecialCharacters("jumpsuit 😍💘 shop"));
	}
}
