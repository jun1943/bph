package com.tianyi.bph.web.controller.system;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.bph.common.Md5Encrypt;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.system.ServiceSet;
import com.tianyi.bph.query.system.ServiceSetQuery;
import com.tianyi.bph.service.ServiceSetService;

@Controller
@RequestMapping("serviceSet")
public class ServiceSetController {

	@Autowired 
	private ServiceSetService serviceSetServcie;
	
	@RequestMapping({"/gotoServiceSetList.do","/gotoServiceSetList.action"})
	public ModelAndView gotoServiceSetList(@RequestParam(value="name",required=false)String name,
			@RequestParam(value="pageSize",required=false,defaultValue="10")Integer pageSize,
			@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo
			){
		ModelAndView mv=new ModelAndView("/base/serviceConf/serviceConfigList.jsp");
		/*ServiceSetQuery query=new ServiceSetQuery();
		if(!StringUtils.isEmpty(name)){query.setServiceName(name);}
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		Pager<ServiceSet> serviceList=serviceSetServcie.getPageList(query);
		mv.addObject("pageList",serviceList);*/
		mv.addObject("num","500");
		return mv;
	}
	
	@RequestMapping(value="/getServiceSetList.do")
	@ResponseBody
	public ReturnResult getServiceSetList(@RequestParam(value="name",required=false)String name,
			@RequestParam(value="pageSize",required=false,defaultValue="10")Integer pageSize,
			@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo){
		ServiceSetQuery query=new ServiceSetQuery();
		if(!StringUtils.isEmpty(name)){query.setServiceName(name);}
		int totalRows=0;
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		Pager<ServiceSet> serviceList=serviceSetServcie.getPageList(query);
		totalRows=serviceList.getTotalRows();
		return ReturnResult.MESSAGE(200,"查询成功",totalRows,serviceList);
	}
	
	
	@RequestMapping(value="/insert.do")
	@ResponseBody
	public  ReturnResult insert(
			@RequestParam(value="serviceName",required=true)String serviceName,
			@RequestParam(value="serviceType",required=true)Integer serviceType,
			@RequestParam(value="serviceIp",required=true)String serviceIp,
			@RequestParam(value="servicePort",required=true)Integer servicePort,
			@RequestParam(value="serviceAccount",required=true)String serviceAccount,
			@RequestParam(value="servicePwd",required=true)String servicePwd,
			@RequestParam(value="exchangeName",required=false)String exchangeName,
			@RequestParam(value="serviceVersion",required=true)String serviceVersion){
		try {
			ServiceSet set=new ServiceSet();
			set.setServiceName(serviceName);
			set.setServiceType(serviceType);
			set.setServiceIp(serviceIp);
			set.setServicePort(servicePort);
			set.setServiceAccount(serviceAccount);
			set.setServicePwd(servicePwd);
			if(!StringUtils.isEmpty(exchangeName)){
				set.setExchangeName(exchangeName);
			}
			set.setServiceVersion(serviceVersion);
			int i=serviceSetServcie.insert(set);
			if(i==0){
				return ReturnResult.FAILUER("添加失败,已存在此类型的服务");
			}
		} catch (Exception e) {
			e.getStackTrace();
			return ReturnResult.FAILUER("添加失败");
		}
		return ReturnResult.SUCCESS("添加成功");
	}
	
	
	@RequestMapping(value="/update.do")
	@ResponseBody
	public ReturnResult update(@RequestParam(value="serviceId",required=true)Integer serviceId,
			@RequestParam(value="serviceName",required=true)String serviceName,
			@RequestParam(value="serviceType",required=true)Integer serviceType,
			@RequestParam(value="serviceIp",required=true)String serviceIp,
			@RequestParam(value="servicePort",required=true)Integer servicePort,
			@RequestParam(value="serviceAccount",required=true)String serviceAccount,
			@RequestParam(value="servicePwd",required=true)String servicePwd,
			@RequestParam(value="exchangeName",required=false)String exchangeName,
			@RequestParam(value="serviceVersion",required=true)String serviceVersion
			){
		
		ServiceSet set=new ServiceSet();
		set.setServiceId(serviceId);
		set.setServiceName(serviceName);
		set.setServiceType(serviceType);
		set.setServiceIp(serviceIp);
		set.setServicePort(servicePort);
		set.setServiceAccount(serviceAccount);
		set.setServicePwd(servicePwd);
		set.setExchangeName(exchangeName);
		set.setServiceVersion(serviceVersion);
		try {
			serviceSetServcie.updateByPrimaryKey(set);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnResult.SUCCESS("更新失败");
		}
		return ReturnResult.SUCCESS("更新成功");
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public ReturnResult delete(
			@RequestParam(value="serviceId",required=true)Integer serviceId){
		try {
			serviceSetServcie.deleteByPrimaryKey(serviceId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ReturnResult.SUCCESS("删除成功");
	}
	
	@RequestMapping(value="/gotoAddService.do")
	public ModelAndView gotoAddService(){
		ModelAndView mv=new ModelAndView("/base/serviceConf/serviceAdd.jsp");
		return mv;
	}
	
	@RequestMapping(value="/gotoServiceDetail.do")
	public ModelAndView gotoServiceDetail(
			@RequestParam(value="serviceId",required=true)Integer serviceId){
		ModelAndView mv=new ModelAndView("/base/serviceConf/serviceEdit.jsp");
		ServiceSet service=serviceSetServcie.selectByPrimaryKey(serviceId);
		mv.addObject("service",service);
		return mv;
	}
	
}
