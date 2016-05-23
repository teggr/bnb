package com.robintegg.bnb.cms;

import java.util.Locale;

public class Page {

	private String name;
	private String template;
	private boolean home;

	public Page(String name, String template, boolean home) {
		this.name = name;
		this.template = template;
		this.home = home;
	}

	public boolean isHome() {
		return home;
	}

	public String getName(Locale locale) {
		return name;
	}

	public boolean matches(Page page) {
		return name.equals(page.name);
	}

	public String getTemplate() {
		return template;
	}

}
