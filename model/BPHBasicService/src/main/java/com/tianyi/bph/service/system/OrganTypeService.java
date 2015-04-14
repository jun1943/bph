package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.domain.system.OrganType;

public interface OrganTypeService {
	
	//增
	public void addOrganType(OrganType organType);
	//删
	public void deleteOrganType(String code);
	//改
	public void updateOrganType(OrganType organType);
	
	//查
	public OrganType getOrganTypeById(String code);
	
	//条件查询
	public List<OrganType> getQueryList();

}
