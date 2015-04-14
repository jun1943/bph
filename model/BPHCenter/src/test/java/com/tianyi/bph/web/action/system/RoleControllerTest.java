package com.tianyi.bph.web.action.system;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.tianyi.bph.BaseTest;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.system.Role;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.service.system.RoleService;
import com.tianyi.bph.web.controller.system.RoleController;




public class RoleControllerTest extends BaseTest {

	@Autowired
	RoleController roleController;
	@Autowired RoleService roleService;
	
	/*@Test
	public void testSaveRole(){
		
		Role role = new Role();
		
		role.setName("管理员");
		Integer id = (Integer)roleController.addRole(role).getData();
		System.out.println(id + "---");
		Assert.assertNotNull(id);
	}
	
	@Test
	public void testGetRole(){
		
		Role role = (Role) roleController.queryRoleDetail(1).getData();
		System.out.println(role.getName());
		Assert.assertNotNull(role);
	}
	
	@Test
	public void testModifyUser(){
		
		Role role = new Role();
		role.setId(1);
		role.setNote("这是管理员");
		String message = roleController.modifyRole(role).getDescription();
		System.out.println(message);
		Assert.assertNotNull(role);
	}
	
	@Test
	@Rollback(true)
	public void testDeleteUser(){
		
		String message = roleController.deleteRole(2).getDescription();
		System.out.println(message);
	}*/
	@Test
	@Rollback(true)
	public void getModuleIdsByRoleIds(){
		String str="6,7,8,9,10,11,12";
		//String[] roleIds=str.split(",");
		//List<String> strr=roleService.getModuleIdsByRoleIds(roleIds);
		roleController.getModuleTreeByRoles("","");
		//System.out.println(strr);
	}
	/*@Test
	@Rollback(true)
	public void testTree(){
		roleController.getModuleTree(null);
	}*/
}
