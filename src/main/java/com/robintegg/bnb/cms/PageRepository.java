package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PageRepository {

	private Map<Long, Page> pagesById = new HashMap<>();

	public void save(Page page) {
		pagesById.put(page.getId(), page);
	}

	public Page findOne(Long id) {
		return pagesById.get(id);
	}

	public List<Page> findAll() {
		return new ArrayList<>(pagesById.values());
	}

	public Page findByTitleSlug(final String path) {
		return findAll().stream().filter(p -> p.getTitle().getSlug().contains(path)).findFirst().get();
	}

	public Page findByHome(boolean home) {
		return findAll().stream().filter(p -> p.isHome()).findFirst().get();
	}

}
