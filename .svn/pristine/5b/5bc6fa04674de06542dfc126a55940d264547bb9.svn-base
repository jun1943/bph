/**
 * copy right 2012 sctiyi all rights reserved
 * create time:10:45:38 AM
 * author:ftd
 */
package com.tianyi.bph.web;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.bph.common.JsonUtils;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.web.PrivilegeCache.PrivilegeUser;
import com.tianyi.bph.common.utils.DateUtils;

/**
 * @author he
 * 系统拦截器
 */
public class PrivilegeInteceptor implements HandlerInterceptor {
	private final static Logger log=LoggerFactory.getLogger(PrivilegeInteceptor.class);
	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
		HttpSession session=request.getSession();
		
        String uri = request.getRequestURI();
        log.debug("收到请求："+uri+",会话["+session.getId()+","+DateUtils.format(new Date(session.getCreationTime()),DateUtils.YYYY_MM_DD_HH_MM_SS)+"]");
        
        //后台session控制
        if (uri.contains("login.do")) {  
        	return true; 
        }
        else{
        	PrivilegeUser pu=PrivilegeCache.instance.getPrivilege(session);
        	if (pu!=null) {
	        	return true;
        	}else {
        		
    			response.setStatus(401);
        		ReturnResult rst=ReturnResult.FAILUER("用户未登陆！");
        		response.setContentType("text/html;charset=UTF-8");           
				response.setHeader("Cache-Control", "no-cache");
        		PrintWriter  writer=response.getWriter();
        		writer.write(JsonUtils.toJson(rst));
	        		
        		log.debug("会话["+session.getId()+","+DateUtils.format(new Date(session.getCreationTime()),DateUtils.YYYY_MM_DD_HH_MM_SS)+"]未登录！跳转登录页面。");
        		return false;
        		
        	}
        }
	}
}
