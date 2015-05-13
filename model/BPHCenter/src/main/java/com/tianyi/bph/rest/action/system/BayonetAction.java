package com.tianyi.bph.rest.action.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.BaseLogController;
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.domain.system.BayonetInfo;
import com.tianyi.bph.query.system.BayonetQuery;
import com.tianyi.bph.service.system.BayonetService;
@Controller
@RequestMapping("/client/bayonet")
public class BayonetAction extends BaseLogController {
	private static final Logger log=LoggerFactory.getLogger(BayonetAction.class);
	
	@Autowired BayonetService bayonetService;
	
	/**
	 * 获取卡口信息列表
	 * @param bayonetName
	 * @param bayonetCode
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/getBayonetList.do")
	@ResponseBody
	public ReturnResult getBayoneList(
			@RequestParam(value="organId",required=false)String organId){
		BayonetQuery query=new BayonetQuery();
		if(!StringUtils.isEmpty(organId)){
			query.setOrganId(Integer.parseInt(organId));
		}
		List<BayonetInfo> bayonetList=bayonetService.getPageList(query);
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,"获取卡口信息成功",bayonetList);
	}
	
	/**
	 * 通过经纬度来修改和标识卡口信息
	 * @param longitude 
	 * @param latitude
	 * @return
	 */
	@RequestMapping(value="/update.do")
	@ResponseBody
	public ReturnResult update(
			@RequestParam(value="bayonetId",required=true) String bayonetId,
			@RequestParam(value="longitude",required=true) String longitude,
			@RequestParam(value="latitude",required=true) String latitude,
			HttpServletRequest request){
		try{
			BayonetInfo bayonet =new BayonetInfo();
			bayonet.setBayonetId(Integer.parseInt(bayonetId));
			bayonet.setLongitude(longitude);
			bayonet.setLatitude(latitude);
			
			BayonetInfo info=bayonetService.updateByPrimaryKey(bayonet);
			if(info==null){
				return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,"卡口信息不存在");
			}
		}catch(Exception e){
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL);
		}
		addLog(request, "修改卡口信息成功", 2);
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,"更新卡口信息成功");
	}
}
