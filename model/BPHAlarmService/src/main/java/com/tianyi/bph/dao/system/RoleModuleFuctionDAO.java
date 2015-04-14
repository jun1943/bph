package com.tianyi.bph.dao.system;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.RoleModuleFuctionKey;

@MyBatisRepository
public interface RoleModuleFuctionDAO {
    int deleteByPrimaryKey(RoleModuleFuctionKey key);

    int insert(RoleModuleFuctionKey record);

    int insertSelective(RoleModuleFuctionKey record);
    
    int deleteByRoleKey(Integer roleId);
}