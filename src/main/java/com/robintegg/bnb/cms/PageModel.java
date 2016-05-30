package com.robintegg.bnb.cms;

import java.util.HashMap;
import java.util.Map;

public class PageModel {

	private Map<String, String> props = new HashMap<>();

	private String title;

	private Long id;

	private String slug;

	public PageModel(Page p) {
		id = p.getId();
		title = p.getTitle().getText();
		slug = p.getTitle().getSlug();
		p.getFieldValues().stream().forEach(f -> props.put(f.getName(), f.getValue()));
	}

	public String valueOf(String key) {
		return props.getOrDefault(key, "");
	}
	
	public String getSlug() {
		return slug;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getThumbnailImage() {
		return props.keySet().stream().filter(k -> k.contains("image")).findFirst().orElse(null);
	}

}
