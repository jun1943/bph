package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.PatrolArea;
import com.tianyi.bph.query.system.PatrolAreaQuery;

/**
 * 巡逻区域
 * 
 * @author Administrator
 *
 */
@MyBatisRepository
public interface PatrolAreaDAO {
	
    int deleteByPrimaryKey(Integer id);

    int insert(PatrolArea record);

    int insertSelective(PatrolArea record);

    PatrolArea selectByPrimaryKey(Integer id);
    
    PatrolArea selectById(Integer id);

    int updateByPrimaryKeySelective(PatrolArea record);

    int updateByPrimaryKey(PatrolArea record);
    
    //根据条件查询总数
    int getUniqueCountByQuery(PatrolAreaQuery patrolAreaQuery);
    
    //根据子机构总数
    int getChildCount(Integer parentId);
    
    //查询排序号
    int getSortNo(Integer parentId);
    
    //分页查询
    List<PatrolArea> findByPage(PatrolAreaQuery patrolAreaQuery);
    
    //分页总条数
    int findCount(PatrolAreaQuery patrolAreaQuery);
    
    //条件查询
    List<PatrolArea> findByQuery(PatrolAreaQuery patrolAreaQuery);
   
    //修改指定字段
    int updateByMySelective(PatrolArea record);
    
}