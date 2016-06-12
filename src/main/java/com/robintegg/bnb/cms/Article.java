package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.ui.ModelMap;

import com.robintegg.bnb.cms.ContentTemplate.Builder;
import com.robintegg.bnb.cms.Form.Type;

public class Article extends AbstractContentNode {

	public static class Builder {

		private List<Field> fields = new ArrayList<>();
		private String articleName;
		private List<Type> forms = new ArrayList<>();

		public Builder(String articleName) {
			this.articleName = articleName;
		}

		public Builder field(Field field) {
			fields.add(field);
			return this;
		}

		public Article build() {
			return new Article(this);
		}

		public Builder form(Type contact) {
			forms.add(contact);
			return this;
		}

	}

	private List<Field> fields = new ArrayList<>();
	private List<Type> forms = new ArrayList<>();

	private Article(Builder builder) {
		super(builder.articleName);
		for (Field field : builder.fields) {
			addField(field);
		}
		for( Type form : builder.forms ) {
			addForm(form);
		}
	}

	private void addForm(Type form) {
		forms .add(form);
	}

	public void addField(Field field) {
		fields.add(field);
		field.setParent(this);
	}

	public Collection<Field> getFields() {
		return fields;
	}

	public void loadForm(ModelMap model) {
		forms.stream().forEach( f -> f.loadForm(model) );
	}

}
