package com.tianyi.bph.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.common.SystemConfig;
import com.tianyi.bph.domain.system.GBOrgan;
import com.tianyi.bph.domain.system.OrganGBOrganKey;
import com.tianyi.bph.service.system.GBPlatFormService;

@Controller
@RequestMapping("/web/GBPlatForm")
public class GBPlatFormController {

	@Resource
	private GBPlatFormService service;

	// @RequestMapping("/toGBPlatForm.action")
	// public ModelAndView toGBPlatForm(HttpServletRequest request,
	// HttpSession session, @CookieValue("JSESSIONID") String sessionid) {
	// String username = (String) session.getAttribute("username");
	// System.out.println(username);
	// System.out.println(sessionid);
	//
	// MappingJacksonJsonView view = new MappingJacksonJsonView();
	// // return new ModelAndView(new RedirectView(request.getContextPath()
	// // + "/index.jsp"));
	//
	//
	//
	// Map attributes = new HashMap();
	// attributes.put("success", Boolean.TRUE);
	// attributes.put("contractNo", "contractNo");
	// view.setAttributesMap(attributes);
	// ModelAndView mv = new ModelAndView();
	// mv.setView(view);
	// return mv;
	// }

	/**
	 * 进入gb授权页面
	 * 
	 * @param request
	 * @param session
	 * @param organId
	 * @return
	 */
	@RequestMapping({"/toGBPlatForm.action","/toGBPlatForm.do"})
	public ModelAndView toGBPlatForm(HttpServletRequest request,
			HttpSession session,
			@RequestParam(value = "organId", required = false) Integer organId) {
		// 用户验证
		// String username = (String) session.getAttribute("username");
		// service.getOrganTree(organId);
		ModelAndView view = new ModelAndView("/base/gb/gbAuthorization.jsp");
		if (organId != null && organId != 0) {
			view.addObject("organId", organId);
		}
		view.addObject("num",SystemConfig.BASE_MANAGER);
		return view;
	}

	/**
	 * 获取国标机构数信息
	 * 
	 * @param request
	 * @param organId
	 * @return
	 */
	@RequestMapping("/getGBOrganList.do")
	@ResponseBody
	public ReturnResult getGBOrganList(HttpServletRequest request,
			@RequestParam(value = "organId") Integer organId) {
		try {
			GBOrgan organ = null;
			if (organId != null) {
				organ = service.getOrganTree(organId);
			}
			return ReturnResult.SUCCESS(organ);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnResult.FAILUER(e.getMessage());
		}
	}

	/**
	 * 机构 授权 国标机构
	 * 
	 * @param request
	 * @param organId
	 * @param GBOrganIds
	 * @return
	 */
	@RequestMapping("/addGBPermission.do")
	@ResponseBody
	public ReturnResult addGBPermission(
			HttpServletRequest request,
			@RequestParam(value = "organId", required = true) Integer organId,
			@RequestParam(value = "gbOrganIds", required = true) String GBOrganIds) {
		try {
			String[] ids = GBOrganIds.split(",");
			List<OrganGBOrganKey> list = null;
			if (ids.length > 0) {
				list = new ArrayList<OrganGBOrganKey>(ids.length);
				OrganGBOrganKey key = null;
				for (String id : ids) {
					key = new OrganGBOrganKey();
					key.setOrganId(organId);
					key.setGbOrganId(Integer.valueOf(id));
					list.add(key);
				}
				service.addGBPermission(organId, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnResult.FAILUER(e.getMessage());
		}
		request.setAttribute("organId", organId);
		return ReturnResult.SUCCESS();
	}
	//
	// public static void main(String[] args) {
	// List<Node> nodes = new ArrayList<Node>();
	// Node node11 = new Node();
	// node11.setId(2);
	// node11.setText("四川成都");
	// node11.setExpanded(true);
	// node11.setParentId(1);
	// nodes.add(node11);
	//
	// Node node111 = new Node();
	// node111.setId(3);
	// node111.setText("四川德阳");
	// node111.setParentId(1);
	// nodes.add(node111);
	//
	// Node node2 = new Node();
	// node2.setId(5);
	// node2.setText("index.html");
	// node2.setParentId(3);
	// node2.setExpanded(true);
	// nodes.add(node2);
	//
	// Node node1 = new Node();
	// node1.setId(1);
	// node1.setText("四川");
	// node1.setParentId(null);
	// nodes.add(node1);
	//
	// Node node12 = new Node();
	// node12.setId(4);
	// node12.setText("四川成都金牛");
	// node12.setParentId(2);
	// nodes.add(node12);
	// Tree tree = new Tree(nodes);
	//
	// // JSONObject ob=new JSONObject();
	// // ob.put("data", tree.buildTree());
	// System.out.println(JSONObject.fromObject(tree).toString());
	// }
}
