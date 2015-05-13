package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.domain.system.ServiceSet;
import com.tianyi.bph.domain.system.ServiceSetExample;
import com.tianyi.bph.query.system.OrganQuery;
import com.tianyi.bph.query.system.ServiceSetQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisRepository
public interface ServiceSetMapper {
    int countByExample(ServiceSetExample example);

    int deleteByExample(ServiceSetExample example);

    int deleteByPrimaryKey(Integer serviceId);

    int insert(ServiceSet record);

    int insertSelective(ServiceSet record);

    List<ServiceSet> selectByExample(ServiceSetExample example);

    ServiceSet selectByPrimaryKey(Integer serviceId);

    int updateByExampleSelective(@Param("record") ServiceSet record, @Param("example") ServiceSetExample example);

    int updateByExample(@Param("record") ServiceSet record, @Param("example") ServiceSetExample example);

    int updateByPrimaryKeySelective(ServiceSet record);

    int updateByPrimaryKey(ServiceSet record);
    //去重
    int selectByQuery(ServiceSetQuery query);
    
    int findCount(ServiceSetQuery query);
    //分页查询
    List<ServiceSet> findByPage(ServiceSetQuery query);
    /**
     * 获取服务列表信息
     * @return
     */
    List<ServiceSet> getServcieList();
}