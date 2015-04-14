package com.tianyi.bph.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.tianyi.bph.common.JsonUtils;
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.ReturnResult;

/**
 * 参数集中处理类
 * @author heshencao@163.com 2013-5-9 下午7:45:34
 */
public class ExceptioinResolver extends SimpleMappingExceptionResolver {
	private static final Logger log=LoggerFactory.getLogger(ExceptioinResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		log.error(ex.getMessage(),ex);
		
		ReturnResult rst ;
		if (ex instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException pe = (MissingServletRequestParameterException) ex;
			rst = ReturnResult.MESSAGE(MessageCode.STATUS_NOTPRESENT,"关键参数【" + pe.getParameterName() + ":" + pe.getParameterType() + "】不能缺失！");
		}
		else if (ex instanceof TypeMismatchException) {
			TypeMismatchException pe = (TypeMismatchException) ex;
			rst = ReturnResult.MESSAGE(MessageCode.STATUS_TYPEMISMATCH, "参数类型错误【目标类型："+pe.getRequiredType()+"】"+"，实际值："+pe.getValue());
		}		
		else {
			rst = ReturnResult.MESSAGE(MessageCode.STATUS_EXCEPTION, "系统内部异常，请联系管理员！");
		}

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(JsonUtils.toJson(rst));
			writer.flush();
		}
		catch (IOException e) {
			log.error(e.getMessage(),e);
		}

		return null;
	}
}
