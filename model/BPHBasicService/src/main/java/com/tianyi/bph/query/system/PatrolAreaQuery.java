package com.tianyi.bph.query.system;

import com.tianyi.bph.query.BaseQuery;

public class PatrolAreaQuery extends BaseQuery{

	private String name;
	private String code;
	private Integer id;
	private String params;

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
