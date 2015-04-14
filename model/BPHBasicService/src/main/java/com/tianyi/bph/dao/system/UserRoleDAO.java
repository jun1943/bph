package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.UserRoleKey;

@MyBatisRepository
public interface UserRoleDAO {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
    
    int deleteByUserKey(Long userId);
    
    int getUserCountByRoleId(Integer roleId);
    
    List<String> getFunctionsByUserId(Long userId);
}