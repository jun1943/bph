package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.PatrolPoint;
//import com.tianyi.bph.query.system.PatrolPointQuery;
import com.tianyi.bph.query.system.PatrolPointQuery;

/**
 * 必达点位
 * 
 * @author Administrator
 *
 */
@MyBatisRepository
public interface PatrolPointDAO {
	
    int deleteByPrimaryKey(Integer id);

    int insert(PatrolPoint record);

    int insertSelective(PatrolPoint record);

    PatrolPoint selectByPrimaryKey(Integer id);
    
    PatrolPoint selectById(Integer id);

    int updateByPrimaryKeySelective(PatrolPoint record);

    int updateByPrimaryKey(PatrolPoint record);
    
    //根据条件查询总数
    int getUniqueCountByQuery(PatrolPointQuery patrolPointQuery);
    
    //根据子机构总数
    int getChildCount(Integer parentId);
    
    //查询排序号
    int getSortNo(Integer parentId);
    
    //分页查询
    List<PatrolPoint> findByPage(PatrolPointQuery patrolPointQuery);
    
    //分页总条数
    int findCount(PatrolPointQuery patrolPointQuery);
    
    //条件查询
    List<PatrolPoint> findByQuery(PatrolPointQuery patrolPointQuery);
   
    //修改指定字段
    int updateByMySelective(PatrolPoint record);
    
}