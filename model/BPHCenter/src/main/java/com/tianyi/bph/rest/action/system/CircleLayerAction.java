package com.tianyi.bph.rest.action.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.domain.system.Area;
import com.tianyi.bph.domain.system.CircleLayer;
import com.tianyi.bph.service.system.CircleLayerService;
import com.tianyi.bph.vo.AreaVO;
import com.tianyi.bph.vo.CircleLayerVo;
import com.tianyi.bph.common.JsonUtils;
import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.ReturnResult;

/**
 * 圈层
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/circleLayer")
public class CircleLayerAction {

	static final Logger log = LoggerFactory.getLogger(CircleLayerAction.class);

	@Autowired CircleLayerService circleLayerService;
	
	/**
	 * 修改圈层信息
	 * @param CircleLayer
	 * @return
	 */
	@RequestMapping(value = "/modifyCircleLayer.do", method = RequestMethod.POST)
	@ResponseBody
	public ReturnResult modifyCircleLayer(@RequestBody String body) {
		try {
			CircleLayerVo circleLayer = JsonUtils.toObj(body, CircleLayerVo.class);
			CircleLayer c = circleLayer.ctrate();
			return ReturnResult.SUCCESS("成功", circleLayerService.updateCircleLayer(c));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ReturnResult.FAILUER(e.getMessage());
		}
	}
//	{"id":1,"name":"第一圈层","note":"note",
//	"displayProperty":{"name":"第一圈层","borderColor":"#FFFF0000","borderOpacity":0.9,"fillColor":"#FF0000FF","fillOpacity":0.3,"x":104.07827086503026,"y":30.685495544193131},
//	"mapProperty":[{"x":3231.4724061476777,"y":1680.2612377672267},{"x":3232.7536561476777,"y":1680.1635815172267},{"x":3232.9099061476777,"y":1681.3354565172267},{"x":3231.5231873976777,"y":1681.6245190172267},{"x":3231.5231873976777,"y":1681.6245190172267}]}

	
	/**
	 * 圈层查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value="/queryCircleLayerList.do")
	@ResponseBody
	public ReturnResult getCircleLayerList(HttpServletRequest request){
		
		List<CircleLayer> list = circleLayerService.getCircleLayerList();
		
		List<CircleLayerVo> reList = null;
		if (!list.isEmpty()) {
			reList = new ArrayList<CircleLayerVo>(list.size());
			for (CircleLayer circleLayer : list) {
				reList.add(new CircleLayerVo(circleLayer));
			}
		}
		
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS,MessageCode.SELECT_SUCCESS,reList);
	}

	
	public static void main(String[] args) {
//		String body="{\"id\":1,\"name\":\"第一圈层\",\"note\":\"note\",\"displayProperty\":{\"name\":\"第一圈层\",\"borderColor\":\"#FFFF0000\",\"borderOpacity\":0.9,\"fillColor\":\"#FF0000FF\",\"fillOpacity\":0.3,\"x\":104.07827086503026,\"y\":30.685495544193131},\"mapProperty\":[{\"x\":3231.4724061476777,\"y\":1680.2612377672267},{\"x\":3232.7536561476777,\"y\":1680.1635815172267},{\"x\":3232.9099061476777,\"y\":1681.3354565172267},{\"x\":3231.5231873976777,\"y\":1681.6245190172267},{\"x\":3231.5231873976777,\"y\":1681.6245190172267}]}";
//	
//		CircleLayerVo circleLayer = JsonUtils.toObj(body, CircleLayerVo.class);
//		System.out.println(circleLayer);
	}
}
