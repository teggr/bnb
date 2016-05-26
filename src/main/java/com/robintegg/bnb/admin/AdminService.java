package com.robintegg.bnb.admin;

import java.util.List;

public interface AdminService {

	List<PageThumbnail> getPageThumbnails();

	PageEditor getPageEditor(Long id);

}
