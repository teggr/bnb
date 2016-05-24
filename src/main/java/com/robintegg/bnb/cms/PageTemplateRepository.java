package com.robintegg.bnb.cms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PageTemplateRepository {

	private Map<String, PageTemplate> templates = new HashMap<>();

	public PageTemplateRepository() {
		createGeneralTemplate();
		createRoomsTemplate();
		createBookingTemplate();
		createContactTemplate();
	}

	private void createContactTemplate() {
		ContentTemplate.Builder contactBuilder = new ContentTemplate.Builder();

		save(new PageTemplate("contact", contactBuilder.build()));
	}

	private void createBookingTemplate() {
		ContentTemplate.Builder bookingBuilder = new ContentTemplate.Builder();
		save(new PageTemplate("booking", bookingBuilder.build()));
	}

	private void createRoomsTemplate() {
		ContentTemplate.Builder builder = new ContentTemplate.Builder();
		
		// @formatter:off

		builder
			.section(new Section.Builder()
				.article(new Article.Builder()
					.field(new Field(Field.Types.IMAGE)).build()
				)
			.build() );

		builder
			.section(new Section.Builder()
				.article(new Article.Builder()
					.field(new Field(Field.Types.TITLE))
					.field(new Field(Field.Types.SUBTITLE))
					.field(new Field(Field.Types.TEXT))
					.field(new Field(Field.Types.IMAGE))
					.field(new Field(Field.Types.IMAGE))
					.field(new Field(Field.Types.IMAGE))
					.field(new Field(Field.Types.IMAGE))
					.field(new Field(Field.Types.IMAGE))
					.field(new Field(Field.Types.IMAGE)).build()
				)
			.build() );
		
		// @formatter:on
		
		save(new PageTemplate("rooms", builder.build()));
	}

	private void createGeneralTemplate() {
		ContentTemplate.Builder builder = new ContentTemplate.Builder();

		// @formatter:off

		builder
			.section(new Section.Builder()
				.article(new Article.Builder()
					.field(new Field(Field.Types.IMAGE)).build()
				)
			.build() );

		builder
			.section(new Section.Builder()
				.article(new Article.Builder()
					.field(new Field(Field.Types.TITLE))
					.field(new Field(Field.Types.TEXT)).build()
				)
				.article(new Article.Builder()
					.field(new Field(Field.Types.TITLE))
					.field(new Field(Field.Types.TEXT)).build()
				)
				.article(new Article.Builder()
					.field(new Field(Field.Types.TITLE))
					.field(new Field(Field.Types.TEXT)).build()
				)
			.build() );

		builder
			.section(new Section.Builder()
				.article( new Article.Builder()
					.field(new Field(Field.Types.TITLE))
					.field(new Field(Field.Types.SUBTITLE))
					.field(new Field(Field.Types.IMAGE))
					.field(new Field(Field.Types.TEXT)).build()
				)
				.article( new Article.Builder()
					.field(new Field(Field.Types.TITLE))
					.field(new Field(Field.Types.SUBTITLE))
					.field(new Field(Field.Types.IMAGE))
					.field(new Field(Field.Types.TEXT)).build()
				)
				.article( new Article.Builder()
					.field(new Field(Field.Types.TITLE))
					.field(new Field(Field.Types.SUBTITLE))
					.field(new Field(Field.Types.IMAGE))
					.field(new Field(Field.Types.TEXT)).build()
				)
			.build() );
		
		// @formatter:on

		save(new PageTemplate("general", builder.build()));
	}

	private void save(PageTemplate pageTemplate) {
		templates.put(pageTemplate.getTemplate(), pageTemplate);
	}

}
