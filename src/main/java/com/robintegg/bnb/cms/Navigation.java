package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Navigation {

	public static Navigation newInstance(PageRepository pages, Locale defaultLocale, Locale locale) {
		ArrayList<NavigationItem> items = new ArrayList<>();
		List<Page> allPages = pages.findAll();
		for (Page page : allPages) {
			if (!page.isHome()) {
				String pageName = page.getName(locale);
				NavigationItem item = new NavigationItem(resolvePath(pageName, defaultLocale, locale), pageName, false);
				items.add(item);
			}
		}
		return new Navigation(items);
	}

	private static String resolvePath(String name, Locale defaultLocale, Locale locale) {
		String path = "/" + name;
		if (!defaultLocale.equals(locale)) {
			path = "/" + locale.getLanguage() + path;
		}
		return path;
	}

	private List<NavigationItem> items;

	Navigation(List<NavigationItem> items) {
		this.items = items;
	}

	public List<NavigationItem> getItems() {
		return items;
	}

}
