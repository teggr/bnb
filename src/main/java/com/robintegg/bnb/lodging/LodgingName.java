package com.robintegg.bnb.lodging;

import org.apache.commons.lang3.StringUtils;

public class LodgingName {

	public static LodgingName newInstance(String name) {
		assert StringUtils.isNotEmpty(name);
		LodgingName lodgingName = new LodgingName();
		lodgingName.name = name;
		return lodgingName;
	}

	private String name;
	
	LodgingName() {}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "LodgingName [name=" + name + "]";
	}

}
