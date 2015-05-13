package com.tianyi.bph.rest.action.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.BaseLogController;
import com.tianyi.bph.common.ReturnResult;
@RequestMapping("/client/log")
@Controller
public class LogAction extends BaseLogController {

	@RequestMapping(value="/saveLog.do")
	@ResponseBody
	public ReturnResult saveLog(HttpServletRequest request,
			@RequestParam(value="logType",required=true)Integer logType,
			@RequestParam(value="msg",required=true)String msg){
		try {
			addLog(request, msg, logType);
		} catch (Exception e) {
			// TODO: handle exception
			return ReturnResult.FAILUER(e.getMessage());
		}
		return ReturnResult.SUCCESS("添加日志成功");
	}
	
}
