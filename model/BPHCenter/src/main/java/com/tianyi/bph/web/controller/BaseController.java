package com.tianyi.bph.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.web.cache.UserCache;

public class BaseController {
	
	public void getSession(String sessionId,HttpServletRequest request){
		User user=null;
		if(!StringUtils.isEmpty(sessionId)){//客户端
			HttpSession session=UserCache.getSession(sessionId);
			user=(User)session.getAttribute("User");
			request.setAttribute("sessionId", sessionId);
			request.setAttribute("organPath", session.getAttribute("organPath"));
			request.setAttribute("organId", session.getAttribute("organId"));
			request.setAttribute("expandeds", session.getAttribute("expandeds"));
		}else{//服务端
			user=(User) request.getSession().getAttribute("User");
			request.setAttribute("organPath", request.getSession().getAttribute("organPath"));
			request.setAttribute("organId", request.getSession().getAttribute("organId"));
			request.setAttribute("expandeds", request.getSession().getAttribute("expandeds"));
		}
	}
}
