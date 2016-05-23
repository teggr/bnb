package com.robintegg.bnb.cms;

public class NavigationItem {

	private boolean active;
	private String path;
	private String text;

	public NavigationItem(String path, String text, boolean active) {
		super();
		this.path = path;
		this.text = text;
		this.active = active;
	}

	public String getPath() {
		return path;
	}

	public String getText() {
		return text;
	}

	public boolean isActive() {
		return active;
	}

}
