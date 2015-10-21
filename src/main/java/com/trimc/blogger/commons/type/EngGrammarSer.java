package com.trimc.blogger.commons.type;

import com.google.gson.annotations.Expose;

public class EngGrammarSer {

	@Expose
	private String longName;

	@Expose
	private String metaType;

	@Expose
	private String[] tags;

	@Expose
	private String upperType;

	public String getLongName() {
		return longName;
	}

	public String getMetaType() {
		return metaType;
	}

	public String[] getTags() {
		return tags;
	}

	public String getUpperType() {
		return upperType;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public void setMetaType(String metaType) {
		this.metaType = metaType;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public void setUpperType(String upperType) {
		this.upperType = upperType;
	}
}
