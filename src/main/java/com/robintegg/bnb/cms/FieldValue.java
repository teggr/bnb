package com.robintegg.bnb.cms;

import javax.persistence.Embeddable;

@Embeddable
public class FieldValue {

	private String name;
	private String value;
	private FieldType type;

	public FieldValue(String name, String value, FieldType type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	FieldValue() {}

	public String getName() {
		return name;
	}

	public FieldType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

}
