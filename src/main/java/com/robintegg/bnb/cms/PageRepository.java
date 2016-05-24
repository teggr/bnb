package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PageRepository {

	private Map<String, Page> pages = new HashMap<>();

	public PageRepository() {
		addPage("home",true);
		addPage("harz",false);
		addPage("suites",false);
		addPage("reservations",false);
		addPage("contact",false);
	}

	private void addPage(String pageName, boolean home) {
		pages.put(pageName, new Page(pageName, pageName, home));
	}

	public List<Page> findAll() {
		return new ArrayList<>(pages.values());
	}

	public Page findByName(String name) {
		if (name == null) {
			return pages.get("home");
		}
		return pages.get(name);
	}

}
