package com.robintegg.bnb.admin;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

public interface AdminService {

	// page admin

	Collection<PageThumbnail> getPageThumbnails();

	PageEditor getPageEditor(Long pageId);

	void updatePage(Long pageId, Map<String, String> fields);

	// locale admin

	Collection<LocaleOption> getLocaleOptions();

	void setDefaultLocale(Locale locale);

}
