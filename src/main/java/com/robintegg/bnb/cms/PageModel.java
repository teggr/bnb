package com.robintegg.bnb.cms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

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
		return props.get(key);
	}
	
	public String imageOf(String key) {
		String image = props.get(key);
		if(image != null) {
			if(StringUtils.isNotBlank(image)) {
				return image;
			}
		}
		return null;
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

		// list get first properties with an image
		for (Entry<String, String> entry : props.entrySet()) {
			if (entry.getKey().contains("big_image") && StringUtils.isNotBlank(entry.getValue())) {
				return entry.getValue();
			}
		}
		return null;
	}

	public boolean containsKey(String key) {
		return props.containsKey(key);
	}

}
