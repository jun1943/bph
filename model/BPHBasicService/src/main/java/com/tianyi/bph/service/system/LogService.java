package com.tianyi.bph.service.system;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.system.Log;
import com.tianyi.bph.query.system.LogQuery;
public interface LogService {
	/**
	 * 获取分页列表信息
	 * @param query
	 * @return
	 */
	Pager<Log> getPageList(LogQuery query);
	
	/**
	 * 添加日志
	 * @param log
	 */
	public void insert(String loginIp,String userId,String userName,String msg,Integer type);
}
