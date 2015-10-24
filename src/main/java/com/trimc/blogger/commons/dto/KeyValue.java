package com.trimc.blogger.commons.dto;

public class KeyValue<X, Y> {

	private X key;
	
	private Y value;
	
	public KeyValue(X x, Y y) {
		setKey(x);
		setValue(y);
	}
	
	public boolean hasKey() {
		return null != key();
	}
	
	public boolean hasValue() {
		return null != value();
	}

	public X key() {
		return key;
	}

	private void setKey(X key) {
		this.key = key;
	}

	private void setValue(Y value) {
		this.value = value;
	}

	public Y value() {
		return value;
	}
}
