package com.robintegg.bnb.cms;

import javax.persistence.Embeddable;

@Embeddable
public class FieldValue {

	private String name;
	private String value;

	public FieldValue(String name, String value) {
		this.name = name;
		this.value = value;
	}

	FieldValue() {
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

}
