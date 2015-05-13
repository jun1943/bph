package com.tianyi.bph.web.action.system;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianyi.bph.BaseTest;
import com.tianyi.bph.rest.action.system.BayonetAction;

public class BayOnetInfoControllerTest extends BaseTest {
	@Autowired
	private BayonetAction bayoneAction;
	
	
	//@Test
	public void testGetBay(){
		bayoneAction.getBayoneList("2");
	}
	@Test
	public void testUpdate(){
		//bayoneAction.update("1", "3", "3");
	}
	
}
