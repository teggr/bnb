package com.robintegg.bnb.admin;

import java.util.Locale;

import com.robintegg.bnb.cms.Page;

public class PageThumbnail {

	private String name;
	private Long id;

	public PageThumbnail(Page p, Locale locale) {
		id = p.getId();
		name = p.getName(locale);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
