package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.List;

public class AbstractContentNode implements ContentNode {

	private ContentNode parent;
	private String name;

	public AbstractContentNode(String name) {
		this.name = name;
	}

	public void setParent(ContentNode parent) {
		this.parent = parent;
	}

	@Override
	public List<String> getPath() {
		List<String> list;
		if (parent != null) {
			list = new ArrayList<>(parent.getPath());
		} else {
			list = new ArrayList<>();
		}
		list.add(getName());
		return list;
	}

	public final String getName() {
		return name;
	}

}
