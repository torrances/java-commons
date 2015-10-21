package com.trimc.blogger.commons.utils.string;

import java.text.DecimalFormat;

import com.trimc.blogger.commons.LogManager;

public class StringUtils$Format {

	public static LogManager logger = new LogManager(StringUtils.class);

	protected static String format(Object value) {
		return format(value, "###,###.###");
	}

	protected static String format(Object value, String format) {
		return new DecimalFormat(format).format(value);
	}

	protected static String format(String value, Object... args) {
		return (value.contains("%s")) ? String.format(value, args) : value;
	}

	protected static String formatPct(String value) {

		if ("0".equals(value))
			return "0";
		else if ("1".equals(value))
			return "100";

		if (value.startsWith("0.")) {
			value = StringUtils.substringAfter(value, "0.");

			if (value.length() < 2) {
				if (1 == value.length())
					value = value.concat("0.00");
				else
					value = value.concat(".00");
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
}
