package com.tianyi.bph.common.mq;

import com.tianyi.bph.common.Constants;

public class BaseData {

	private Object data;// 发送数据信息体
	private String type;// 数据类型
	private Integer operTypeCode;// 操作代码
	private String organPath;// 机构path

	public BaseData(Object data, String type, Integer operTypeCode,
			String organPath) {
		super();
		this.data = data;
		this.type = type;
		this.operTypeCode = operTypeCode;
		this.organPath = organPath;
	}

	public BaseData() {
		super();
	}

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

	public String getOrganPath() {
		return organPath;
	}

	public void setOrganPath(String organPath) {
		this.organPath = organPath;
	}

	public String routeKey() {
		StringBuilder builder = new StringBuilder(Constants.MQ_ROUTING_KEY);
		builder.append(".").append(type).append(".").append(organPath);
		return builder.toString();
	}

}
