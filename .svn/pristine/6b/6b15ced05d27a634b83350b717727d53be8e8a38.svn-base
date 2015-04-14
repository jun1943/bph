package com.tianyi.bph.web.action.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianyi.bph.BaseTest;
import com.tianyi.bph.domain.system.Role;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.query.system.UserQuery;
import com.tianyi.bph.rest.action.system.UserAction;
import com.tianyi.bph.web.controller.system.UserController;



public class UserControllerTest {

	@Autowired
	UserAction userController;
	@Autowired
	UserController userc;
	
	
	
/*@Test	
	public void testSaveUser(){
		
		User user = new User();
		user.setLoginName("admin");
		user.setUserName("张三");
		user.setPassword("111111");
		user.setOrgId(0);

		
		String message = userController.addUser(user,"", "").getDescription();
		System.out.println(message + "---");
		Assert.assertNotNull(message);
	}*/

//	@Test
//	public void testLogin(){
//		userc.login(null,"admin", "111111");
//	}

	/*public void testGetUser(){
		
		User user = (User) userController.queryUserDetail(66L).getData();
		System.out.println(user.getUserName());
		System.out.println(user.getUpdateTime());
		Assert.assertNotNull(user);
	}
	
	
	public void testModifyUser(){
		
		User user = new User();
		user.setUserId(66L);
		user.setLoginName("zhangsan");
		String message = userController.modifyUser(user,null,null).getDescription();
		System.out.println(message);
		Assert.assertNotNull(user);
	}
	
	
	public void testDeleteUser(){
		
		String message = userController.deleteUser(66L).getDescription();
		System.out.println(message);
	}
	
	public void testQueryUser(){
		
		UserQuery query = new UserQuery();
		List<User> users = (List<User>) userController.queryUserList(query).getData();
		System.out.println(users.get(0).getRoles());
		for (User user : users) {
			if (null == user.getRoles()) {
				System.out.println("用户角色为空");
			}else {
				for (Role role : user.getRoles()) {
					System.out.println(role.getName() + "AAAAAAAAAAAA");
				}
			}
		}
	}*/
	
}
