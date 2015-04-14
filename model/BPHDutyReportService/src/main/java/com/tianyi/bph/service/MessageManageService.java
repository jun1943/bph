package com.tianyi.bph.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyi.bph.dao.MessageManageDAO;
import com.tianyi.bph.domain.MessageManage;
import com.tianyi.bph.domain.MessageManageReceiver;

@Service
public class MessageManageService {

	@Autowired MessageManageDAO dao;
	
	public void save(MessageManage msg){
		dao.save(msg);
	}
	public void saveReceiver(MessageManageReceiver msg){
		dao.saveReceiver(msg);
	}
	
	public List<MessageManage> getUnReadByUserID(long userID){
		List<MessageManage> list=dao.getUnReadByUserID(userID);
		if(list!=null){
			for(MessageManage msg :list){
				if(null!=dao.getReceiver(msg.getID(),userID)){
					dao.updateReceiver(msg.getID(),1);
				}else{
					MessageManageReceiver mr=new MessageManageReceiver();
					mr.setMsgID(msg.getID());
					mr.setReceiveTime(new Date());
					mr.setReceiveUserID(userID);
					mr.setState(1);
					dao.saveReceiver(mr);
				}
				
			}
		}
		return list;
	}
	public List<MessageManage> getByUserID(long userID){
		return dao.getByUserID(userID);
	}
}
