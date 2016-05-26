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
				String pageName = page.getTitle().getText();
				NavigationItem item = new NavigationItem(resolveSlug(page.getTitle().getSlug(), defaultLocale, locale),
						pageName, false);
				items.add(item);
			}
		}
		return new Navigation(items);
	}

	private static String resolveSlug(String slug, Locale defaultLocale, Locale locale) {
		if (!defaultLocale.equals(locale)) {
			slug = "/" + locale.getLanguage() + slug;
		}
		return slug;
	}

	private List<NavigationItem> items;

	Navigation(List<NavigationItem> items) {
		this.items = items;
	}

	public List<NavigationItem> getItems() {
		return items;
	}

}
