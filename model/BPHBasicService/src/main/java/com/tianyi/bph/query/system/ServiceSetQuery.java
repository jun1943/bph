package com.tianyi.bph.query.system;

import com.tianyi.bph.query.BaseQuery;

public class ServiceSetQuery extends BaseQuery{

	private String serviceName;
	
	private Integer serviceType;

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
