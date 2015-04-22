package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.OrganTypeDAO;
import com.tianyi.bph.domain.system.OrganType;
import com.tianyi.bph.service.system.OrganTypeService;


@Service
public class OrganTypeServiceImpl implements OrganTypeService{

	@Autowired OrganTypeDAO organTypeDao;
	
	//增
	public void addOrganType(OrganType organType){
		
		organTypeDao.insert(organType);

	}
	//删
	public void deleteOrganType(String code){
		organTypeDao.deleteByPrimaryKey(code);
	}
	//改
	public void updateOrganType(OrganType organType){
		organTypeDao.updateByPrimaryKeySelective(organType);
	}
	
	//查
	public OrganType getOrganTypeById(String code){
		return organTypeDao.selectByPrimaryKey(code);
	}
	
	//条件查询
	public List<OrganType> getQueryList(){
		List<OrganType> organTypes = organTypeDao.findByQuery();
		return organTypes;
	}

}
