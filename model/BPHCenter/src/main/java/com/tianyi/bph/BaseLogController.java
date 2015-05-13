package com.tianyi.bph;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.rest.CommonUtils;
import com.tianyi.bph.service.system.LogService;

@Controller
public class BaseLogController {

	@Autowired LogService logService;
	
	/**
	 * 添加日志入库
	 * @param request
	 * @param msg
	 */
	public void addLog(HttpServletRequest request,String msg,Integer logType){
		User user=(User) request.getAttribute("User");
		logService.insert(CommonUtils.getRemoteIp(request),user.getUserId()+"",
				user.getUserName(),msg,logType);
	}
}
