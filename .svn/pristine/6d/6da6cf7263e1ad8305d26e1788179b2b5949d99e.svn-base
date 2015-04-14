package com.tianyi.bph.service.impl.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianyi.bph.dao.system.BaseStationDao;
import com.tianyi.bph.domain.system.BaseStation;
import com.tianyi.bph.query.system.BaseStationQuery;
import com.tianyi.bph.service.system.BaseStationService;

public class BaseStationServiceImpl implements BaseStationService{
	
	private static final Logger log=LoggerFactory.getLogger(BaseStationServiceImpl.class);
	
	@Autowired BaseStationDao baseStationDao;
	
	public int deleteByPrimaryKey(Integer id){
		return baseStationDao.deleteByPrimaryKey(id);
	};
	
	public int insert(BaseStation record){
		return baseStationDao.insert(record);
	};
	
	public int insertSelective(BaseStation record){
		return baseStationDao.insertSelective(record);
	};
	
	public BaseStation selectByPrimaryKey(Integer id){
		return baseStationDao.selectByPrimaryKey(id);
	};
	    
	public int updateByPrimaryKeySelective(BaseStationQuery record){
		return baseStationDao.updateByPrimaryKeySelective(record);
	};

    //更改基站信息
	public int updateByPrimaryKey(BaseStation record){
		return baseStationDao.updateByPrimaryKey(record);
	};
    // 验证基站重复性
	public int getUniqueCountByQuery(BaseStationQuery query){
		return baseStationDao.getUniqueCountByQuery(query);
	};
    
    public int findCount(BaseStationQuery query){
    	return baseStationDao.findCount(query);
    };
    
    public List<BaseStation> findByPage(BaseStationQuery query){
    	return baseStationDao.findByPage(query);
    };
}
