/**
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved. 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 */
package com.tianyi.bph.web.integrate;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
*
* @author fantedan@tieserv.com
* @date  2015-1-21 下午12:08:35
*/

public class MixedViewResolver implements ViewResolver {

	static Logger _LOG = LoggerFactory.getLogger(MixedViewResolver.class);
	
	private Map<String, ViewResolver> resolverMap;
	private static final String DO = "do";
	private static final String JSP = "jsp";

	public View resolveViewName(String viewName, Locale locale) throws Exception {
		int lastLen = viewName.lastIndexOf(".");
		if (lastLen != -1) {
			String suffix = viewName.substring(lastLen + 1);
			if (suffix.equalsIgnoreCase(MixedViewResolver.DO)) {
				suffix = MixedViewResolver.JSP;
			}
			ViewResolver resolver = (ViewResolver) this.resolverMap.get(suffix);
			if (resolver == null) {
				throw new RuntimeException("No ViewResolver for : " + suffix);
			}
			return resolver.resolveViewName(viewName, locale);
		} else {
			ViewResolver resolver = (ViewResolver) this.resolverMap.get(MixedViewResolver.JSP);
			return resolver.resolveViewName(viewName, locale);
		}
	}

	public void setResolverMap(Map<String, ViewResolver> resolverMap) {
		this.resolverMap = resolverMap;
	}

}
