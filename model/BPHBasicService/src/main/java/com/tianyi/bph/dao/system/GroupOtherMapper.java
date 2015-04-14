package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.GroupManager;
import com.tianyi.bph.domain.system.GroupOther;
import com.tianyi.bph.query.system.GroupOtherExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisRepository
public interface GroupOtherMapper {
    int insert(GroupOther record);

    int insertSelective(GroupOther record);

    List<GroupOther> selectByExample(GroupOtherExample example);

    int updateByExampleSelective(@Param("record") GroupOther record, @Param("example") GroupOtherExample example);

    int updateByExample(@Param("record") GroupOther record, @Param("example") GroupOtherExample example);

    String getListIdsByGroupId(Integer groupId);
    
    int deleteByPrimaryKey(Integer groupId);
    
    List<GroupOther> selectByGroupId(Integer groupId);
    
    int deleteSource(GroupOther record); 
   
}