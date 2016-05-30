package com.robintegg.bnb.cms;

import java.util.Collection;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.robintegg.bnb.core.Title;
import com.robintegg.bnb.db.BaseEntity;

@Entity
public class Page extends BaseEntity {

	public static class Builder {

		private static long idGen = 1;
		private Long id;
		private String template;
		private boolean home = false;
		private Title title;

		public Builder(String template, Title title) {
			this.title = title;
			this.id = idGen++;
			this.template = template;
		}

		public Builder makeHome() {
			this.home = true;
			return this;
		}

		public Page build() {
			return new Page(this);
		}

	}

	private String template;
	private boolean home;
	
	@Embedded
	private Title title;
	
	@ElementCollection
	@CollectionTable(
	    name="FIELD_VALUE",
	    joinColumns=@JoinColumn(name="PAGE_ID")
	 )
	private List<FieldValue> fieldValues;

	public Page(Builder builder) {
		this.title = builder.title;
		this.template = builder.template;
		this.home = builder.home;
		setId(builder.id);
	}
	
	Page() {}

	public boolean isHome() {
		return home;
	}

	public String getTemplate() {
		return template;
	}

	public Title getTitle() {
		return title;
	}
	
	public Collection<FieldValue> getFieldValues() {
		return fieldValues;
	}

}
