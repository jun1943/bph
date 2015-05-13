package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.Log;
import com.tianyi.bph.domain.system.LogExample;
import com.tianyi.bph.domain.system.LogKey;
import com.tianyi.bph.query.system.LogQuery;

import java.util.List;
@MyBatisRepository
public interface LogMapper {
    int deleteByPrimaryKey(LogKey key);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(LogKey key);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
    
    int findCount(LogQuery query);
    //分页查询
    List<Log> findByPage(LogQuery query);
}