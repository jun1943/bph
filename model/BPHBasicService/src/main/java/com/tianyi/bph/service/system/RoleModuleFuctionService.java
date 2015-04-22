package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.domain.system.RoleModuleFuctionKey;

public interface RoleModuleFuctionService {
	
	//增
	public void addRoleModuleFuctionKey(RoleModuleFuctionKey roleModuleFuctionKey);
	//删
	public void deleteRoleModuleFuctionKey(RoleModuleFuctionKey roleModuleFuctionKey);
	
	//分配角色权限
	public void allotRoleModules(Integer roleId, List<Integer> modulesId);
	/**
	 * 通过角色id获取功能模块
	 * @param roleId
	 * @return
	 */
	public List<RoleModuleFuctionKey> getModuleFunListByRoleId(Integer roleId);

}
