package com.tianyi.bph.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.system.Log;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.query.system.LogQuery;
import com.tianyi.bph.service.system.LogService;


@Controller
@RequestMapping("log")
public class LogController{

	@Autowired 
	private LogService logService;
	
	@RequestMapping("/gotoLogList.action")
	public ModelAndView gotoLogList(
			@RequestParam(value="logTypeId",required=false)Integer logTypeId,
			@RequestParam(value="pageSize",required=false,defaultValue="10")Integer pageSize,
			@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo){
		ModelAndView mv= new ModelAndView("/base/log/logList.jsp");
		mv.addObject("num","500");
		return mv;
	}
	
	@RequestMapping("/getLogList.do")
	@ResponseBody
	public ReturnResult getLogList(HttpServletRequest request,
			@RequestParam(value="logTypeId",required=false)Integer logTypeId,
			@RequestParam(value="pageSize",required=false,defaultValue="10")Integer pageSize,
			@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo){
		LogQuery query =new LogQuery();
		User user=(User) request.getAttribute("User");
		if(user != null){
			query.setUserId(user.getUserId());
		}
		if(logTypeId != null){
			query.setLogTypeId(logTypeId);
		}
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		int totalRows=0;
		Pager<Log> logList=logService.getPageList(query);
		return ReturnResult.MESSAGE(200,"查询成功",totalRows,logList);
	}
}
