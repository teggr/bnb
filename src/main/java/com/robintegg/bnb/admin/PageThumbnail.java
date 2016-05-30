package com.robintegg.bnb.admin;

import java.util.Locale;

import com.robintegg.bnb.cms.Page;

public class PageThumbnail {

	private String name;
	private Long id;
	private String image;

	public PageThumbnail(Page p, Locale locale) {
		id = p.getId();
		name = p.getTitle().getText();
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
