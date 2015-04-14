package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.Bayonet;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.system.BayonetQuery;

@MyBatisRepository
public interface BayonetDao {

	int deleteByPrimaryKey(Integer id);
	
	int insert(Bayonet record);
	
	int insertSelective(Bayonet record);
	
	Bayonet selectByPrimaryKey(Integer id);
	    
    int updateByPrimaryKeySelective(Bayonet record);

    //更改卡口信息
    int updateByPrimaryKey(Bayonet record);
    // 验证卡口重复性
    int getUniqueCountByQuery(BayonetQuery query);
    
    int findCount(BayonetQuery query);
    
    List<Bayonet> findByPage(BayonetQuery query);
}
