package com.robintegg.bnb.cms;

import java.util.stream.Collectors;

public class Field extends AbstractContentNode {

	public enum Type {
		IMAGE, TITLE, TEXT, SUBTITLE;
	}

	private Type type;

	public Field(String name, Type type) {
		super(name);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public String getFieldName() {
		return getPath().stream().collect(Collectors.joining("_"));
	}

}
