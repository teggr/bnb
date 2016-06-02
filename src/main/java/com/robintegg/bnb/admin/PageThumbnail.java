package com.robintegg.bnb.admin;

import java.util.Collection;
import java.util.Locale;
import java.util.stream.Collectors;

import com.robintegg.bnb.cms.PageModel;

public class PageThumbnail {

	private String name;
	private Long id;
	private String image;
	private Collection<Locale> locales;

	public PageThumbnail(PageModel p, Collection<Locale> locales) {
		this.locales = locales.stream()
				.sorted((l1, l2) -> l1.getDisplayLanguage().compareToIgnoreCase(l2.getDisplayLanguage()))
				.collect(Collectors.toList());
		this.id = p.getId();
		this.name = p.getTitle();
		this.image = p.getThumbnailImage();
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

	public Collection<Locale> getLocales() {
		return locales;
	}

}
