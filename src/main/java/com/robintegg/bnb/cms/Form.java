package com.robintegg.bnb.cms;

import org.springframework.ui.ModelMap;

import com.robintegg.bnb.contact.ContactForm;

public class Form {

	public enum Type {
		Contact("contact", ContactForm.class);

		private Class clazz;
		private String formName;

		private Type(String formName, Class clazz) {
			this.formName = formName;
			this.clazz = clazz;
		}

		public void loadForm(ModelMap model) {
			model.addAttribute(formName, new ContactForm() );
		}
	}

}
