package com.trimc.blogger.commons.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;
import com.trimc.blogger.commons.utils.StringUtils;

@SuppressWarnings("deprecation")
public class XmlFormatter {

	public static LogManager	logger	= new LogManager(XmlFormatter.class);

	private static String cleanse(String input) {

		/* apostrophes break the formatter */
		input = input.replaceAll("\\'", "");

		return input;
	}

	public static Document format(Document document, Codepage codepage) throws BusinessException {
		InputStream isResult = format(DomUtils.dom2InputStream(document, codepage), codepage);
		return DomUtils.createDOM(isResult);
	}

	public static Document format(File file, Codepage codepage) throws BusinessException {
		return format(DomUtils.createDOM(file), codepage);
	}

	public static InputStream format(InputStream isSource, Codepage codepage) throws BusinessException {
		String strOutput = format(StringUtils.toString(isSource), codepage);
		return StringUtils.toInputStream(strOutput);
	}

	public static String format(String input, Codepage codepage) {

		input = cleanse(input);
		try {

			final Document document = parseXmlFile(input);
			OutputFormat format = new OutputFormat(document, codepage.toString(), true);
			format.setLineWidth(50000);
			format.setIndenting(false);
			format.setIndent(5);
			return serialize(format, document);

		} catch (BusinessException e) {
			logger.error(e);
			return input;
		}
	}

	public static String format(StringBuilder sb, Codepage codepage) {
		return format(sb.toString(), codepage);
	}

	public static void log(Element root, Codepage codepage) {
		log(toString(root, codepage));
	}

	public static void log(String strResult) {
		logger.info("Formatted XML\n(%s)", strResult);
	}

	private static Document parseXmlFile(String in) throws BusinessException {
		try {

			in = DomUtils.cleanse(in);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(in));
			return db.parse(is);

		} catch (ParserConfigurationException e) {
			logger.error("Failed to Process Line: %s", in);
			throw new BusinessException(e.getMessage());
		} catch (SAXException e) {
			logger.error("Failed to Process Line: %s", in);
			throw new BusinessException(e.getMessage());
		} catch (IOException e) {
			logger.error("Failed to Process Line: %s", in);
			throw new BusinessException(e.getMessage());
		}
	}

	private static String serialize(OutputFormat format, Document dom) throws BusinessException {
		Writer out = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(out, format);

		try {

			serializer.serialize(dom);

		} catch (IOException e) {
			logger.error(e);
			throw new BusinessException("Unable to serialize document");
		}

		return out.toString();
	}

	public static String toCondensedString(Document dom, Codepage codepage) {
		return toCondensedString(dom.getDocumentElement(), codepage);
	}

	public static String toCondensedString(Element root, Codepage codepage) {
		return toCondensedString(toString(root, codepage), codepage);
	}

	public static String toCondensedString(String result, Codepage codepage) {
		String ns = String.format("<?xml version=\"1.0\" encoding=\"%s\"?>", codepage.toString());
		result = StringUtils.substringAfter(result, ns);

		return result.trim();
	}

	public static String toString(Document dom, Codepage codepage) {
		return toString(dom.getDocumentElement(), codepage);
	}

	public static String toString(Element root, Codepage codepage) {
		try {

			InputStream isResult = format(DomUtils.element2InputStream(root, codepage), codepage);
			return format(StringUtils.toString(isResult), codepage);

		} catch (Exception e) {
			logger.error(e, "Unable to format DOM");
		}

		return "Exception occurred, couldn't format this XML for logging. XML will not be logged";
	}

	public XmlFormatter() {}
}
