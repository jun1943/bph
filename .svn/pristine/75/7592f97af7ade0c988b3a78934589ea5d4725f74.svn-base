package com.tianyi.bph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.bean.GpsOrganBean;
import com.tianyi.bph.dao.GpsOrganRelationDAO;
import com.tianyi.bph.service.GpsOrganRelationService;

@Service
public class GpsOrganRelationService {

	@Autowired GpsOrganRelationDAO dao;
	
	public List<GpsOrganBean> findGpsMessageList() {
		
		List<GpsOrganBean> list = dao.findGpsMessageList();
		
		return list;
	}

	
}
