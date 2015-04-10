package com.trimc.blogger.commons;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.trimc.blogger.commons.utils.Stopwatch;

public final class StopwatchTest {

	public static LogManager	logger		= new LogManager(StopwatchTest.class);

	private static final int	THRESHOLD	= 500;

	@Test
	public void run() throws Throwable {

		Stopwatch timer = new Stopwatch();

		Thread.sleep(THRESHOLD);

		assertTrue(toInt(timer.getTotalMilliseconds()) >= THRESHOLD);

		/* expecting something like '282 ms'
		 * the exact time will vary given the uncertainty of this test */
		assertTrue(timer.getTotalTime().endsWith(" ms"));
		assertTrue(toInt(timer.getTotalTime()) >= THRESHOLD);
	}

	private Integer toInt(String text) {
		String original = text;

		text = text.replaceAll(",", "");
		if (text.endsWith("ms")) {
			text = StringUtils.substringBefore(text, "ms").trim();
		}

		try {
			return Integer.parseInt(text);

		} catch (NumberFormatException e) {
			logger.error(e, "Invalid Integer (original = %s, modified = %s)", original, text);
		}

		return null;
	}
}
