package com.tianyi.bph.query.system;

import com.tianyi.bph.query.BaseQuery;

public class BayonetQuery extends BaseQuery {
	private String name;
	private String code;
	private Integer organId;
	public Integer getOrganId() {
		return organId;
	}
	public void setOrganId(Integer organId) {
		this.organId = organId;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String id;
}
