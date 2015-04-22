package com.tianyi.bph.common.mq;

public class BaseData {

	private Object data;
	private String type;
	private Integer operTypeCode;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOperTypeCode() {
		return operTypeCode;
	}

	public void setOperTypeCode(Integer operTypeCode) {
		this.operTypeCode = operTypeCode;
	}

}
