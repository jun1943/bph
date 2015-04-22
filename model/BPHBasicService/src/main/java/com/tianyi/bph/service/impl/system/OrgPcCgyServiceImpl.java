package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.system.OrgPcCgyDAO;
import com.tianyi.bph.domain.system.OrgPcCgy;
import com.tianyi.bph.service.system.OrgPcCgyService;


@Service
public class OrgPcCgyServiceImpl implements OrgPcCgyService{

	@Autowired OrgPcCgyDAO orgPcCgyDao;
	
	
	
	//查询
	public OrgPcCgy getOrgPcCgyById(String id){
		OrgPcCgy orgPcCgy= orgPcCgyDao.selectByPrimaryKey(id);
		return orgPcCgy;
	}
		
	//条件查询
	public List<OrgPcCgy> getQueryList(){
		List<OrgPcCgy> orgPcCgys = orgPcCgyDao.findByQuery();
		return orgPcCgys;
	}

}
