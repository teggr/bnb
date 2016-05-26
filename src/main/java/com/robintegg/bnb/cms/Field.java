package com.robintegg.bnb.cms;

public class Field {

	public enum Type {
		IMAGE, TITLE, TEXT, SUBTITLE;
	}

	private Type type;
	private String name;

	public Field(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}
