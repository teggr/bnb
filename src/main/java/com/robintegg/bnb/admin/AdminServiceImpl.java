
package com.robintegg.bnb.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robintegg.bnb.cms.Page;
import com.robintegg.bnb.cms.PageModel;
import com.robintegg.bnb.cms.PageRepository;
import com.robintegg.bnb.cms.PageTemplate;
import com.robintegg.bnb.cms.PageTemplateRepository;
import com.robintegg.bnb.locale.LocaleService;

@Service
public class AdminServiceImpl implements AdminService {

	private PageRepository pageRepository;
	private LocaleService localeService;
	private PageTemplateRepository pageTemplateRepository;

	@Autowired
	public AdminServiceImpl(PageRepository pageRepository, LocaleService localeService,
			PageTemplateRepository pageTemplateRepository) {
		this.pageRepository = pageRepository;
		this.localeService = localeService;
		this.pageTemplateRepository = pageTemplateRepository;
	}

	@Override
	public List<PageThumbnail> getPageThumbnails() {
		return pageRepository.findAll().stream()
				.map(p -> new PageThumbnail(new PageModel(p), localeService.getDefaultLocale()))
				.collect(Collectors.toList());
	}

	@Override
	public PageEditor getPageEditor(Long id) {

		Page page = pageRepository.findOne(id);

		String template = page.getTemplate();

		PageTemplate pageTemplate = pageTemplateRepository.findByName(template);

		listFields(pageTemplate);

		return new PageEditor( new PageModel(page), pageTemplate);

	}

	private void listFields(PageTemplate pageTemplate) {

		pageTemplate.getContentTemplate().getSections().stream().flatMap(s -> s.getArticles().stream())
				.flatMap(a -> a.getFields().stream()).forEach(f -> System.out.println(f.getFieldName()));

	}

}
