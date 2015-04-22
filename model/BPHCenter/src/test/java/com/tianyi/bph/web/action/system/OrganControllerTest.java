package com.tianyi.bph.web.action.system;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianyi.bph.BaseTest;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.system.OrganQuery;
import com.tianyi.bph.rest.action.system.OrganAction;
import com.tianyi.bph.web.controller.system.OrganController;
import com.tianyi.bph.common.ReturnResult;


public class OrganControllerTest extends BaseTest {

	@Autowired
	OrganAction organController;
	
	@Autowired
	OrganController organSe;
	
	/*@Test
	//@Rollback(false)
	public void testSave(){
		
		Organ organ = new Organ();
		organ.setCode("112");
		organ.setName("成都公安局");
		organ.setPath("gonganju");
		organ.setShortName("成都公安局");
		organ.setOrgTypeCode("111");
		organ.setOrgPcCgyCode("222");
		//ReturnResult returnResult = organController.addOrgan(organ);
		ReturnResult returnResult = organSe.addOrgan("成都公安局","112",0,1,0);
		if (null == returnResult.getData()) {
			System.out.println(returnResult.getDescription());
		}
		Assert.assertNotNull(returnResult.getData());
	}*/
	
	/*@Test
	public void testGetById(){
		
		Organ organ = (Organ)organController.queryOrganDetail(7).getData();
		Assert.assertNotNull(organ);
		Assert.assertEquals(7, organ.getId().intValue());
		
	}*/
	
	/*@Test
	public void testPage(){
		OrganQuery organQuery = new OrganQuery();
		organQuery.setPageNo(1);
		organQuery.setPageSize(2);
		Pager<Organ> pager = (Pager<Organ>) organController.queryOrganPageList(organQuery).getData();
		List<Organ> list = pager.getData();
		for(Organ organ : list){
			System.out.println(organ.getId() + organ.getName());
		}
		Assert.assertNotNull(pager.getData());
	}
	
	@Test
	public void testGetByQuery(){
		
		List<Organ> organs = (List<Organ>) organController.queryOrganList(new OrganQuery()).getData();
		
		for(Organ organ : organs){
			if (null != organ.getParentOrgan()) {
				System.out.println(organ.getParentOrgan().getName());
			}
			
		}
	}*/
	/*@Test
	public void testOrganTree(){
		ReturnResult result=organSe.tree(null, null, 1, 10, null);
		System.out.println(result.getDescription());
	}*/
}
