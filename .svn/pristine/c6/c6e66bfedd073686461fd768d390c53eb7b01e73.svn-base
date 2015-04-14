package com.tianyi.bph.web.action;

import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import com.tianyi.bph.BaseTest;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.rest.PrivilegeCache;
import com.tianyi.bph.rest.action.MessageManageAction;
import com.tianyi.bph.common.ReturnResult;


public class MessageManageControllerTest extends BaseTest{

	@Autowired MessageManageAction controller;
	
	@Before
	public void setUp(){
		HttpSession session=new MockHttpSession();
		User user=new User();
		user.setUserId(11111L);
		PrivilegeCache.instance.addPrivilege(user.getUserId(), user, session);
		
		PrivilegeCache.instance.getPrivilege(session);
	}
	@Test
	public void testSave(){
		ReturnResult rt=controller.save(new Long[]{123222l,123111l,123444l},"111" , "222", "你是做什么的哦！");
		Assert.assertNotNull(rt);
		Assert.assertEquals(200,rt.getCode());
	}
	
	@Test
	public void testQueryMessage(){
		ReturnResult rt=controller.QueryMessage();
		Assert.assertNotNull(rt);
		Assert.assertEquals(200,rt.getCode());
	}
	
	@Test
	public void testGetHistory(){
		ReturnResult rt=controller.getHistory();
		Assert.assertNotNull(rt);
		Assert.assertEquals(200,rt.getCode());
	}
}
