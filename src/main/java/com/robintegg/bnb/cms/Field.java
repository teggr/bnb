package com.robintegg.bnb.cms;

public class Field {

	public enum Types {
		IMAGE, TITLE, TEXT, SUBTITLE;
	}

	private Types type;

	public Field(Types type) {
		this.type = type;
	}

	public Types getType() {
		return type;
	}

}
