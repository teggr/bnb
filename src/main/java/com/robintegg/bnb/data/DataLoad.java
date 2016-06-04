package com.robintegg.bnb.data;

import javax.persistence.Entity;

import com.robintegg.bnb.db.BaseEntity;

@Entity
public class DataLoad extends BaseEntity {

	public enum Type {
		PRE_POPULATION;
	}

	private Type type;

	DataLoad() {
	}

	public DataLoad(Type type) {
		this.type = type;
	}

}
