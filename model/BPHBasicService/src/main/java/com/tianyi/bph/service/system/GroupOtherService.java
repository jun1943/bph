package com.tianyi.bph.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianyi.bph.domain.system.GroupOther;
import com.tianyi.bph.query.system.GroupOtherExample;

public interface GroupOtherService {
	int insert(GroupOther record);

    int insertSelective(GroupOther record);

    List<GroupOther> selectByExample(GroupOtherExample example);

    int updateByExampleSelective(@Param("record") GroupOther record, @Param("example") GroupOtherExample example);

    int updateByExample(@Param("record") GroupOther record, @Param("example") GroupOtherExample example);

    String getListIdsByGroupId(Integer userId);
}
