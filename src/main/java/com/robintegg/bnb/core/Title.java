package com.robintegg.bnb.core;

public class Title {

	private String text;
	private String slug;

	public Title(String text) {
		this.text = text;
		this.slug = "/" + text.toLowerCase().replaceAll(" ", "-");
	}

	public String getSlug() {
		return slug;
	}

	public String getText() {
		return text;
	}

}
