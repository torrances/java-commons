package com.trimc.blogger.commons.type;

import com.trimc.blogger.commons.LogManager;

public enum Codepage {

	ANSII("ansii"),

	/* The Windows-1252 codepage coincides with ISO-8859-1 for all codes except the range 128 to 159 (hex 80 to 9F),
	 * where the little-used C1 controls are replaced with additional characters including all the missing characters 
	 * provided by ISO-8859-15. */
	ISO_8859_1("ISO-8859-1"),

	/* Latin with macrons, M�?ori */
	ISO_8859_13("ISO-8859-13"),

	/* Irish (traditional orthography) */
	ISO_8859_14("ISO-8859-14"),

	/* French, Finnish, Estonian */
	ISO_8859_15("ISO-8859-15"),

	/* Romanian, Czech */
	ISO_8859_2("ISO-8859-2"),

	/* Turkish */
	ISO_8859_3("ISO-8859-3"),

	/* Turkish */
	ISO_8859_9("ISO-8859-9"),

	UTF_16BE("utf-16be"),

	UTF_16LE("utf-16le"),

	UTF_32("utf-32"),

	UTF_32BE("utf-32be"),

	UTF_32LE("utf-32le"),

	/* The Internationally defined Standard ISO/IEC 10646, Universal Character Set (UCS) know as UTF-8 
	 * ('U' from Universal Character Set + Transformation Format—8-bit) is a variable-width encoding 
	 * that can represent every character in the Unicode character set. 
	 * 
	 * It was designed for backward compatibility with ASCII and to avoid the complications of endianness and byte order marks in UTF-16 and UTF-32. */
	UTF_8("utf-8"),

	/* The popular Windows-1252 character set adds all the missing characters provided by ISO/IEC 8859-15, plus a number 
	 * of typographic symbols, by replacing the rarely used C1 controls in the range 128 to 159 (hex 80 to 9F). 
	 * It is very common to mislabel text data with the charset label ISO-8859-1, even though the data is really
	 * Windows-1252 encoded. 
	 * 
	 * Many web browsers and e-mail clients will interpret ISO-8859-1 control codes as Windows-1252 characters 
	 * in order to accommodate such mislabeling but it is not standard behaviour and care should be taken to 
	 * avoid generating these characters in ISO-8859-1 labeled content. */
	WINDOWS_1252("Windows-1252");

	public static LogManager	logger	= new LogManager(Codepage.class);

	public static Codepage find(String name) {
		for (Codepage value : Codepage.values())
			if (value.toString().equalsIgnoreCase(name)) return value;

		logger.error("Codepage not Recognized (name = %s)", name);
		return null;
	}

	private String	name;

	private Codepage(String name) {
		setName(name);
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return getName();
	}
}
