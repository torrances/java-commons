package com.trimc.blogger.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.trimc.blogger.commons.type.GoogleNgramPosTag;

public final class GoogleNgramPosTagTest {

	@Test
	public void run() throws Throwable {
		assertEquals(GoogleNgramPosTag.PUNCTUATION, GoogleNgramPosTag.find("."));
	}
}
