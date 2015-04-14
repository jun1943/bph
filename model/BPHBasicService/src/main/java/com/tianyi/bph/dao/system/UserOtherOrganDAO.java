package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.UserOtherOrgan;

@MyBatisRepository
public interface UserOtherOrganDAO {
	int deleteByPrimaryKey(UserOtherOrgan key);

    int insert(UserOtherOrgan record);

    int insertSelective(UserOtherOrgan record);
    
    int deleteByUserKey(Long userId);
    
    List<String> getOrganIdByUserId(Long userId);
    
    String getOrganIdsByUserId(Long userId);

}
