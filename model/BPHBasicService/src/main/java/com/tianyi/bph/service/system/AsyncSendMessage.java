package com.tianyi.bph.service.system;

import com.tianyi.bph.common.mq.BaseData;

public interface AsyncSendMessage {

	/**
	 * 异步发送信息
	 * 
	 * @param baseData
	 */
	public void async(BaseData baseData);

	/**
	 * 异步发送信息
	 * 
	 * @param
	 */
	public void asyncJsonData(String routeKey, String jsonStr);

}
