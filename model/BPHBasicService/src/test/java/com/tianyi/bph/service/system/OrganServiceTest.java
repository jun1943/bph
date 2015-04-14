package com.tianyi.bph.service.system;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;


import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.service.BaseTest;

public class OrganServiceTest extends BaseTest{

	@Autowired
    public OrganService organService;
   
    @Before
    public void init() {

    }
    
	@Test
	public void save(){
		Organ organ = new Organ();
		organ.setCode("111");
		organ.setName("成都公安局");
		organ.setPath("gonganju");
		organ.setShortName("成都公安局");
		organ.setOrgTypeCode("111");
		//Integer id = (Integer)organService.addOrgan(organ);
		//System.out.println(id);
	}
	
	
}
