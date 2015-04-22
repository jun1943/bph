package com.tianyi.bph.query.basicdata;

import java.util.List;

import com.tianyi.bph.domain.basicdata.Police;

public class PoliceDutyInfo {

	private Police data;
	
	private List<PoliceDutyList> dutyList;

	public Police getData() {
		return data;
	}

	public void setData(Police data) {
		this.data = data;
	}

	public List<PoliceDutyList> getDutyList() {
		return dutyList;
	}

	public void setDutyList(List<PoliceDutyList> dutyList) {
		this.dutyList = dutyList;
	}
	
}
