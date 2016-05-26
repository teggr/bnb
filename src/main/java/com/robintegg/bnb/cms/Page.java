package com.robintegg.bnb.cms;

import java.util.Locale;

import com.robintegg.bnb.db.BaseEntity;

public class Page extends BaseEntity {

	private String name;
	private String template;
	private boolean home;

	public Page(Long id, String name, String template, boolean home) {
		setId(id);
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
