package com.tianyi.bph.dao.system;

import java.util.List;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.Role;
import com.tianyi.bph.query.system.RoleQuery;

@MyBatisRepository
public interface RoleDAO{

	int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    //根据用户查询角色
	public List<Role> getRolesByUserId(Long id);
	
	//条件查询
    List<Role> findByQuery(RoleQuery roleQuery);
}
