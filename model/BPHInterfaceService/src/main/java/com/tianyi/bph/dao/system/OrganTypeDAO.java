package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.OrganType;

@MyBatisRepository
public interface OrganTypeDAO {
    int deleteByPrimaryKey(String code);

    int insert(OrganType record);

    int insertSelective(OrganType record);

    OrganType selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(OrganType record);

    int updateByPrimaryKey(OrganType record);
    
    List<OrganType> findByQuery();
}