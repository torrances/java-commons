package com.trimc.blogger.commons.xml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.trimc.blogger.commons.exception.BusinessException;

public final class XpathUtils {

	public static NodeList evaluate(Document dom, String expression) throws BusinessException {
		try {

			Object result = getXpathExpression(expression).evaluate(dom, XPathConstants.NODESET);
			return (NodeList) result;

		} catch (XPathExpressionException e) {
			throw new BusinessException(e, "Failed to Execute Xpath Expression (%s)", expression);
		}
	}

	public static NodeList evaluate(Element el, String expression) throws BusinessException {
		try {

			Object result = getXpathExpression(expression).evaluate(el, XPathConstants.NODESET);
			return (NodeList) result;

		} catch (XPathExpressionException e) {
			throw new BusinessException(e, "Failed to Execute Xpath Expression (%s)", expression);
		}
	}

	public static Collection<Element> evaluateElements(Document dom, String expression) throws BusinessException {
		List<Element> list = new ArrayList<Element>();

		NodeList nodelist = evaluate(dom, expression);
		for (int i = 0; i < nodelist.getLength(); i++) {
			Node node = nodelist.item(i);
			if (Node.ELEMENT_NODE == node.getNodeType()) {
				list.add((Element) node);
			}
		}

		return list;
	}

	public static Element evaluateFirstElement(Document dom, String expression) throws BusinessException {
		Collection<Element> collection = evaluateElements(dom, expression);
		return collection.isEmpty() ? null : collection.iterator().next();
	}

	public static String evaluateText(Document dom, String xpathExpression) throws BusinessException {
		NodeList nodeList = evaluate(dom, xpathExpression);
		if (null == nodeList) {
			return null;
		}

		return nodeList.item(0).getTextContent();
	}

	private static XPathExpression getXpathExpression(String expression) throws BusinessException {
		try {

			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			return xpath.compile(expression);

		} catch (XPathExpressionException e) {
			throw new BusinessException(e, "Failed to Compile Xpath Expression (%s)", expression);
		}
	}
}
