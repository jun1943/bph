package com.tianyi.bph.web.controller.dutydata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyi.bph.common.MessageCode;
import com.tianyi.bph.common.ReturnResult;
import com.tianyi.bph.query.duty.DutyCalendarVM;
import com.tianyi.bph.query.duty.DutyItemCountVM;
import com.tianyi.bph.service.duty.DutyService; 
import com.tianyi.bph.service.duty.DutyTypeService;
import com.tianyi.bph.service.system.OrganService;

@Controller
@RequestMapping("/dutyCalendarWeb")
public class DutyCalenderController {

	@Autowired
	private OrganService organService;

	@Autowired
	private DutyService dutyService; 
  
	@Autowired
	private DutyTypeService dutyTypeService;
	
	@RequestMapping(value = "/getCalender.do")
	public @ResponseBody
	ReturnResult getCalender(
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "orgId", required = false) Integer orgId,
			HttpServletRequest request) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(date);
		Calendar c = Calendar.getInstance();

		c.setTime(d);
		int totalDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		List<DutyCalendarVM> objList = new ArrayList<DutyCalendarVM>();
		for (int i = 1; i <= totalDays; i++) {
			DutyCalendarVM dcvm = new DutyCalendarVM();
			c.set(Calendar.DAY_OF_MONTH, i);
			Date dates = c.getTime();
			Calendar cld = Calendar.getInstance();
			cld.setTime(dates);
			int year = cld.get(Calendar.YEAR);
			int month = cld.get(Calendar.MONTH) + 1; 
			String dt = "";
			String dtMonth = "";
			if (month < 10) {
				dtMonth = "-0" + month;
			} else {
				dtMonth = "-" + month;
			}
			if (i < 10) {
				dt = year + dtMonth + "-0" + i;
			} else {
				dt = year + dtMonth + "-" + i;
			}
			dcvm.setTitle(getTotalPolice(dt, orgId));
			dcvm.setStart(dt);
			dcvm.setUrl("javascript:selectDateToDuty('"+dt+"');");
			objList.add(dcvm);
		} 
		return ReturnResult.MESSAGE(MessageCode.STATUS_SUCESS, MessageCode.SELECT_ORGAN_FAIL, objList);
	}

	private String getTotalPolice(String date, Integer orgId) {
		// TODO Auto-generated method stub
		try {
			int dt = 0;
			String dates = date.replace("-", "");
			dt = Integer.parseInt(dates);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ymd", dt);
			map.put("orgId", orgId);
			List<DutyItemCountVM> list = new ArrayList<DutyItemCountVM>();
			list = dutyTypeService.loadDutyItemCount(map);
			String result = "";
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getItemTypeName().equals("警员")) {
						result += list.get(i).getorgName() + "人";
					} else if (list.get(i).getItemTypeName().equals("车辆")) {
						result += list.get(i).getorgName() + "车";
					} else if (list.get(i).getItemTypeName().equals("武器")) {
						result += list.get(i).getorgName() + "武器";
					}
				}
			} else {
				result = "无报备";
				// +
				// "<li class='baoBeiBtn'><div class='pasteBtnBox' onclick='selectPasteBox(this,'"+date+"')' style='display: none;'><a href='javascript:void(0);'>粘贴</a></div>"
				// + "<a href='javascript:void(0);'>粘贴</a>"
				// + "</div></li>";
				// result = "无报备";
			}
			return result;
		} catch (Exception ex) {
			return " 获取报备警力发生错误 ";
		}
	}
}
