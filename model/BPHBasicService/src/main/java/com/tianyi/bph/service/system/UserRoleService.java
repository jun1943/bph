package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.domain.system.UserRoleKey;

public interface UserRoleService {
	
	//增
	public void addUserRole(UserRoleKey userRoleKey);
	
	//删
	public void deleteUserRole(UserRoleKey userRoleKey);
	
	//根据人员删除
	public void deleteByUserKey(Long userId);
	
	//分配用户角色
	public void allotUserRoles(Long userId, Integer[] rolesId);
	
	/**
	 * 通过userId 来获取 功能权限
	 * @param userId
	 * @return
	 */
	public List<String> getFunctionsByUserId(Long userId);

}
