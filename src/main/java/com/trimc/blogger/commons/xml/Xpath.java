package com.trimc.blogger.commons.xml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.trimc.blogger.commons.LogManager;
import com.trimc.blogger.commons.exception.BusinessException;

public class Xpath {

	public static LogManager logger = new LogManager(Xpath.class);

	private Document dom;

	private Element element;

	private NodeList nodeList;

	public Xpath(Document dom) {
		setDom(dom);
	}

	public Xpath(Element el) {
		setElement(el);
	}

	public Collection<Element> elements() {
		List<Element> list = new ArrayList<Element>();

		final int SIZE = getNodeList().getLength();
		for (int i = 0; i < SIZE; i++) {

			Node node = getNodeList().item(i);
			if (Node.ELEMENT_NODE == node.getNodeType()) list.add((Element) node);
		}

		return list;
	}

	public Xpath evaluate(String expression) throws BusinessException {
		if (null != getDom()) setNodeList(XpathUtils.evaluate(getDom(), expression));
		else setNodeList(XpathUtils.evaluate(getElement(), expression));

		logger.debug("XPath Evaulation Completed (expression = %s, results = %s)", expression, getNodeList().getLength());
		return this;
	}

	public Element first() {
		Collection<Element> elements = elements();
		return (!elements.isEmpty()) ? elements.iterator().next() : null;
	}

	private Document getDom() {
		return dom;
	}

	public Element getElement() {
		return element;
	}

	private NodeList getNodeList() {
		return nodeList;
	}

	private void setDom(Document dom) {
		this.dom = dom;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	private void setNodeList(NodeList nodeList) {
		this.nodeList = nodeList;
	}

	public String text() {
		Collection<String> collection = texts();
		return (collection.isEmpty()) ? null : collection.iterator().next();
	}

	public Collection<String> texts() {
		Set<String> set = new TreeSet<String>();

		for (int i = 0; i < getNodeList().getLength(); i++)
			set.add(getNodeList().item(i).getTextContent());

		return set;
	}
}
