package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.domain.system.BaseStation;
import com.tianyi.bph.query.system.BaseStationQuery;

public interface BaseStationService {
	
	
	public int deleteByPrimaryKey(Integer id);
	
	public int insert(BaseStation record);
	
	public int insertSelective(BaseStation record);
	
	public BaseStation selectByPrimaryKey(Integer id);
	    
	public int updateByPrimaryKeySelective(BaseStationQuery record);

    //更改基站信息
	public int updateByPrimaryKey(BaseStation record);
    // 验证基站重复性
	public int getUniqueCountByQuery(BaseStationQuery query);
    
    public int findCount(BaseStationQuery query);
    
    public List<BaseStation> findByPage(BaseStationQuery query);
}
