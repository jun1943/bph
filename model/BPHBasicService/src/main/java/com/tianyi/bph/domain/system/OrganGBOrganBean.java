package com.tianyi.bph.domain.system;

import java.util.List;

public class OrganGBOrganBean {
	private Integer organId;
	private List<Integer> gbOrganIds;

	public Integer getOrganId() {
		return organId;
	}

	public void setOrganId(Integer organId) {
		this.organId = organId;
	}

	public List<Integer> getGbOrganIds() {
		return gbOrganIds;
	}

	public void setGbOrganIds(List<Integer> gbOrganIds) {
		this.gbOrganIds = gbOrganIds;
	}

}
