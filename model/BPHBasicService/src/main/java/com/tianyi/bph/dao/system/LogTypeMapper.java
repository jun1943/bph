package com.tianyi.bph.dao.system;

import com.tianyi.bph.domain.system.LogType;
import com.tianyi.bph.domain.system.LogTypeExample;
import java.util.List;

public interface LogTypeMapper {
    int deleteByPrimaryKey(Integer logTypeId);

    int insert(LogType record);

    int insertSelective(LogType record);

    List<LogType> selectByExample(LogTypeExample example);

    LogType selectByPrimaryKey(Integer logTypeId);

    int updateByPrimaryKeySelective(LogType record);

    int updateByPrimaryKey(LogType record);
}