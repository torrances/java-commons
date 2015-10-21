package com.trimc.blogger.commons.xml;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;
import com.trimc.blogger.commons.type.Codepage;
import com.trimc.blogger.commons.utils.string.StringUtils;

@SuppressWarnings("deprecation")
public class DomUtils {

	public static LogManager logger = new LogManager(DomUtils.class);

	public static final String[] NAMESPACES = { "<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"<?xml version=\"1.1\" encoding=\"UTF-16\"?>" };

	public static String cleanse(String line) {
		if (!StringUtils.hasValue(line))
			return line;

		line = StringUtils.cleanseAmpersands(line);
		line = line.replaceAll("\\&#160;", ""); // non-breaking space
		line = line.replaceAll("\"", "'");

		return line.trim();
	}

	public static Document createDOM() throws BusinessException {
		return createDOM(true);
	}

	public static Document createDOM(boolean isNamespaceAware) throws BusinessException {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(isNamespaceAware);
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.newDocument();

		} catch (ParserConfigurationException ex) {
			throw new BusinessException(ex);
		}
	}

	public static Document createDOM(File file) throws BusinessException {
		try {

			return createDOM(new FileInputStream(file));

		} catch (FileNotFoundException e) {
			throw new BusinessException(e);
		}
	}

	public static Document createDOM(InputStream stream) throws BusinessException {
		return createDOM(stream, true);
	}

	public static Document createDOM(InputStream stream, boolean isNamespaceAware) throws BusinessException {
		try {

			Document result = null;
			if (stream != null) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				factory.setNamespaceAware(isNamespaceAware);
				DocumentBuilder builder;
				builder = factory.newDocumentBuilder();
				builder.isNamespaceAware();

				try {
					result = builder.parse(stream);
				} catch (SAXParseException e) {
					throw new BusinessException(e);
				}

				StringUtils.reset(stream);

			} else {
				createDOM();
			}

			stream.close();
			return result;

		} catch (IOException ex) {
			throw new BusinessException(ex);
		} catch (ParserConfigurationException ex) {
			throw new BusinessException(ex);
		} catch (SAXException ex) {
			throw new BusinessException(ex);
		}
	}

	public static Document createDOM(String rootName) throws BusinessException {
		Element root = createDOM(rootName, true);
		return (null != root) ? root.getOwnerDocument() : null;
	}

	public static Element createDOM(String rootName, boolean isNamespaceAware) throws BusinessException {
		Document dom = createDOM(isNamespaceAware);
		return (Element) dom.appendChild(dom.createElement(rootName));
	}

	public static Document createDOMByString(String input) throws BusinessException {
		try {

			input = StringUtils.cleanseAmpersands(input);
			InputSource is = new InputSource(new StringReader(input));
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

		} catch (ParserConfigurationException e) {
			logger.error(e);
			logger.debug("Failed XML:\n%s", input);
			throw new BusinessException("Parser Configuration Error (message = %s)", e.getMessage());
		} catch (SAXException e) {
			logger.error(e);
			logger.debug("Failed XML:\n%s", input);
			throw new BusinessException("SAX Error (message = %s)", e.getMessage());
		} catch (IOException e) {
			logger.error(e);
			logger.debug("Failed XML:\n%s", input);
			throw new BusinessException("IO Error (message = %s)", e.getMessage());
		}
	}

	public static void detachFromParent(Collection<Element> elements) {
		for (Element element : elements)
			detachFromParent(element);
	}

	public static void detachFromParent(Element el) {
		Node parent = el.getParentNode();
		if (null != parent)
			parent.removeChild(el);
	}

	public static void detachFromParent(Element... elements) {
		for (Element element : elements)
			detachFromParent(element);
	}

	public static Node detachFromParent(Node node) {
		Node result = null;

		if (null != node) {
			Node parent = node.getParentNode();
			if (parent != null) {
				parent.removeChild(node);
				result = node;
			}
		}

		return result;
	}

	public static InputStream dom2InputStream(Document dom, Codepage codepage) throws BusinessException {
		try {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Writer writer = new BufferedWriter(new OutputStreamWriter(baos, codepage.toString()));

			if (dom != null) {
				OutputFormat format = new OutputFormat(dom, codepage.toString(), true);
				XMLSerializer toStream = new XMLSerializer(writer, format);
				toStream.asDOMSerializer();
				toStream.serialize(dom);
			}

			return new ByteArrayInputStream(baos.toByteArray());

		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	public static InputStream element2InputStream(Element elem, Codepage codepage) throws BusinessException {
		try {

			StringWriter writer = new StringWriter();

			OutputFormat format = new OutputFormat(elem.getOwnerDocument(), codepage.toString(), true);
			XMLSerializer toStream = new XMLSerializer(writer, format);
			toStream.asDOMSerializer();
			toStream.serialize(elem);

			return new ByteArrayInputStream(writer.toString().getBytes());

		} catch (IOException ex) {
			throw new BusinessException(ex);
		}
	}

	public static Element[] getChildElements(Document dom, String string) {
		return getChildElements(dom.getDocumentElement(), string);
	}

	public static Element[] getChildElements(Element source, String name) {
		if (null == source)
			return null;

		List<Node> list = new ArrayList<Node>();
		NodeList children = source.getChildNodes();
		for (int p = 0; p < children.getLength(); p++) {
			if (children.item(p).getNodeName().compareTo(name) == 0) {
				list.add(children.item(p));
			}
		}

		return toElementList(list);
	}

	public static Element[] getChildElements(Node source) {
		Element[] result = new Element[0];

		if (source != null) {
			List<Node> list = new ArrayList<Node>();
			NodeList children = source.getChildNodes();
			for (int p = 0; p < children.getLength(); p++) {
				if (getNodeType(children.item(p)) == Node.ELEMENT_NODE) {
					list.add(children.item(p));
				}
			}

			result = (Element[]) list.toArray(new Element[list.size()]);
		}

		return result;
	}

	public static Element getFirstChildElement(Element elem) {
		Element result = null;

		Element[] children = getChildElements(elem);
		if (children.length != 0) {
			result = children[0];
		}

		return result;
	}

	public static Element getFirstDescendantOrSelfElement(Document dom, String name) {
		if (null == dom)
			return null;

		return getFirstDescendantOrSelfElement(dom.getDocumentElement(), name);
	}

	public static Element getFirstDescendantOrSelfElement(Element elem, String name) {
		return getFirstDescendantOrSelfElement(elem, new String[] { name });
	}

	public static Element getFirstDescendantOrSelfElement(Element el, String... names) {
		if (null == el)
			return null;

		Element result = null;
		if (testElement(el, names)) {
			result = el;
		}

		else {
			NodeList children = el.getChildNodes();
			for (int p = 0; p < children.getLength(); p++) {
				if (getNodeType(children.item(p)) == Node.ELEMENT_NODE) {
					Element childElement = (Element) children.item(p);
					result = getFirstDescendantOrSelfElement(childElement, names);
					if (result != null) {
						break;
					}
				}
			}
		}

		return result;
	}

	public static Element getNextElement(Node node) {
		while (null != node) {
			node = node.getNextSibling();
			if (node != null) {
				if (getNodeType(node) == Node.ELEMENT_NODE) {
					break;
				}
			} else {
				break;
			}
		}

		return (Element) node;
	}

	public static short getNodeType(Node node) {
		short result = 0;
		if (null != node)
			result = node.getNodeType();

		return result;
	}

	public static String getTextValue(Element element) {
		StringBuilder sb = new StringBuilder();

		NodeList children = element.getChildNodes();
		for (int p = 0; p < children.getLength(); p++) {
			short type = getNodeType(children.item(p));
			if (Node.TEXT_NODE == type || Node.CDATA_SECTION_NODE == type) {
				sb.append(((Text) children.item(p)).getNodeValue());
			}
		}

		return sb.toString().trim();
	}

	public static boolean testElement(Element elem, String name) {
		boolean result = false;
		if (null != elem)
			result = elem.getNodeName().compareTo(name) == 0;

		return result;
	}

	public static boolean testElement(Element elem, String[] names) {
		boolean result = false;
		if (elem != null) {
			String name = elem.getNodeName();
			if (StringUtils.match(name, names, true)) {
				result = true;
			}
		}

		return result;
	}

	public static Element[] toElementList(List<Node> list) {
		Element[] result = new Element[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = (Element) list.get(i);
		}

		return result;
	}

	public static String toString(Element root, boolean useNamespace) {
		StringBuffer sb = new StringBuffer();

		try {

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			StringWriter writer = new StringWriter();
			Result result = new StreamResult(writer);
			Source source = new DOMSource(root);
			transformer.transform(source, result);
			writer.close();
			sb = new StringBuffer(writer.toString());

		} catch (IOException e) {
			logger.error(e);
		} catch (TransformerException e) {
			logger.error(e);
		}

		if (useNamespace)
			return sb.toString();

		String buffer = sb.toString();
		for (String ns : NAMESPACES)
			if (buffer.contains(ns))
				return StringUtils.substringAfter(buffer, ns);

		return buffer;
	}
}
