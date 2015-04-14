package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.Bayonet;
import com.tianyi.bph.domain.system.BayonetInfo;
import com.tianyi.bph.query.system.BayonetInfoExample;
import com.tianyi.bph.query.system.BayonetQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisRepository
public interface BayonetInfoMapper {
	int deleteByPrimaryKey(Integer id);
	
	int insert(Bayonet record);
	
	int insertSelective(Bayonet record);
	
	BayonetInfo selectByPrimaryKey(Integer id);
	    
    int updateByPrimaryKeySelective(Bayonet record);

    //更改卡口信息
    int updateByPrimaryKey(BayonetInfo record);
    // 验证卡口重复性
    int getUniqueCountByQuery(BayonetQuery query);
    
    int findCount(BayonetQuery query);
    
    List<BayonetInfo> findByPage(BayonetQuery query);
}