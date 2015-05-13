package com.tianyi.bph.service;

import com.tianyi.bph.common.Pager;
import com.tianyi.bph.domain.system.ServiceSet;
import com.tianyi.bph.domain.system.ServiceVO;
import com.tianyi.bph.domain.system.User;
import com.tianyi.bph.query.system.ServiceSetQuery;

public interface ServiceSetService {
	/**
	 * 新增服务
	 * @param record
	 * @return
	 */
	int insert(ServiceSet record);
	
	/**
	 * 修改服务信息
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(ServiceSet record);
	
	/**
	 * 删除服务信息
	 * @param serviceId
	 * @return
	 */
	int deleteByPrimaryKey(Integer serviceId);
	
	/**
	 * 查询服务列表
	 * @param query
	 * @return
	 */
	Pager<ServiceSet> getPageList(ServiceSetQuery query);
	
	/**
	 * 根据id查询服务信息
	 * @param serviceId
	 * @return
	 */
	ServiceSet selectByPrimaryKey(Integer serviceId);
	/**
	 * 获取服务信息。并把各服务地址返回给客户端
	 * @return
	 */
	User getServcieList(User user);
	
	
}
