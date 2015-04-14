package com.tianyi.bph.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.GroupManager;
import com.tianyi.bph.query.system.GroupManagerExample;
import com.tianyi.bph.query.system.GroupQuery;
@MyBatisRepository
public interface GroupManagerMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(GroupManager record);

    int insertSelective(GroupManager record);

    List<GroupManager> selectByExample(GroupManagerExample example);

    GroupManager selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") GroupManager record, @Param("example") GroupManagerExample example);

    int updateByExample(@Param("record") GroupManager record, @Param("example") GroupManagerExample example);

    int updateByPrimaryKeySelective(GroupManager record);

    int updateByPrimaryKey(GroupManager record);
    
    int selectByGroupQuery(GroupQuery query);
    
    List<GroupManager> getListByUserId(Integer userId);
}