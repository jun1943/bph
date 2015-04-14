package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.CircleLayer;

/**
 * 圈层
 * 
 * @author Administrator
 *
 */
@MyBatisRepository
public interface CircleLayerDao {
	
	int deleteByPrimaryKey(Integer id);

    int insert(CircleLayer record);

//    CircleLayer selectByPrimaryKey(Integer id);
    
//    int updateByPrimaryKey(CircleLayer record);
    
    //根据条件查询总数
    int getUniqueCountByQuery(CircleLayer query);
    
    int updateByPrimaryKeySelective(CircleLayer record);
    
    CircleLayer getCircleLayerById(int id);
    
    public List<CircleLayer> getCircleLayerList();
}
