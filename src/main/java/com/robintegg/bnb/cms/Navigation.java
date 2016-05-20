package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

	private Page activePage;
	private PageRepository pages;

	public Navigation(PageRepository pages, Page activePage) {
		this.pages = pages;
		this.activePage = activePage;
	}

	public List<NavigationItem> getItems() {
		ArrayList<NavigationItem> list = new ArrayList<>();
		List<Page> allPages = pages.findAll();
		for (Page page : allPages) {
			if (!page.isHome()) {
				NavigationItem item = new NavigationItem(page, false);
				list.add(item);
			}
		}

		return list;
	}

}
