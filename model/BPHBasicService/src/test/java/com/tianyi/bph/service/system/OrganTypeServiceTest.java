package com.tianyi.bph.service.system;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;


import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.domain.system.OrganType;
import com.tianyi.bph.service.BaseTest;

public class OrganTypeServiceTest extends BaseTest{

	@Autowired
    public OrganTypeService organTypeService;
   
    @Before
    public void init() {

    }
    
	//获取用户和用户角色信息
	@Test
	public void testGetQueryList(){
		List<OrganType> list = organTypeService.getQueryList();
		for (OrganType organType : list) {
			System.out.println(organType.getCode() + " : " + organType.getTypeName());
		}
	}
	
}
