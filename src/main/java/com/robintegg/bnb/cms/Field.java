package com.robintegg.bnb.cms;

import java.util.stream.Collectors;

public class Field extends AbstractContentNode {

	private FieldType type;

	public Field(String name, FieldType type) {
		super(name);
		this.type = type;
	}

	public FieldType getType() {
		return type;
	}

	public String getFieldName() {
		return getPath().stream().collect(Collectors.joining("_"));
	}

}
