package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PageRepository {

	private Map<String, Page> pagesByName = new HashMap<>();
	private Map<Long, Page> pagesById = new HashMap<>();

	public PageRepository() {
		addPage(1, "home", true);
		addPage(2, "harz", false);
		addPage(3, "suites", false);
		addPage(4, "reservations", false);
		addPage(5, "contact", false);
	}

	private void addPage(int id, String pageName, boolean home) {
		Long entityId = Long.valueOf(id);
		Page value = new Page(entityId, pageName, pageName, home);
		pagesByName.put(pageName, value);
		pagesById.put(entityId, value);
	}

	public Page findOne(Long id) {
		return pagesById.get(id);
	}

	public List<Page> findAll() {
		return new ArrayList<>(pagesByName.values());
	}

	public Page findByName(String name) {
		if (name == null) {
			return pagesByName.get("home");
		}
		return pagesByName.get(name);
	}

}
