package com.tianyi.bph.service.system;

import java.util.List;

import com.tianyi.bph.domain.FunctionModule;
import com.tianyi.bph.domain.system.Module;
import com.tianyi.bph.domain.system.RoleModuleFuctionKey;
import com.tianyi.bph.query.system.ModuleQuery;



public interface ModuleService {
	
	//增
	public void addModule(Module module);
	//删
	public void deleteModule(Integer id);
	//改
	public void updateModule(Module module);
	
	public Module getModuleByPrimaryKey(Integer Id);
	
	List<String> getFirstByParentId(Integer Id);
	
	//根据用户查询用户模块权限
	public List<Module> getModulesByUserId(Integer userId);
	
	//根据条件查询模块信息
	public List<Module> getQueryList(ModuleQuery moduleQuery);
	
	//根据角色id 获取功能权限id
	public List<RoleModuleFuctionKey> getModulesByRoleId(Integer roleId);
	/**
	 * 通过父id获取下级功能点
	 * @param parentIds
	 * @return
	 */
	public List<String> findModuleByParentId(Integer parentId);
	/**
	 * 获取一级功能id
	 * @param parentId
	 * @return
	 */
	public List<String> findModuleSecondLevel(Integer parentId);
	/**
	 * 获取功能集合
	 * @return
	 */
	public FunctionModule findModuleList();
	
	/**
	 * 获取功能树
	 * @param moduleQuery
	 * @return
	 */
	 public Module getTree(ModuleQuery moduleQuery);
	 /**
	  * 通过用户id 或者角色ids 来获取功能树
	  * @param moduleQuery
	  * @return
	  */
	 public Module getTreeByUserIdOrRolesId(ModuleQuery moduleQuery);

}
