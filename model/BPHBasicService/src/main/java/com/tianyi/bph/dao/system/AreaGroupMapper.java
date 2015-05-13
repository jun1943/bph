package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.AreaGroup;
import com.tianyi.bph.domain.system.AreaGroupExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisRepository
public interface AreaGroupMapper {
    int countByExample(AreaGroupExample example);

    int deleteByExample(AreaGroupExample example);

    int deleteByPrimaryKey(Integer groupId);
    
    int insert(AreaGroup record);

    int insertSelective(AreaGroup record);

    List<AreaGroup> selectByExample(AreaGroupExample example);

    int updateByExampleSelective(AreaGroup record);

    int updateByExample(@Param("record") AreaGroup record, @Param("example") AreaGroupExample example);
}