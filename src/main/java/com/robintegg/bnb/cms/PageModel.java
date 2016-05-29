package com.robintegg.bnb.cms;

import java.util.HashMap;
import java.util.Map;

public class PageModel {
	
	

	private Map<String, String> props = new HashMap<>();

	public String getValue(String key) {
		return props.getOrDefault(key, "");
	}

}
