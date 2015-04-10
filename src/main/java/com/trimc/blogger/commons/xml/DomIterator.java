package com.trimc.blogger.commons.xml;

import java.util.Iterator;
import java.util.Stack;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomIterator implements Iterator<Element> {

	int						_count		= 0;

	private Element			_current	= null;

	private Document		_dom		= null;

	private String[]		_names		= null;

	private Element			_next		= null;

	private Stack<Element>	_stack		= new Stack<Element>();

	public DomIterator(Document dom) {
		_dom = dom;
		if (dom != null) {
			_current = _dom.getDocumentElement();
			_next = DomUtils.getFirstChildElement(_current);
		}
	}

	public DomIterator(Document dom, String name) {
		_names = new String[] { name };
		_dom = dom;
		if (dom != null) {
			_current = _dom.getDocumentElement();
			_next = DomUtils.getFirstChildElement(_current);
			if (!DomUtils.testElement(_current, name)) {
				_current = getNextElementNamed(_current);
				_next = getNextElementNamed(_current);
			}
		}
	}

	public DomIterator(Document dom, String[] names) {
		_names = names;
		_dom = dom;
		if (dom != null) {
			_current = _dom.getDocumentElement();
			_next = DomUtils.getFirstChildElement(_current);
			if (!DomUtils.testElement(_current, names)) {
				_current = getNextElementNamed(_current);
				_next = getNextElementNamed(_current);

			}
		}
	}

	public DomIterator(Element elem) {
		_current = elem;
		_next = DomUtils.getFirstChildElement(_current);
	}

	private Element getNextElement(Element elem) {
		Element result = null;

		if (DomUtils.getFirstChildElement(elem) != null) {
			_stack.push(DomUtils.getNextElement(elem));
			result = DomUtils.getFirstChildElement(elem);
		} else if (DomUtils.getNextElement(elem) != null) {
			result = DomUtils.getNextElement(elem);
		} else if (!_stack.isEmpty()) {
			result = _stack.pop();
			while ((result == null) && !_stack.isEmpty()) {
				result = _stack.pop();
			}

		}

		return result;
	}

	private Element getNextElementNamed(Element elem) {
		Element next = getNextElement(elem);
		if (_names != null) {
			while (!DomUtils.testElement(next, _names) && (next != null)) {
				next = getNextElement(next);
			}
		} else {
			next = getNextElement(elem);
		}
		return next;
	}

	@Override public boolean hasNext() {
		return _current != null;
	}

	@Override public Element next() {
		Element result = _current;
		_current = _next;
		_next = getNextElementNamed(_current);
		_count++;
		return result;
	}

	@Override public void remove() {
		DomUtils.detachFromParent(_current);
	}
}
