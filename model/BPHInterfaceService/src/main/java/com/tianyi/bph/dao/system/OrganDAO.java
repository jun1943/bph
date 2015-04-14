package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.system.OrganQuery;

@MyBatisRepository
public interface OrganDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(Organ record);

    int insertSelective(Organ record);

    Organ selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organ record);

    int updateByPrimaryKey(Organ record);
    
    //根据条件查询总数
    int getUniqueCountByQuery(OrganQuery organQuery);
    
    //根据子机构总数
    int getChildCount(Integer parentId);
    
    //查询排序号
    int getSortNo(Integer parentId);
    
    //分页查询
    List<Organ> findByPage(OrganQuery organQuery);
    //分页总条数
    int findCount(OrganQuery organQuery);
    
    //条件查询
    List<Organ> findByQuery(OrganQuery organQuery);
    
    //修改指定字段
    int updateByMySelective(Organ record);
    
    
}