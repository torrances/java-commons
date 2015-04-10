package com.trimc.blogger.commons.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class RegexUtils {

	private static final String	ANY_WORD	= "([a-z]+)";

	private static final String	SPACE		= "([\\s])";

	public static String normalizeRanges(String input) {
		if (!input.contains("%")) return input;

		/* transform "17-25%" into "17 to 25 percent" */
		input = input.replaceAll("([0-9]+)([\\-])([0-9]+)([\\%])", "$1 to $3 percent");

		return input;
	}

	/**
	 * perform "Simple And List" (SAL) normalization
	 * 
	 * @param input
	 *            original line
	 * @return normalized line
	 */
	public static String normalizeSimpleAndList(String input) {

		/*
		 * required normalization:
		 * 
		 * normalize this pattern: the <token> and <token> <types> becomes the
		 * <token> <type> and the <token> <type>
		 * 
		 * for example the arkoma and anadarko basins becomes the arkoma basin
		 * and the anadarko basin
		 */

		StringBuilder sb = new StringBuilder();
		sb.append("(the)"); /* group 1 */
		sb.append(SPACE); /* group 2 */
		sb.append(ANY_WORD); /* group 3 */
		sb.append(SPACE); /* group 4 */
		sb.append("(and)"); /* group 5 */
		sb.append(SPACE); /* group 6 */
		sb.append("(the )?"); /* group 7 */
		sb.append(ANY_WORD); /* group 8 */
		sb.append(SPACE); /* group 9 */
		sb.append("([a-z]+)"); /* group 10 */
		sb.append("([s])"); /* group 111 */

		// System.err.println(sb.toString());
		input = input.replaceAll(sb.toString(), "the $3 $10 and the $8 $10");

		return input;
	}

	public static Collection<String> reverseDotNotation(Collection<String> lines) {
		List<String> list = new ArrayList<String>();

		for (String line : lines)
			list.add(reverseDotNotation(line));

		return list;
	}

	public static String reverseDotNotation(String input) {
		return input.replaceAll("_DOT_", "\\.");
	}

	/**
	 * replace periods with _DOT_ for abbreviations
	 * 
	 * @param input
	 *            p.o. box 745
	 * @return p_DOT_o_DOT_ box 745
	 */
	public static String useDotNotationForAbbreviations(String input) {
		if (!input.contains(".")) return input;

		String original = input;

		/*
		 * complete all X.Y.Z. patterns first eg. u.s.a. => u_DOT_s_DOT_a_DOT_
		 */
		input = input.replaceAll("([A-Za-z])([\\.])([A-Za-z])(\\.)([A-Za-z])([\\.])?", "$1_DOT_$3_DOT_$5_DOT_");
		input = (!original.equals(input)) ? useDotNotationForAbbreviations(input) : input;

		/*
		 * complete all X.Y. patterns first eg. p.o. => p_DOT_o_DOT_
		 */
		input = input.replaceAll("([A-Za-z])([\\.])([A-Za-z])(\\.)", "$1_DOT_$3_DOT_");
		input = (!original.equals(input)) ? useDotNotationForAbbreviations(input) : input;

		/*
		 * now focus on XY. patterns eg. mr. => mr_DOT_
		 * (starts with XY.)
		 */
		if (!input.endsWith(".")) input = input.replaceAll("^([A-Za-z])([A-Za-z])([\\.])", "$1$2_DOT_");
		input = (!original.equals(input)) ? useDotNotationForAbbreviations(input) : input;

		/*
		 * now focus on XY. patterns eg. mr. => mr_DOT_
		 * (contains XY.)
		 */
		if (!input.endsWith(".")) input = input.replaceAll("\\s([A-Za-z])([A-Za-z])([\\.])", "$1$2_DOT_");
		input = (!original.equals(input)) ? useDotNotationForAbbreviations(input) : input;

		return input;
	}

	/**
	 * replace periods with _DOT_ for numbers
	 * 
	 * @param input
	 *            0.5
	 * @return 0_DOT_5
	 */
	public static String useDotNotationForNumbers(String input) {
		if (!input.contains(".")) return input;

		String original = input;

		/* transform 0.3 => 0_DOT_3 */
		input = input.replaceAll("([0-9]+)([\\.])([0-9]+)", "$1_DOT_$3");

		return (!original.equals(input)) ? useDotNotationForNumbers(input) : input;
	}
}
