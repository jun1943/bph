package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.BaseStation;
import com.tianyi.bph.query.system.BaseStationQuery;

@MyBatisRepository
public interface BaseStationDao {
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(BaseStation record);
	
	int insertSelective(BaseStation record);
	
	BaseStation selectByPrimaryKey(Integer id);
	    
    int updateByPrimaryKeySelective(BaseStationQuery record);

    //更改基站信息
    int updateByPrimaryKey(BaseStation record);
    // 验证基站重复性
    int getUniqueCountByQuery(BaseStationQuery query);
    
    int findCount(BaseStationQuery query);
    
    List<BaseStation> findByPage(BaseStationQuery query);
}
