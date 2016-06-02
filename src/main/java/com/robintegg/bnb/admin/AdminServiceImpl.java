
package com.robintegg.bnb.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robintegg.bnb.cms.FieldValue;
import com.robintegg.bnb.cms.Page;
import com.robintegg.bnb.cms.PageModel;
import com.robintegg.bnb.cms.PageRepository;
import com.robintegg.bnb.cms.PageTemplate;
import com.robintegg.bnb.cms.PageTemplateRepository;
import com.robintegg.bnb.locale.LocaleService;

@Transactional
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
	public Collection<PageThumbnail> getPageThumbnails() {
		return pageRepository.findAll().stream().map(
				p -> new PageThumbnail(new PageModel(p, localeService.getDefaultLocale()), localeService.getLocales()))
				.collect(Collectors.toList());
	}

	@Override
	public PageEditor getPageEditor(Long pageId, Locale locale) {
		Page page = pageRepository.findOne(pageId);
		String template = page.getTemplate();
		PageTemplate pageTemplate = pageTemplateRepository.findByName(template);
		listFields(pageTemplate);
		return new PageEditor(new PageModel(page, locale), pageTemplate);
	}

	private void listFields(PageTemplate pageTemplate) {
		pageTemplate.getContentTemplate().getSections().stream().flatMap(s -> s.getArticles().stream())
				.flatMap(a -> a.getFields().stream()).forEach(f -> System.out.println(f.getFieldName()));
	}

	@Override
	public void updatePage(Long pageId, Locale locale, Map<String, String> fields) {
		Page page = pageRepository.findOne(pageId);
		page.updateFieldValues(locale, createFieldValues(fields));
		pageRepository.save(page);
	}

	private List<FieldValue> createFieldValues(Map<String, String> fields) {
		List<FieldValue> list = new ArrayList<>();
		for (Entry<String, String> fieldEntry : fields.entrySet()) {
			list.add(new FieldValue(fieldEntry.getKey(), fieldEntry.getValue()));
		}
		return list;
	}

	@Override
	public Collection<LocaleOption> getLocaleOptions() {
		return localeService.getLocales().stream().map(l -> new LocaleOption(l, localeService.isDefaultLocale(l)))
				.collect(Collectors.toList());
	}

	@Override
	public void setDefaultLocale(Locale locale) {
		localeService.setDefaultLocale(locale);
	}

}
