package com.trimc.blogger.commons.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.utils.string.StringUtils;

public class TextUtils {

	public static final String[] ALPHA = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	public static final char[] ALPHA_CHARS_LOWER = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static final char[] ALPHA_CHARS_UPPER = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static final String[] ALPHA_LOWER = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static final String[] NUMBERS = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public static final char[] NUMBERS_CHARS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static final String[] PUNCTUATION = new String[] { " ", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "{", "]", "}", "\\\\", "|", ";", ":", "'", "\"", ",", "<", ".", ">", "/", "?", "~", "`" };

	public static final char[] PUNCTUATION_CHARS = new char[] { ' ', '"', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', '{', ']', '}', '|', ';', ':', '\'', ',', '<', '.', '>', '/', '?', '~', '`', '?' };

	public static boolean containsAlpha(String value) {
		for (char ch : value.toCharArray())
			if (isAlpha(ch)) return true;
		return false;
	}

	public static boolean containsNonEnglishChar(String token) {
		for (char ch : token.toCharArray())
			if (isNonEnglishChar(ch)) return true;
		return false;
	}

	public static boolean containsNumeric(String value) {
		for (char ch : value.toCharArray())
			if (isNumeric(ch)) return true;
		return false;
	}

	public static boolean containsOther(String value) {
		for (char ch : value.toCharArray())
			if (isOther(ch)) return true;
		return false;
	}

	public static boolean containsPunctuation(String value) {
		for (char ch : value.toCharArray())
			if (isPunctuation(ch)) return true;
		return false;
	}

	/**
	 * @param value			the value to test
	 * @param exceptions	list of exceptions
	 * @return				false if no punctuation exists 	(not counting the exceptions)
	 * 							{ exception : ' ', 	input : 'john doe', 	result : false }
	 * 							{ 					input : 'johndoe', 		result : false }
	 * 						true if there is punctuation	(not counting the exceptions)
	 * 							{ exception : ' ', 	input : 'john doe!', 	result : true }
	 */
	public static boolean containsPunctuationExcept(String value, char... exceptions) {
		for (char ch : value.toCharArray()) {

			if (!isPunctuation(ch)) continue;
			if (SetUtils.memberOf(ch, exceptions)) continue;

			return true;
		}

		return false;
	}

	public static boolean containsSpecial(String val) {
		for (String tmp : PUNCTUATION)
			if (val.equals(tmp)) return true;

		return false;
	}

	public static int countOccurences(String text, String value) {
		int total = 0;

		int x = text.indexOf(value);
		while (x != -1) {
			total++;
			text = (text.substring(0, x)) + (text.substring(x + value.length(), text.length()));
			x = text.indexOf(". ");
		}

		return total;
	}

	public static boolean endsWithPunctuation(String value) {
		if (!StringUtils.hasValue(value)) return false;
		return memberOfCharSet(value.toCharArray()[value.length() - 1], PUNCTUATION_CHARS);
	}

	public static boolean isAlpha(char ch) {
		return memberOfCharSet(ch, ALPHA_CHARS_UPPER) || memberOfCharSet(ch, ALPHA_CHARS_LOWER);
	}

	public static boolean isAlpha(String value) {
		for (char ch : value.toCharArray())
			if (!isAlpha(ch)) return false;
		return true;
	}

	public static boolean isAlphaNumeric(char ch) {
		return Character.isLetterOrDigit(ch);
	}

	public static boolean isAlphaNumeric(String value) {
		boolean isAlpha = false, isNumeric = false;

		for (char ch : value.toCharArray()) {
			if (isNumeric(ch)) isNumeric = true;
			else if (isAlpha(ch)) isAlpha = true;
			else return false;
		}

		return isAlpha && isNumeric;
	}

	public static boolean isAlphaNumericOnly(String value) {
		boolean isAlpha = false, isNumeric = false;

		for (char ch : value.toCharArray()) {
			if (isNumeric(ch)) isNumeric = true;
			else if (isAlpha(ch)) isAlpha = true;
			else return false;
		}

		return isAlpha && isNumeric;
	}

	public static boolean isAlphaNumericOther(String value) {
		boolean isAlpha = false, isNumeric = false, isOther = false;

		for (char ch : value.toCharArray()) {
			if (isAlpha(ch)) isAlpha = true;
			else if (isNumeric(ch)) isNumeric = true;
			else if (isOther(ch)) isOther = true;
			else return false;
		}

		return isAlpha && isNumeric && isOther;
	}

	public static boolean isAlphaNumericOtherOnly(String value) {
		boolean isAlpha = false, isNumeric = false, isOther = false;

		for (char ch : value.toCharArray()) {
			if (isAlpha(ch)) isAlpha = true;
			else if (isNumeric(ch)) isNumeric = true;
			else if (isOther(ch)) isOther = true;
			else return false;
		}

		return isAlpha && isNumeric && isOther;
	}

	public static boolean isAlphaNumericOtherPunctuationOnly(String value) {
		boolean isAlpha = false, isNumeric = false, isOther = false, isPunctuation = false;

		for (char ch : value.toCharArray()) {
			if (isAlpha(ch)) isAlpha = true;
			else if (isNumeric(ch)) isNumeric = true;
			else if (isOther(ch)) isOther = true;
			else if (isPunctuation(ch)) isPunctuation = true;
			else return false;
		}

		return isAlpha && isNumeric && isOther && isPunctuation;
	}

	public static boolean isAlphaNumericPunctuation(String value) {
		boolean isAlpha = false, isNumeric = false, isPunctuation = false;

		for (char ch : value.toCharArray()) {
			if (isAlpha(ch)) isAlpha = true;
			else if (isNumeric(ch)) isNumeric = true;
			else if (isPunctuation(ch)) isPunctuation = true;
			else return false;
		}

		return isAlpha && isNumeric && isPunctuation;
	}

	public static boolean isAlphaNumericPunctuationOnly(String value) {
		boolean isAlpha = false, isNumeric = false, isPunctuation = false;

		for (char ch : value.toCharArray()) {
			if (isAlpha(ch)) isAlpha = true;
			else if (isNumeric(ch)) isNumeric = true;
			else if (isPunctuation(ch)) isPunctuation = true;
			else return false;
		}

		return isAlpha && isNumeric && isPunctuation;
	}

	public static boolean isAlphaNumericPunctuationOther(String value) {
		boolean isAlpha = false, isNumeric = false, isPunctuation = false, isOther = false;

		for (char ch : value.toCharArray()) {
			if (isAlpha(ch)) isAlpha = true;
			else if (isNumeric(ch)) isNumeric = true;
			else if (isPunctuation(ch)) isPunctuation = true;
			else if (isOther(ch)) isOther = true;
			return false;
		}

		return isAlpha && isNumeric && isPunctuation && isOther;
	}

	public static boolean isAlphaOnly(String value) {
		for (char ch : value.toCharArray())
			if (!isAlpha(ch)) return false;
		return true;
	}

	public static boolean isAlphaOther(String value) {
		boolean isOther = false, isAlpha = false;

		for (char ch : value.toCharArray()) {
			if (isOther(ch)) isOther = true;
			else if (isAlpha(ch)) isAlpha = true;
			else return false;
		}

		return isOther && isAlpha;
	}

	public static boolean isAlphaOtherOnly(String value) {
		boolean isOther = false, isAlpha = false;

		for (char ch : value.toCharArray()) {
			if (isOther(ch)) isOther = true;
			else if (isAlpha(ch)) isAlpha = true;
			else return false;
		}

		return isOther && isAlpha;
	}

	/** TODO: add textutils tests ... */

	public static boolean isAlphaPunctuation(String value) {
		int alpha = 0;
		int punctuation = 0;

		for (char ch : value.toCharArray()) {
			if (isAlpha(ch)) alpha++;
			if (isPunctuation(ch)) punctuation++;
		}

		return alpha > 0 && punctuation > 0;
	}

	public static boolean isAlphaPunctuationOnly(String value) {
		int other = 0;

		for (char ch : value.toCharArray()) {
			if (isAlpha(ch)) continue;
			if (isPunctuation(ch)) continue;
			else other++;
		}

		return 0 == other;
	}

	public static boolean isEmpty(String text) {
		return null == text || 0 == text.trim().length();
	}

	public static boolean isLowerCase(char ch) {
		return Character.isLowerCase(ch);
	}

	public static boolean isLowerCase(String value) {
		for (char ch : value.toCharArray())
			if (!isLowerCase(ch)) return false;
		return true;
	}

	public static boolean isMixedCase(String value) {
		boolean isUpperCase = false, isLowerCase = false;

		for (char ch : value.toCharArray()) {
			if (isUpperCase(ch)) isUpperCase = true;
			if (isLowerCase(ch)) isLowerCase = true;
		}

		return isUpperCase && isLowerCase;
	}

	public static boolean isNonEnglishChar(char ch) {
		if (isNumeric(ch)) return false;
		if (memberOfCharSet(ch, ALPHA_CHARS_LOWER)) return false;
		if (memberOfCharSet(ch, ALPHA_CHARS_UPPER)) return false;
		if (memberOfCharSet(ch, PUNCTUATION_CHARS)) return false;

		/* nothing that I recognize */
		return true;
	}

	public static boolean isNumeric(char ch) {
		return Character.isDigit(ch);
	}

	public static boolean isNumeric(String value) {
		for (char ch : value.toCharArray())
			if (!isNumeric(ch)) return false;
		return true;
	}

	public static boolean isNumericOnly(String value) {
		for (char ch : value.toCharArray())
			if (!isNumeric(ch)) return false;
		return true;
	}

	public static boolean isNumericOtherOnly(String value) {
		boolean isNumeric = false, isOther = false;
		for (char ch : value.toCharArray())
			if (isNumeric(ch)) isNumeric = true;
			else if (isPunctuation(ch)) isOther = true;
			else return false;
		return isNumeric && isOther;
	}

	public static boolean isNumericPunctuation(String value) {
		boolean isNumeric = false, isPunctuation = false;

		for (char ch : value.toCharArray()) {
			if (isNumeric(ch)) isNumeric = true;
			if (isPunctuation(ch)) isPunctuation = true;
		}

		return isNumeric && isPunctuation;
	}

	public static boolean isNumericPunctuationOnly(String value) {
		boolean isNumeric = false, isPunctuation = false;

		for (char ch : value.toCharArray()) {
			if (isNumeric(ch)) isNumeric = true;
			if (isPunctuation(ch)) isPunctuation = true;
		}

		return isNumeric && isPunctuation;
	}

	public static boolean isOther(char ch) {
		if (isAlpha(ch)) return false;
		if (isNumeric(ch)) return false;
		if (isPunctuation(ch)) return false;
		return true;
	}

	public static boolean isOther(String value) {
		for (char ch : value.toCharArray())
			if (!isOther(ch)) return false;
		return true;
	}

	public static boolean isOtherNumeric(String value) {
		boolean isOther = false, isNumeric = false;

		for (char ch : value.toCharArray()) {
			if (isOther(ch)) isOther = true;
			if (isNumeric(ch)) isNumeric = true;
		}

		return isOther && isNumeric;
	}

	public static boolean isOtherOnly(String value) {
		for (char ch : value.toCharArray())
			if (!isOther(ch)) return false;
		return true;
	}

	public static boolean isOtherPunctuation(String value) {
		boolean isPunctuation = false, isOther = false;

		for (char ch : value.toCharArray()) {
			if (isPunctuation(ch)) isPunctuation = true;
			if (isOther(ch)) isOther = true;
		}

		return isPunctuation && isOther;
	}

	public static boolean isOtherPunctuationOnly(String value) {
		boolean isPunctuation = false, isOther = false;

		for (char ch : value.toCharArray()) {
			if (isPunctuation(ch)) isPunctuation = true;
			else if (isOther(ch)) isOther = true;
			return false;
		}

		return isPunctuation && isOther;
	}

	public static boolean isPunctuation(char ch) {
		return memberOfCharSet(ch, PUNCTUATION_CHARS);
	}

	public static boolean isPunctuation(char ch, char... exceptions) {
		for (char exceptionCh : exceptions)
			if (exceptionCh == ch) return false;
		return isPunctuation(ch);
	}

	public static boolean isPunctuation(String value) {
		for (char ch : value.toCharArray())
			if (!isPunctuation(ch)) return false;
		return true;
	}

	public static boolean isPunctuationOnly(String value) {
		for (char ch : value.toCharArray())
			if (!isPunctuation(ch)) return false;
		return true;
	}

	public static boolean isSpecial(char val) {
		return containsSpecial(String.valueOf(val));
	}

	public static boolean isUpperCase(char ch) {
		return Character.isUpperCase(ch);
	}

	public static boolean isUpperCase(String value) {
		for (char ch : value.toCharArray()) {
			if (' ' == ch) continue; /* don't count spaces in a multi-token value */
			if (!isUpperCase(ch)) return false;
		}

		return true;
	}

	public static boolean memberOfCharSet(char ch, char[] arr) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == ch) return true;

		return false;
	}

	public static List<String> read(File file) throws BusinessException {
		List<String> list = new ArrayList<String>();

		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			for (String line = reader.readLine(); null != line; line = reader.readLine()) {
				list.add(line);
			}

			reader.close();

		} catch (IOException e) {
			throw new BusinessException(e, String.format("Unable to Read File (%s)", file.getAbsolutePath()));
		}

		return list;
	}

	public static String removePunctuation(String value) {
		return removePunctuationExcept(value, new char[] {});
	}

	public static String removePunctuationExcept(String value, char... exceptions) {
		StringBuilder sb = new StringBuilder();

		for (char ch : value.toCharArray()) {
			if (isPunctuation(ch) && !memberOfCharSet(ch, exceptions)) continue;
			sb.append(String.valueOf(ch));
		}

		return sb.toString();
	}

	public static boolean startsWithAlpha(String value) {
		if (!StringUtils.hasValue(value)) return false;
		return memberOfCharSet(value.toUpperCase().toCharArray()[0], ALPHA_CHARS_UPPER);
	}

	public static boolean startsWithNumber(String value) {
		if (!StringUtils.hasValue(value)) return false;
		return memberOfCharSet(value.toCharArray()[0], NUMBERS_CHARS);
	}

	public static boolean startsWithOther(String value) {
		if (startsWithAlpha(value)) return false;
		if (startsWithNumber(value)) return false;
		if (startsWithPunctuation(value)) return false;

		return true;
	}

	public static boolean startsWithPunctuation(String value) {
		if (!StringUtils.hasValue(value)) return false;
		return memberOfCharSet(value.toCharArray()[0], PUNCTUATION_CHARS);
	}

	public static String toString(char... chars) {
		return new String(chars);
	}
}
