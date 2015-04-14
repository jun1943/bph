package com.tianyi.bph.rest.action;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tianyi.bph.domain.MessageManage;
import com.tianyi.bph.domain.MessageManageReceiver;
import com.tianyi.bph.rest.PrivilegeCache;
import com.tianyi.bph.rest.PrivilegeCache.PrivilegeUser;
import com.tianyi.bph.service.MessageManageService;
import com.tianyi.bph.common.ReturnResult;

/**
 * @author he
 *
 */
@Controller
@RequestMapping("/MessageManage")
public class MessageManageAction {

	@Autowired MessageManageService service;
	/**
	 * @param targetIds
	 * @param targetType
	 * @param msgKey
	 * @param msgContent
	 * @return
	 */
	@RequestMapping(value = "/AddMessage.do")
	@ResponseBody
	public ReturnResult save(@RequestParam(value = "TargetIds", required =false) Long[] targetIds,
			@RequestParam(value = "TargetType", required = true) String targetType,
			@RequestParam(value = "MsgKey", required =true) String msgKey,
			@RequestParam(value = "MsgContent", required =true) String msgContent){
		
		PrivilegeUser pu=PrivilegeCache.currentUser();
		
		
		MessageManage msg=new MessageManage();
		msg.setCreatTime(new Date());
		msg.setContent(msgContent);
		msg.setMsgKey(msgKey);
		msg.setState(1);
		msg.setUserID(pu.getID());
		msg.setTargetType(targetType);
		service.save(msg);
		
		if(targetIds!=null){
			for(Long userID:targetIds){
				MessageManageReceiver mr=new MessageManageReceiver();
				mr.setMsgID(msg.getID());
				mr.setReceiveUserID(userID);
				mr.setState(0);
				service.saveReceiver(mr);
			}
		}
		
		return ReturnResult.SUCCESS("添加成功");
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/QueryMessage.do")
	@ResponseBody
	public ReturnResult QueryMessage(){
		PrivilegeUser pu=PrivilegeCache.currentUser();
		List<MessageManage> list=service.getUnReadByUserID(pu.getID());
		return ReturnResult.SUCCESS(list);
	}
	
	@ResponseBody
	@RequestMapping(value = "/QueryHistory.do")
	public ReturnResult getHistory(){
		PrivilegeUser pu=PrivilegeCache.currentUser();
		return ReturnResult.SUCCESS(service.getByUserID(pu.getID()));
	}
}
