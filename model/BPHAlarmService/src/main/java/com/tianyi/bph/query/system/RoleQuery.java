package com.tianyi.bph.query.system;

import com.tianyi.bph.query.BaseQuery;

public class RoleQuery extends BaseQuery{

	private String name;
	
	private String note;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
