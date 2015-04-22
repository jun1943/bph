package com.tianyi.bph.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianyi.bph.domain.MessageManage;
import com.tianyi.bph.domain.MessageManageReceiver;

@MyBatisRepository
public interface MessageManageDAO {

	public void save(MessageManage msg);
	/**
	 * @param msg
	 */
	public void saveReceiver(MessageManageReceiver msg);

	/**
	 * @param userID
	 * @return
	 */
	public List<MessageManage> getByUserID(long userID);
	/**
	 * @param userID
	 * @return
	 */
	public List<MessageManage> getUnReadByUserID(long userID);
	/**
	 * @param msg
	 */
	public void updateReceiver(@Param("msgID")Long msgID,@Param("state")int state);
	
	/**
	 * @param msgID
	 * @return
	 */
	public MessageManageReceiver getReceiver(@Param("msgID")Long msgID,@Param("userID")Long userID);	
}
