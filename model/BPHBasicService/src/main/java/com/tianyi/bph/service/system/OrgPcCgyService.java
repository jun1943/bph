package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.domain.system.OrgPcCgy;

public interface OrgPcCgyService {

	//查询
	public OrgPcCgy getOrgPcCgyById(String id);
		
	//条件查询
	public List<OrgPcCgy> getQueryList();

}
