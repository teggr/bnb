package com.robintegg.bnb.cms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PageRepository extends JpaRepository<Page, Long> {

	 Page findByTitleSlug(String path);

	 Page findByHome(boolean home);

}
