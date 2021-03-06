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
		
		// @formatter:off
		
		contactBuilder
			.section(new Section.Builder("header")
				.article(new Article.Builder("big_image")
					.field(new Field( "image", FieldType.IMAGE)).build()
				)
			.build() );
		
		contactBuilder
			.section(new Section.Builder("contact")
				.article(new Article.Builder("form")
					.field(new Field( "title", FieldType.TITLE))
					.field(new Field( "subtitle", FieldType.SUBTITLE))
					.form(Form.Type.Contact)
					.build()
				)
			.build() );
		
		contactBuilder
			.section(new Section.Builder("travel")
				.article(new Article.Builder("directions")
					.field(new Field( "title", FieldType.TITLE))
					.field(new Field( "subtitle", FieldType.SUBTITLE))
					.field(new Field("description", FieldType.TEXT))
					.field(new Field( "image_1", FieldType.IMAGE)).build()
				)
			.build() );
		
		// @formatter:on

		save(new PageTemplate("contact", contactBuilder.build()));
	}

	private void createBookingTemplate() {
		ContentTemplate.Builder bookingBuilder = new ContentTemplate.Builder();
		
		// @formatter:off
		
		bookingBuilder
			.section(new Section.Builder("header")
				.article(new Article.Builder("big_image")
					.field(new Field( "image", FieldType.IMAGE)).build()
				)
			.build() );
		
		bookingBuilder
			.section(new Section.Builder("prices")
				.article(new Article.Builder("highlights")
					.field(new Field( "title", FieldType.TITLE))
					.field(new Field( "subtitle", FieldType.SUBTITLE))
					.field(new Field("description", FieldType.TEXT))
					.field(new Field( "image_1", FieldType.IMAGE)).build()
				)
			.build() );
		
		bookingBuilder
			.section(new Section.Builder("contact")
				.article(new Article.Builder("form")
					.field(new Field( "title", FieldType.TITLE))
					.field(new Field( "subtitle", FieldType.SUBTITLE))
					.field(new Field("description", FieldType.TEXT))
					.form(Form.Type.Contact)
					.build()
				)
			.build() );
		
		// @formatter:on
		
		save(new PageTemplate("booking", bookingBuilder.build()));
	}

	private void createRoomsTemplate() {
		ContentTemplate.Builder builder = new ContentTemplate.Builder();

		// @formatter:off

		builder
			.section(new Section.Builder("header")
				.article(new Article.Builder("big_image")
					.field(new Field("image", FieldType.IMAGE)).build()
				)
			.build() );

		builder
			.section(new Section.Builder("description")
				.article(new Article.Builder("room")
					.field(new Field( "title", FieldType.TITLE))
					.field(new Field( "subtitle", FieldType.SUBTITLE))
					.field(new Field("description", FieldType.TEXT))
					.field(new Field( "image_1", FieldType.IMAGE))
					.field(new Field("image_2",FieldType.IMAGE))
					.field(new Field("image_3",FieldType.IMAGE))
					.field(new Field("image_4",FieldType.IMAGE))
					.field(new Field("image_5",FieldType.IMAGE))
					.field(new Field("image_6",FieldType.IMAGE)).build()
				)
			.build() );
		
		// @formatter:on

		save(new PageTemplate("rooms", builder.build()));
	}

	private void createGeneralTemplate() {
		ContentTemplate.Builder builder = new ContentTemplate.Builder();

		// @formatter:off

		builder
			.section(new Section.Builder("header")
				.article(new Article.Builder("big_image")
					.field(new Field( "image", FieldType.IMAGE)).build()
				)
			.build() );

		builder
			.section(new Section.Builder("descriptions")
				.article(new Article.Builder("left")
					.field(new Field("title",FieldType.TITLE))
					.field(new Field("text",FieldType.TEXT)).build()
				)
				.article(new Article.Builder("center")
					.field(new Field("title",FieldType.TITLE))
					.field(new Field("text",FieldType.TEXT)).build()
				)
				.article(new Article.Builder("right")
					.field(new Field("title",FieldType.TITLE))
					.field(new Field("text",FieldType.TEXT)).build()
				)
			.build() );

		builder
			.section(new Section.Builder("descriptions_with_images")
				.article( new Article.Builder("top")
					.field(new Field("title",FieldType.TITLE))
					.field(new Field("subtitle",FieldType.SUBTITLE))
					.field(new Field("image",FieldType.IMAGE))
					.field(new Field("text",FieldType.TEXT)).build()
				)
				.article( new Article.Builder("middle")
					.field(new Field("title",FieldType.TITLE))
					.field(new Field("subtitle",FieldType.SUBTITLE))
					.field(new Field("image",FieldType.IMAGE))
					.field(new Field("text",FieldType.TEXT)).build()
				)
				.article( new Article.Builder("bottom")
					.field(new Field("title",FieldType.TITLE))
					.field(new Field("subtitle",FieldType.SUBTITLE))
					.field(new Field("image",FieldType.IMAGE))
					.field(new Field("text",FieldType.TEXT)).build()
				)
			.build() );
		
		// @formatter:on

		save(new PageTemplate("general", builder.build()));
	}

	private void save(PageTemplate pageTemplate) {
		templates.put(pageTemplate.getTemplate(), pageTemplate);
	}

	public PageTemplate findByName(String template) {
		return templates.get(template);
	}

}
