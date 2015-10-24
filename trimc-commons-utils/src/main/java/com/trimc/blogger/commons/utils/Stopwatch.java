package com.trimc.blogger.commons.utils;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.utils.string.StringUtils;

public class Stopwatch {

	public static LogManager logger = new LogManager(Stopwatch.class);

	public static final Long MILLISECOND = 1L;

	public static final Long SECOND = MILLISECOND * 1000;

	public static final Long MINUTE = SECOND * 60;

	public static final Long HOUR = MINUTE * 60;

	public static final Long DAY = HOUR * 24;

	public static final Long WEEK = DAY * 7;

	public static final Long YEAR = WEEK * 52;

	private Long end;

	private Long start;

	public Stopwatch() {
		setStart(System.currentTimeMillis());
	}

	public Long getEnd() {
		setEnd(System.currentTimeMillis() - getStart());
		return end;
	}

	private Long getStart() {
		return start;
	}

	public String getTotalHours() {
		return StringUtils.format(getEnd() / HOUR);
	}

	public String getTotalMilliseconds() {
		return StringUtils.format(getEnd());
	}

	public String getTotalMinutes() {
		return StringUtils.format(getEnd() / MINUTE);
	}

	public String getTotalSeconds() {
		return StringUtils.format(getEnd() / SECOND);
	}

	public String getTotalTime() {

		/* Between 0 - 5 seconds use milliseconds */
		if (getEnd() < 5000) {
			return getTotalMilliseconds().concat(" ms");
		}

		/* Between 5 - 90 seconds use seconds */
		else if (getEnd() >= 5000 && getEnd() < 120000) {
			return getTotalSeconds().concat(" seconds");
		}

		/*
		 * Between 120 seconds - 90 minutes use minutes Start = 90 * 1000 =
		 * 90,000 End = 90 * 60 * 1000 = 5,400,000
		 */
		else if (getEnd() >= 120000 && getEnd() < 5400000) {
			return getTotalMinutes().concat(" minutes");
		}

		/* Over 90 minutes use hours */
		return getTotalHours().concat(" hours");
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	private void setStart(Long start) {
		this.start = start;
	}
}
