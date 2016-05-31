package com.robintegg.bnb.admin;

import java.util.List;
import java.util.Map;

public interface AdminService {

	List<PageThumbnail> getPageThumbnails();

	PageEditor getPageEditor(Long pageId);

	void updatePage(Long pageId, Map<String, String> fields);

}
