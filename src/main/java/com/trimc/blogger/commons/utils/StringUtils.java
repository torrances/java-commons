package com.trimc.blogger.commons.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static LogManager	logger	= new LogManager(StringUtils.class);

	public static String cleanseAmpersands(String input) {
		if (!StringUtils.hasValue(input)) return input;

		input = input.replaceAll("&amp;", "&");
		input = input.replaceAll("&", "&amp;");

		return input;
	}

	public static String format(Object value) {
		return format(value, "###,###.###");
	}

	public static String format(Object value, String format) {
		return new DecimalFormat(format).format(value);
	}

	public static String format(String value, Object... args) {
		return (value.contains("%s")) ? String.format(value, args) : value;
	}

	public static String formatPct(String value) {

		if ("0".equals(value)) return "0";
		else if ("1".equals(value)) return "100";

		if (value.startsWith("0.")) {
			value = substringAfter(value, "0.");

			if (value.length() < 2) {
				if (1 == value.length()) value = value.concat("0.00");
				else value = value.concat(".00");
			}

			else {

				while (value.length() < 4)
					value = value.concat("0");

				value = value.substring(0, 2).concat(".").concat(value.substring(2, 4));
			}
		}

		// remove leading zeros
		while (value.startsWith("0"))
			value = value.substring(1);

		return value;
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

	/**
	 * proper sorting requires padded values 6 => 00006 31 => 00031 100 => 00100
	 * 
	 * otherwise java would sort this as descending (large to small): 6 31 100
	 * 
	 * and ascending (small to large): 100 31 6
	 * 
	 * @param x
	 * @param places
	 * @return a padded value
	 */
	public static String pad(int x, int places, String padding) {
		String value = String.valueOf(x);

		while (value.length() < places)
			value = padding.concat(value);

		return value;
	}

	public static String pad(Object x, int places) {
		return pad(x.toString(), places);
	}

	public static String pad(Object x, int places, String padding) {
		return pad(x.toString(), places, padding);
	}

	/*public static String pad(String x, int places) {
		try {

			String value = String.valueOf(x);
			while (value.length() < places)
				value = "0".concat(value);

			return value;

		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}*/

	public static String pad(String x, int places) {
		return pad(x, places, "0");
	}

	public static String pad(String x, int places, String padding) {
		try {

			String value = String.valueOf(x);
			while (value.length() < places)
				value = padding.concat(value);

			return value;

		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String replaceAllMaintainCase(String line, String key) {
		return replaceAllMaintainCase(line, key, "");
	}

	public static String replaceAllMaintainCase(String line, String key, String value) {

		String _line = line.toLowerCase();
		String _key = key.toLowerCase();

		int x = _line.indexOf(_key);
		if (x == -1) return line;

		int y = x + _key.length();

		StringBuilder sb = new StringBuilder();
		sb.append(line.substring(0, x));

		sb.append(" ");
		if (hasValue(value)) {
			sb.append(value);
			sb.append(" ");
		}

		sb.append(line.substring(y));

		// System.err.println(line.substring(0, x) + "   -----    " +
		// line.substring(y));
		return trim(sb.toString());
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
		List<String> list = new ArrayList<String>();

		int total = 0;
		StringBuilder sb = new StringBuilder();

		String[] tokens = value.split(" ");
		for (int i = 0; i < tokens.length; i++) {

			total += tokens[i].length();
			sb.append(tokens[i] + " ");

			if (total >= length) {
				list.add(trim(sb.toString()));
				sb = new StringBuilder();
				total = 0;
			}
		}

		list.add(sb.toString().trim());
		return list;
	}

	public static String substringAfter(String text, String... delims) {
		for (String delimiter : delims) {
			if (text.indexOf(delimiter) != -1) {
				text = substringAfter(text, delimiter);
			}
		}

		return text.trim();
	}

	public static String substringAfter(String text, String del) {
		String result = "";

		if (text != null) {
			int pos = text.indexOf(del);
			if (pos != -1) {
				if (pos < text.length()) {
					result = text.substring(pos + del.length());
				}
			}
		}

		return result.trim();
	}

	public static String substringAfterLast(String text, String delim) {
		String returnStr = "";

		if (text != null && text.length() > 0) {
			int lastPos = text.lastIndexOf(delim);
			if ((lastPos != -1) && (lastPos < text.length())) {
				returnStr = text.substring(lastPos + delim.length());
			}
		}

		return returnStr;
	}

	public static String substringBefore(String text, String del) {
		String result = "";

		if (text != null) {
			int pos = text.indexOf(del);
			if (pos > 0) {
				result = text.substring(0, pos);
			}
		}

		return result;
	}

	public static String substringBeforeLast(String text, String delim) {
		String returnStr = "";

		if (text != null && text.length() > 0) {
			int lastPos = text.lastIndexOf(delim);
			if ((lastPos != -1) && (lastPos > 0)) {
				returnStr = text.substring(0, lastPos);
			}
		}

		return returnStr.trim();
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

	@Test
	public void split() throws Throwable {
		String input = "microbial influenced corrosion and underdeposit corrosion";
		Collection<String> l1 = split(input, 25, false);
		assertNotNull(l1);
		assertEquals(2, l1.size());
	}

}
