package com.tianyi.bph.domain;

import java.util.List;

public class FunctionModule {
	private List<String> baseArray;//基础数据功能集合
	private List<String> conductArray;//指挥调度功能集合
	public List<String> getBaseArray() {
		return baseArray;
	}
	public void setBaseArray(List<String> baseArray) {
		this.baseArray = baseArray;
	}
	public List<String> getConductArray() {
		return conductArray;
	}
	public void setConductArray(List<String> conductArray) {
		this.conductArray = conductArray;
	}
	public List<String> getPoliceArray() {
		return policeArray;
	}
	public void setPoliceArray(List<String> policeArray) {
		this.policeArray = policeArray;
	}
	private List<String> policeArray;//警情处理功能集合
	
}
