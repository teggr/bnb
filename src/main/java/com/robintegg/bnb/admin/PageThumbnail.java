package com.robintegg.bnb.admin;

import java.util.Locale;

import com.robintegg.bnb.cms.PageModel;

public class PageThumbnail {

	private String name;
	private Long id;
	private String image;

	public PageThumbnail(PageModel p, Locale locale) {
		id = p.getId();
		name = p.getTitle();
		image = p.getThumbnailImage();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

}
