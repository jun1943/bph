package com.tianyi.bph.rest.action.system;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.domain.system.Role;
import com.tianyi.bph.query.system.RoleQuery;
import com.tianyi.bph.service.LogService;
import com.tianyi.bph.service.system.RoleModuleFuctionService;
import com.tianyi.bph.service.system.RoleService;
import com.tianyi.bph.common.ReturnResult;

@Controller
@RequestMapping("/role")
public class RoleAction {

	static final Logger log = LoggerFactory.getLogger(RoleAction.class);

	@Autowired RoleService roleService;
	
	@Autowired RoleModuleFuctionService roleModuleFuctionService;
	
	@Autowired LogService logService;

	/**
	 * @param request
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getRolesByUserId.do")
	@ResponseBody
	public ReturnResult getRolesByUserId(
			@RequestParam(value = "userId", required =true) Long userId) {
		List<Role> roles = roleService.getRolesByUserId(userId);
        
		return ReturnResult.SUCCESS(roles);
	}
	
	/**
	 * 添加角色
	 * @param organ @
	 * @
	 * @return
	 */
	@RequestMapping(value = "/addRole.do")
	@ResponseBody
	public ReturnResult addRole(Role role) {
		
		int id = roleService.addRole(role);

		return ReturnResult.SUCCESS("成功", id);
	}
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteRole.do")
	@ResponseBody
	public ReturnResult deleteRole(
			@RequestParam(value = "id", required =true) Integer id) {
		
		//roleService.deleteRole(id);

		return ReturnResult.SUCCESS();
	}
	
	/**
	 * 修改角色信息
	 * @param organ
	 * @return
	 */
	@RequestMapping(value = "/modifyRole.do")
	@ResponseBody
	public ReturnResult modifyRole(Role role) {
		
		roleService.updateRole(role);

		return ReturnResult.SUCCESS();
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryRoleDetail.do")
	@ResponseBody
	public ReturnResult queryRoleDetail(
			@RequestParam(value = "id", required =true) Integer id) {
		
		Role role = roleService.getRoleById(id);
		return ReturnResult.SUCCESS(role);
	}

	
	/**
	 * 条件查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/queryRoleList.do")
	@ResponseBody
	public ReturnResult queryRoleList(RoleQuery query) {
		
		List<Role> roles = roleService.getQueryList(query);
		return ReturnResult.SUCCESS(roles);
	}
	
	/**
	 * 角色权限分配
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/allotRoleModules.do")
	@ResponseBody
	public ReturnResult allotRoleModules(Integer roleId, List<Integer> modulesId) {
		
		roleModuleFuctionService.allotRoleModules(roleId, modulesId);

		return ReturnResult.SUCCESS("成功");
	}

}
