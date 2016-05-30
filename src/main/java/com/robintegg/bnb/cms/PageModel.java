package com.robintegg.bnb.cms;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PageModel {

	private Map<String, String> props = new HashMap<>();

	public String getValue(String key) {
		return props.getOrDefault(key, "");
	}

	public Optional<String> getImage() {
		return props.keySet().stream().filter(k -> k.contains("image")).findFirst();
	}

}
