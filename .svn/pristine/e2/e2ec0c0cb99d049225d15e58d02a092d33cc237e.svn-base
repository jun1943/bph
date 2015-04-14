package com.tianyi.bph.web.controller.system;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.bph.common.Constants;
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.PageReturn;
import com.tianyi.bph.common.Pager;
import com.tianyi.bph.common.SystemConfig;
import com.tianyi.bph.dao.basicdata.PoliceMapper;
import com.tianyi.bph.domain.basicdata.Police;
import com.tianyi.bph.domain.system.CardPoint;
import com.tianyi.bph.domain.system.CardPointBean;
import com.tianyi.bph.domain.system.CardPointCamera;
import com.tianyi.bph.domain.system.CardPointHead;
import com.tianyi.bph.domain.system.CircleLayer;
import com.tianyi.bph.domain.system.GBDevice;
import com.tianyi.bph.query.system.CardPointQuery;
import com.tianyi.bph.service.basicdata.PoliceService;
import com.tianyi.bph.service.system.CardPointService;
import com.tianyi.bph.service.system.CircleLayerService;
import com.tianyi.bph.service.system.GBPlatFormService;
import com.tianyi.bph.common.ReturnResult;

/**
 * 卡点 管理
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/web/cardPoint")
public class CardPointController {

	static final Logger log = LoggerFactory.getLogger(CardPointController.class);

	@Autowired CardPointService cardPointService;
	@Autowired CircleLayerService circleLayerService;
	@Autowired GBPlatFormService gBPlatFormService;
	@Autowired PoliceService policeService;
	@Autowired PoliceMapper policeMapper;
	@Autowired CircleLayerService circleService;

	/**
	 * 添加卡点
	 * @param cardPoint
	 * @return
	 */
	@RequestMapping({"/addCardPoints.do","/addCardPoints.action"})
	@ResponseBody
	public ModelAndView addCardPoints(){
		ModelAndView  mv = new ModelAndView("/base/cardPoint/addCardPoints.jsp");
//		mv.addObject("organ", organ);
		return mv;
	}
	
	/**
	 * 卡点查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value="/queryCardPointList.do")
	@ResponseBody
	public PageReturn queryCardPointList(
		@RequestParam(value="name",required=false)String name,
		@RequestParam(value="organOrNext",required=true,defaultValue="1")Integer organOrNext,
		@RequestParam(value="path",required=true)String path,
		@RequestParam(value="params",required=false)String params,
		@RequestParam(value="pageSize",required=false,defaultValue="10")Integer pageSize,
		@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,
		@RequestParam(value="sessionId",required=false)String sessionId,
		HttpServletRequest request){
		
		CardPointQuery query = new CardPointQuery();
		if(!StringUtils.isEmpty(name)){
			query.setName(name);
		}
		query.setPath(path);
		query.setOrganOrNext(organOrNext);
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		
		List<CardPointBean> cardPointList = new ArrayList<CardPointBean>();
		List<CardPoint> cardPoints = cardPointService.getQueryList(query);
		if(cardPoints != null && cardPoints.size() > 0){
			CardPointBean bean = null;
			for(CardPoint cardPoint : cardPoints){
				bean = new CardPointBean();
				
				bean.setCardPointId(cardPoint.getCardPointId());
				bean.setName(cardPoint.getName());
				bean.setCircleLayerId(cardPoint.getCardPointId());
				bean.setIntercomGroupId(cardPoint.getIntercomGroupId());
				bean.setAssignment(cardPoint.getAssignment());
				
				// 卡点天网
				StringBuffer device = new StringBuffer();
				List<CardPointCamera> cameras = cardPointService.getCardPointCamera(cardPoint.getCardPointId());
				if(cameras != null && cameras.size() > 0){
					for(CardPointCamera camera : cameras){
						int id = camera.getCameraId();
						GBDevice d = gBPlatFormService.getGBDeviceById(id);
						if(d != null && d.getName() != null){
							device.append(d.getName()+",");
						}
					}
				}
				bean.setCamera(device.toString());
				
				int circleLayerId = cardPoint.getCircleLayerId(); //
				CircleLayer c = circleLayerService.getCircleLayerById(circleLayerId);
				if(c != null){
					bean.setCircleLayerName(c.getName());
				}
				cardPointList.add(bean);
			}
		}
		int totalRows = 0;
			totalRows = cardPoints.size();
			totalRows = cardPointService.getCount(query);
		return PageReturn.MESSAGE(MessageCode.STATUS_SUCESS,MessageCode.SELECT_SUCCESS,totalRows,cardPointList);
	}
	
	/**
	 * 添加卡点
	 * @param cardPoint
	 * @return
	 */
	@RequestMapping({"/addCardPoint.do","/addCardPoint.action"})
	@ResponseBody
	public ReturnResult addCardPoint(
			@RequestParam(value="organId",required=true)Integer organId,		//机构id
			@RequestParam(value="name",required=true)String name,				//卡点名称
			@RequestParam(value="manager",required=false)String manager,		//卡点负责人
			@RequestParam(value="telephone",required=false)String telephone,	//联系电话
			@RequestParam(value="intercomGroupId",required=false)Integer intercomGroupId,	//对讲机组号
			@RequestParam(value="equipment",required=false)String equipment,	//携行装备
			@RequestParam(value="policeNote",required=false)String policeNote,	//警力描述
			@RequestParam(value="assignment",required=false)String assignment,	//职责
			@RequestParam(value="camera",required=false)String camera,		//关联天网
			@RequestParam(value="latitude",required=false)String latitude,		//经度
			@RequestParam(value="longitude",required=false)String longitude,	//纬度
			@RequestParam(value="circleLayer",required=true)Integer circleLayer,//所属圈层
			@RequestParam(value="iconId",required=false)Integer iconId,			//图标编号
			@RequestParam(value="sessionId",required=false)String sessionId,
			HttpServletRequest request) {
		
		if("".equals(name)){
			return ReturnResult.FAILUER("卡点名称不能为空");
		}
		
		CardPoint cardPoint = new CardPoint();
		cardPoint.setOrganId(organId);
		cardPoint.setName(name);
		cardPoint.setTelephone(telephone);
		if(intercomGroupId != null){
			cardPoint.setIntercomGroupId(intercomGroupId);
		}
		cardPoint.setEquipment(equipment);
		cardPoint.setPoliceNote(policeNote);
		cardPoint.setAssignment(assignment);
		cardPoint.setLatitude(latitude);
		cardPoint.setLongitude(longitude);
		cardPoint.setCircleLayerId(circleLayer);
		if(iconId != null){
			cardPoint.setIconId(iconId);
		}
		CardPoint c = cardPointService.addCardPoint(cardPoint);
		if(c == null){
			return ReturnResult.FAILUER("卡点名称重复");
		}else{
			//卡点负责人
			if(manager != null && !"".equals(manager)){
				String[] ids = manager.split(",");	
				if(ids.length > 0){
					CardPointHead cardPointHead = null;
					for(int i=0; i<ids.length; i++){
						String id = ids[i];
						cardPointHead = new CardPointHead();
						cardPointHead.setCardPointId(c.getCardPointId());
						cardPointHead.setPoliceId(Integer.parseInt(id));
						cardPointService.addCardPointHead(cardPointHead);
					}
				}
			}
			
			//关联天网
			if(camera != null && !"".equals(camera)){
				String[] cameraIds = camera.split(",");
				if(cameraIds.length > 0){
					CardPointCamera cardCamera = null;
					for(int i=0; i<cameraIds.length; i++){
						String cameraId = cameraIds[i];
						cardCamera = new CardPointCamera();
						cardCamera.setCardPointId(c.getCardPointId());
						cardCamera.setCameraId(Integer.parseInt(cameraId));
						cardPointService.addCardPointCamera(cardCamera);
					}
				}
			}
		}
		return ReturnResult.SUCCESS();
	}
	
	/**
	 * 删除卡点
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping({"/deleteCardPoint.do","/deleteCardPoint.action"})
	@ResponseBody
	public ReturnResult deleteCardPoint(
			@RequestParam(value="sessionId",required=false)String sessionId,
			@RequestParam(value = "id", required =true) Integer id) {
		int i = cardPointService.deleteCardPoint(id);
		return ReturnResult.SUCCESS("", i);
	}
	
	/**
	 * 客户端 修改卡点信息
	 * @param CardPoint
	 * @return
	 */
	@RequestMapping(value = "/modifyCardPoints.do")
	@ResponseBody
	public ReturnResult modifyCardPoint(CardPoint cardPoint) {
		CardPoint c = cardPointService.updateCardPoint(cardPoint);
		return ReturnResult.SUCCESS("成功", c);
	}
	
	/**
	 * 修改卡点
	 * @param CardPoint
	 * @return
	 */
	@RequestMapping({"/modifyCardPoint.do","/modifyCardPoint.action"})
	@ResponseBody
	public ReturnResult modifyCardPoint(
			@RequestParam(value="cardPointId",required=true)Integer cardPointId,
			@RequestParam(value="organId",required=true)Integer organId,		//机构id
			@RequestParam(value="name",required=true)String name,				//卡点名称
			@RequestParam(value="manager",required=false)String manager,		//卡点负责人
			@RequestParam(value="telephone",required=false)String telephone,	//联系电话
			@RequestParam(value="intercomGroupId",required=false)Integer intercomGroupId,	//对讲机组号
			@RequestParam(value="equipment",required=false)String equipment,	//携行装备
			@RequestParam(value="policeNote",required=false)String policeNote,	//警力描述
			@RequestParam(value="assignment",required=false)String assignment,	//职责
			@RequestParam(value="camera",required=false)String camera,	//关联天网
			@RequestParam(value="latitude",required=false)String latitude,		//经度
			@RequestParam(value="longitude",required=false)String longitude,	//纬度
			@RequestParam(value="circleLayer",required=true)Integer circleLayer,//所属圈层
			@RequestParam(value="iconId",required=false)Integer iconId,			//图标编号
			@RequestParam(value="sessionId",required=false)String sessionId,
			HttpServletRequest request) {
		try{
			CardPoint cardPoint = new CardPoint();
			cardPoint.setCardPointId(cardPointId);
			if(organId != null){
				cardPoint.setOrganId(organId);
			}
			cardPoint.setName(name);
			
			//卡点负责人
			if(manager != null && !"".equals(manager)){
				String[] policeIds = manager.split(",");
				if(policeIds != null && policeIds.length > 0){
					cardPointService.deleteCardPointHead(cardPointId);
					CardPointHead cardPointHead = null;
					for(int i=0; i<policeIds.length; i++){
						String id = policeIds[i];
						cardPointHead = new CardPointHead();
						cardPointHead.setCardPointId(cardPointId);
						if(!"".equals(id)){
							cardPointHead.setPoliceId(Integer.parseInt(id));
						}
						cardPointService.addCardPointHead(cardPointHead);
					}
				}
			}
			//卡点天网
			if(camera != null && !"".equals(camera)){
				String[] cameras = camera.split(",");
				if(cameras != null && cameras.length > 0){
					cardPointService.deleteCardPointCamera(cardPointId);
					CardPointCamera cardPointCamera = null;
					for(int i=0; i<cameras.length; i++){
						String id = cameras[i];
						cardPointCamera = new CardPointCamera();
						cardPointCamera.setCardPointId(cardPointId);
						if(!"".equals(id)){
							cardPointCamera.setCameraId(Integer.parseInt(id));
						}
						cardPointService.addCardPointCamera(cardPointCamera);
					}
				}
			}
			cardPoint.setTelephone(telephone);
			cardPoint.setIntercomGroupId(intercomGroupId);
			cardPoint.setEquipment(equipment);
			cardPoint.setPoliceNote(policeNote);
			cardPoint.setAssignment(assignment);
			cardPoint.setLatitude(latitude);
			cardPoint.setLongitude(longitude);
			cardPoint.setCircleLayerId(circleLayer);
			if(iconId != null){
				cardPoint.setIconId(iconId);
			}
			CardPoint c = cardPointService.updateCardPoint(cardPoint);
			if(c == null){
				return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,MessageCode.UPDATE_CARDPOINT_FAIL);
			}
		}catch(Exception e){
			log.debug(e.getMessage());
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,MessageCode.UPDATE_CARDPOINT_FAIL);
		}
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS, MessageCode.UPDATE_CARDPOINT_SUCCESS);
	
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@RequestMapping({"/queryCardPointDetail.do","/queryCardPointDetail.action"})
	@ResponseBody
	public ModelAndView queryCardPointDetail(
			@RequestParam(value="sessionId",required=false)String sessionId,
			@RequestParam(value = "id", required =true) Integer id) {
		ModelAndView mv=new ModelAndView("/base/cardPoint/cardPointDetail.jsp");
		CardPoint cardPoint = cardPointService.getCardPointById(id);
		mv.addObject("cardPoint", cardPoint);
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@RequestMapping({"/queryCardPointDetailById.do"})
	@ResponseBody
	public ReturnResult queryCardPointDetailById(
			@RequestParam(value="sessionId",required=false)String sessionId,
			@RequestParam(value = "id", required =true) Integer id) {
		CardPoint cardPoint = cardPointService.getCardPointById(id);
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,"查询成功",cardPoint);
	}
	
	/**
	 * 卡点列表展示(分页查询)
	 * @param cardPointQuery
	 * @return
	 */
	@RequestMapping({"/queryCardPointPageList.do","/queryCardPointPageList.action"})
	@ResponseBody
	public ModelAndView queryCardPointPageList(
			@RequestParam(value="id",required=false)Integer id,
			@RequestParam(value="code",required=false)String code,
			@RequestParam(value="pageSize",required=false,defaultValue="10")Integer pageSize,
			@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,
			@RequestParam(value="sessionId",required=false)String sessionId,
			HttpServletRequest request){//CardPointQuery cardPointQuery
		
		CardPointQuery cardPointQuery = new CardPointQuery();
		cardPointQuery.setId(id);
		cardPointQuery.setPageSize(pageSize);
		cardPointQuery.setPageNo(pageNo);
		
		ModelAndView  mv=new ModelAndView("/base/cardPoint/cardPointList.jsp");
		List<CardPoint> pager = cardPointService.getQueryList(cardPointQuery);
		mv.addObject("pager",pager);
		mv.addObject("num",SystemConfig.BASE_MANAGER);
		return mv;
	}
	
	/**
	 * 卡点列表展示(分页查询)
	 * @param cardPointQuery
	 * @return
	 */
	@RequestMapping({"/queryCardPointPageList2.do","/queryCardPointPageList2.action"})
	@ResponseBody
	public ReturnResult queryCardPointPageList2(
			@RequestParam(value="path",required=false)String path,
			@RequestParam(value="name",required=false)String name,
			@RequestParam(value="code",required=false)String code,
			@RequestParam(value="organOrNext",required=true,defaultValue="1")Integer organOrNext,
			@RequestParam(value="pageSize",required=false,defaultValue="10")Integer pageSize,
			@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,
			@RequestParam(value="sessionId",required=false)String sessionId,
			HttpServletRequest request){
		
		CardPointQuery cardPointQuery = new CardPointQuery();
		cardPointQuery.setPath(path);
		cardPointQuery.setName(name);
		cardPointQuery.setOrganOrNext(organOrNext);
		cardPointQuery.setPageSize(pageSize);
		cardPointQuery.setPageNo(pageNo);
		
		Pager<CardPoint> cardPointList = cardPointService.getPageList(cardPointQuery);
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,"查询成功",cardPointList);
	}
	
	@RequestMapping({"/queryCardPointTotal.do","/queryCardPointTotal.action"})
	@ResponseBody
	public ReturnResult queryCardPointTotal(){
		int total = cardPointService.queryCardPointTotal();
		return ReturnResult.SUCCESS("", total);
	}
	
	/**
	 * 跳转编辑页面
	 * @param request
	 * @param cardPointId
	 * @return
	 */
	@RequestMapping({"/gotoCardPointEdit.do","/gotoCardPointEdit.action"})
	@ResponseBody
	public ModelAndView gotoCardPointEdit(HttpServletRequest request,
			@RequestParam(value="sessionId",required=false)String sessionId,
			@RequestParam(value = "cardPointId", required =false) Integer cardPointId){
		CardPoint cardPoints = null;
		if(cardPointId != null){
			cardPoints = cardPointService.getCardPointById(cardPointId);
		}
		CardPointBean cardPoint = new CardPointBean();
		cardPoint.setAltitude(cardPoints.getAltitude());
		cardPoint.setAngle(cardPoints.getAngle());
		cardPoint.setAssignment(cardPoints.getAssignment());
		cardPoint.setCardPointId(cardPoints.getCardPointId());
		cardPoint.setCircleLayerId(cardPoints.getCircleLayerId());
		
		CircleLayer c = circleService.getCircleLayerById(cardPoints.getCircleLayerId());
		if(c != null){
			cardPoint.setCircleLayerName(c.getName());
		}
		cardPoint.setEquipment(cardPoints.getEquipment());
		cardPoint.setIconId(cardPoints.getIconId());
		cardPoint.setIntercomGroupId(cardPoints.getIntercomGroupId());
		cardPoint.setLatitude(cardPoints.getLatitude());
		cardPoint.setLongitude(cardPoints.getLongitude());
		cardPoint.setName(cardPoints.getName());
		cardPoint.setOrganId(cardPoints.getOrganId());
		cardPoint.setPoliceNote(cardPoints.getPoliceNote());
		cardPoint.setTelephone(cardPoints.getTelephone());
		cardPoint.setType(cardPoints.getType());
		
		/*卡点负责人*/
		StringBuffer policeName = null;
		StringBuffer policeId = null;
		List<CardPointHead> polices = cardPointService.getCardPointHead(cardPointId);
		if(polices != null && polices.size() > 0){
			policeName = new StringBuffer();
			policeId = new StringBuffer();
			for(CardPointHead police : polices){
				Police p = policeMapper.selectByPrimaryKey(police.getPoliceId()); 
				policeName.append(p.getName()+",");
				policeId.append(police.getPoliceId()+",");
			}
			cardPoint.setManager(policeId.toString());
			cardPoint.setManagerName(policeName.toString());
		}
		
		/*卡点天网*/
		StringBuffer cameraName = null;
		StringBuffer cameraId = null;
		List<CardPointCamera> cameras = cardPointService.getCardPointCamera(cardPointId);
		if(cameras != null && cameras.size() > 0){
			cameraName = new StringBuffer();
			cameraId = new StringBuffer();
			for(CardPointCamera camera : cameras){
				GBDevice g = gBPlatFormService.getGBDeviceById(camera.getCameraId());
				cameraId.append(camera.getCardPointId() + ",");
				if(g != null && g.getName() != null){
					cameraName.append(g.getName() + ",");
				}
			}
			cardPoint.setCamera(cameraId.toString());
			cardPoint.setCameraName(cameraName.toString());
		}
		
		List<Police> policeList = policeService.getPoliceInfo(cardPoints.getOrganId(),Constants.SEARCH_TYPE_NO_CHILD);
		ModelAndView  mv=new ModelAndView("/base/cardPoint/modifyCardPoint.jsp");
		mv.addObject("policeList",policeList);	
		mv.addObject("cardPoint", cardPoint);		
		List<GBDevice> cameraList = gBPlatFormService.getGBDeviceListByOrganId(cardPoints.getOrganId());
		mv.addObject("cameraList",cameraList);	//天网
		
		List<CircleLayer> circleList = circleService.getCircleLayerList();
		mv.addObject("circleList", circleList);
		return mv;
	}
	
	/**
	 * 跳转添加页面
	 * @param request
	 * @param organId
	 * @return
	 */
	@RequestMapping({"/gotoCardPointAdd.do","/gotoCardPointAdd.action"})
	@ResponseBody
	public ModelAndView gotoCardPointAdd(HttpServletRequest request,
			@RequestParam(value="sessionId",required=false)String sessionId,
			@RequestParam(value = "organId", required =false) Integer organId){
		
		ModelAndView  mv=new ModelAndView("/base/cardPoint/addCardPoints.jsp");
		List<Police> policeList = policeService.getPoliceInfo(organId,Constants.SEARCH_TYPE_NO_CHILD);
		List<GBDevice> cameraList = gBPlatFormService.getGBDeviceListByOrganId(organId);
		mv.addObject("organId", organId);
		mv.addObject("policeList",policeList);	//警员
		mv.addObject("cameraList",cameraList);	//天网
		
		List<CircleLayer> circleList = circleService.getCircleLayerList();
		mv.addObject("circleList", circleList);
		return mv;
	}
	
	/**
	 * @ goto圈层设置页面
	 * @return
	 */
	@RequestMapping({"/gotoCircleLayer.do","/gotoCircleLayer.action"})
	@ResponseBody
	public ModelAndView gotoCircleLayer(@RequestParam(value="organId",required=false) String organId,
			@RequestParam(value="sessionId",required=false)String sessionId,
			HttpServletRequest request){
		
		ModelAndView  mv=new ModelAndView("/base/cardPoint/circleLayer.jsp");
		List<CircleLayer> circleList = circleService.getCircleLayerList();
		mv.addObject("circleList", circleList);
		return mv;
	}
	
	/**
	 * 添加圈层
	 * @param cardPoint
	 * @return
	 */
	@RequestMapping({"/addCircleLayer.do","/addCircleLayer.action"})
	@ResponseBody
	public ReturnResult addCircleLayer(@RequestParam(value="name",required=true)String name,
			@RequestParam(value="sessionId",required=false)String sessionId,
			HttpServletRequest request) {
		CircleLayer circle = new CircleLayer();
		circle.setName(name);
		circleService.addCircleLayer(circle);
		return ReturnResult.SUCCESS();
	}
	
	
	/**
	 * 圈层查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value="/queryCircleList.do")
	@ResponseBody
	public ReturnResult queryCircleList(@RequestParam(value="sessionId",required=false)String sessionId,
			HttpServletRequest request){
		List<CircleLayer> circleList = circleService.getCircleLayerList();
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,MessageCode.SELECT_SUCCESS,circleList);
	}
	
	/**
	 * 删除圈层
	 * @param id
	 * @return
	 */
	@RequestMapping({"/deleteCircle.do","/deleteCircle.action"})
	@ResponseBody
	public ReturnResult deleteCircle(@RequestParam(value = "id", required =true) Integer id) {
		int i = circleService.deleteCircleLayer(id);
		return ReturnResult.SUCCESS("", i);
	}
	
	/**
	 * 修改卡点坐标
	 * @param CardPoint
	 * @return
	 */
	@RequestMapping({"/modifyCardPointCoordinate.do","/modifyCardPointCoordinate.action"})
	@ResponseBody
	public ReturnResult modifyCardPointCoordinate(
			@RequestParam(value="cardPointId",required=true)Integer cardPointId,
			@RequestParam(value="latitude",required=true)String latitude,		//经度
			@RequestParam(value="longitude",required=true)String longitude,	//纬度
			HttpServletRequest request) {
		
		CardPoint c = new CardPoint();
		c.setCardPointId(cardPointId);
		c.setLatitude(latitude);
		c.setLongitude(longitude);
		int i = cardPointService.modifyCardPointCoordinate(c);
		if(i > 0){
			return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS, MessageCode.UPDATE_CARDPOINT_SUCCESS);
		}else{
			return ReturnResult.MESSAGE(MessageCode.STATUS_FAIL,MessageCode.UPDATE_CARDPOINT_FAIL);
		}
	}
}
