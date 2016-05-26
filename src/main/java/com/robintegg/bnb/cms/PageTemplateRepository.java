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
			.section(new Section.Builder("header")
				.article(new Article.Builder("image")
					.field(new Field("big_image", Field.Type.IMAGE)).build()
				)
			.build() );

		builder
			.section(new Section.Builder("description")
				.article(new Article.Builder("room")
					.field(new Field( "room_title", Field.Type.TITLE))
					.field(new Field( "room_subtitle", Field.Type.SUBTITLE))
					.field(new Field("room_description", Field.Type.TEXT))
					.field(new Field( "room_image_1", Field.Type.IMAGE))
					.field(new Field("room_image_2",Field.Type.IMAGE))
					.field(new Field("room_image_3",Field.Type.IMAGE))
					.field(new Field("room_image_4",Field.Type.IMAGE))
					.field(new Field("room_image_5",Field.Type.IMAGE))
					.field(new Field("room_image_6",Field.Type.IMAGE)).build()
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
				.article(new Article.Builder("image")
					.field(new Field( "big_image", Field.Type.IMAGE)).build()
				)
			.build() );

		builder
			.section(new Section.Builder("descriptions")
				.article(new Article.Builder("left")
					.field(new Field("left_title",Field.Type.TITLE))
					.field(new Field("left_text",Field.Type.TEXT)).build()
				)
				.article(new Article.Builder("center")
					.field(new Field("center_title",Field.Type.TITLE))
					.field(new Field("center_text",Field.Type.TEXT)).build()
				)
				.article(new Article.Builder("right")
					.field(new Field("right_title",Field.Type.TITLE))
					.field(new Field("right_text",Field.Type.TEXT)).build()
				)
			.build() );

		builder
			.section(new Section.Builder("descriptions with images")
				.article( new Article.Builder("top")
					.field(new Field("top_title",Field.Type.TITLE))
					.field(new Field("top_subtitle",Field.Type.SUBTITLE))
					.field(new Field("top_image",Field.Type.IMAGE))
					.field(new Field("top_text",Field.Type.TEXT)).build()
				)
				.article( new Article.Builder("middle")
					.field(new Field("middle_title",Field.Type.TITLE))
					.field(new Field("middle_subtitle",Field.Type.SUBTITLE))
					.field(new Field("middle_image",Field.Type.IMAGE))
					.field(new Field("middle_text",Field.Type.TEXT)).build()
				)
				.article( new Article.Builder("bottom")
					.field(new Field("bottom_title",Field.Type.TITLE))
					.field(new Field("bottom_subtitle",Field.Type.SUBTITLE))
					.field(new Field("bottom_image",Field.Type.IMAGE))
					.field(new Field("bottom_text",Field.Type.TEXT)).build()
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
