package com.trimc.blogger.commons.utils.string;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static LogManager logger = new LogManager(StringUtils.class);

	public static String cleanseAmpersands(String input) {
		if (!StringUtils.hasValue(input)) return input;

		input = input.replaceAll("&amp;", "&");
		input = input.replaceAll("&", "&amp;");

		return input;
	}

	public static String format(Object value) {
		return StringUtils$Format.format(value);
	}

	public static String format(Object value, String format) {
		return StringUtils$Format.format(value, format);
	}

	public static String format(String value, Object... args) {
		return StringUtils$Format.format(value, args);
	}

	public static String formatPct(String value) {
		return StringUtils$Format.formatPct(value);
	}

	public static int getMatchIndex(String text, String[] stoppers, boolean caseSensitive) {
		int result = -1;

		if (stoppers != null) {
			if (caseSensitive) {
				for (int p = 0; p < stoppers.length; p++) {
					if (text.compareTo(stoppers[p]) == 0) {
						result = p;
						break;
					}
				}
			} else {
				for (int p = 0; p < stoppers.length; p++) {
					if (text.compareToIgnoreCase(stoppers[p]) == 0) {
						result = p;
						break;
					}
				}
			}
		}

		return result;
	}

	public static boolean hasValue(String input) {
		return null != input && trim(input).length() > 0;
	}

	public static boolean hasValue(StringBuffer sb) {
		return hasValue(sb.toString());
	}

	public static boolean hasValue(StringBuilder sb) {
		return hasValue(sb.toString());
	}

	public static boolean match(String text, String[] stoppers, boolean caseSensitive) {
		return getMatchIndex(text, stoppers, caseSensitive) != -1;
	}

	public static String pad(double x, int places) {
		return pad((int) x, places);
	}

	public static String pad(int x) {
		return pad(x, 10);
	}

	public static String pad(int x, int places) {
		return pad(x, places, "0");
	}

	public static String pad(int x, int places, String padding) {
		return StringUtils$Pad.pad(x, places, padding);
	}

	public static String pad(Object x, int places) {
		return pad(x.toString(), places);
	}

	public static String pad(Object x, int places, String padding) {
		return pad(x.toString(), places, padding);
	}

	public static String pad(String x, int places) {
		return pad(x, places, "0");
	}

	public static String pad(String x, int places, String padding) {
		return StringUtils$Pad.pad(x, places, padding);
	}

	public static String replaceAllMaintainCase(String line, String key) {
		return replaceAllMaintainCase(line, key, "");
	}

	public static String replaceAllMaintainCase(String line, String key, String value) {
		return StringUtils$ReplaceAllMaintainCase.replaceAllMaintainCase(line, key, value);
	}

	public static void reset(InputStream inputStream) {
		if (null != inputStream && inputStream instanceof ByteArrayInputStream) {
			try {
				inputStream.reset();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Collection<String> split(String value, int length, boolean force) {
		return StringUtils$Split.split(value, length, force);
	}

	public static String substringAfter(String text, String... delims) {
		return StringUtils$Substring.substringAfter(text, delims);
	}

	public static String substringAfter(String text, String delim) {
		return StringUtils$Substring.substringAfter(text, delim);
	}

	public static String substringAfterLast(String text, String delim) {
		return StringUtils$Substring.substringAfterLast(text, delim);
	}

	public static String substringBefore(String text, String delim) {
		return StringUtils$Substring.substringBefore(text, delim);
	}

	public static String substringBeforeLast(String text, String delim) {
		return StringUtils$Substring.substringBeforeLast(text, delim);
	}

	public static String tabs(int count) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < count; i++)
			sb.append("\t");

		return sb.toString();
	}

	public static InputStream toInputStream(File file) throws FileNotFoundException {
		return new FileInputStream(file);
	}

	public static InputStream toInputStream(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}

	public static InputStream toInputStream(String input, Codepage codepage) throws BusinessException {
		try {

			return new ByteArrayInputStream(input.getBytes(codepage.toString()));

		} catch (UnsupportedEncodingException e) {
			throw new BusinessException(e);
		}
	}

	public static InputStream toInputStream(StringBuffer sb) {
		return toInputStream(sb.toString());
	}

	public static InputStream toInputStream(StringBuilder sb) {
		return toInputStream(sb.toString());
	}

	public static String toString(Collection<?> collection, String delimiter) {
		StringBuilder sb = new StringBuilder();

		Iterator<?> iter = collection.iterator();
		while (iter.hasNext()) {
			sb.append(iter.next());
			if (iter.hasNext()) sb.append(delimiter);
		}

		return sb.toString();
	}

	public static String toString(InputStream inputStream) throws BusinessException {
		try {

			StringBuilder sb = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			inputStream.close();
			return sb.toString();

		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	public static String trim(String line) {

		while (line.contains("  "))
			line = line.replaceAll("  ", " ");

		while (line.contains("\t")) {
			line = line.replaceAll("\t", " ");
		}

		return line.trim();
	}

	public static char unicodeNormalization(char ch) {
		return StringUtils$UnicodeNormalization.unicodeNormalization(ch);
	}

	public static String unicodeNormalization(String text) {
		return StringUtils$UnicodeNormalization.unicodeNormalization(text);
	}
}
