package com.tianyi.bph.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.domain.system.Role;
import com.tianyi.bph.query.system.OrganQuery;
import com.tianyi.bph.query.system.RoleQuery;

@MyBatisRepository
public interface RoleDAO{

	int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    int selectByRoleName(String name);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    //根据用户查询角色
	public List<Role> getRolesByUserId(Long id);
	
	//条件查询
    List<Role> findByQuery(RoleQuery roleQuery);
    
    
  //分页查询
    List<Role> findByPage(RoleQuery organQuery);
    
    //分页总条数
    int findCount(RoleQuery organQuery);
	/**
	 * 通过角色id获取功能模块Id
	 * @param item
	 * @return
	 */
    List<String> getModuleIdsByRoleIds(@Param("roleIds")String[] roleIds);
}
