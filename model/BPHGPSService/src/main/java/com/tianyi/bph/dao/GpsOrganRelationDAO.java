package com.tianyi.bph.dao;

import java.util.List;

import com.tianyi.bph.bean.GpsOrganBean;
import com.tianyi.bph.dao.MyBatisRepository;

/**
 * 
 * @author Administrator
 *
 */
@MyBatisRepository
public interface GpsOrganRelationDAO {
	
	public List<GpsOrganBean> findGpsMessageList();
	
}
