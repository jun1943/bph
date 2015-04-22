package com.tianyi.bph.service.system;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.tianyi.bph.domain.system.Role;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.service.BaseTest;
import com.tianyi.bph.service.system.UserService;

public class UserServiceTest extends BaseTest{

	@Autowired
    public UserService userService;
	
	@Autowired
	public UserRoleService userRoleService;
   
   /* @Before
    public void init() {

    }*/
    
	//获取用户和用户角色信息
	@Test
	public void getUser(){
		
	}
	
	@Test
	public void getFunctionsByUserId(){
		
		List<String> functionList=userRoleService.getFunctionsByUserId(Long.valueOf(1));
		
		System.out.println(functionList);
	}
	
}
