package com.tianyi.bph.dao.duty;

import java.util.List;
import java.util.Map;

import com.tianyi.bph.dao.MyBatisRepository;
import com.tianyi.bph.query.duty.DutyReportVM;
 

/**
 * 勤务综合查询映射类
 * @author lq
 *
 */
@MyBatisRepository
public interface DutyReportMapper {
	/**
	 * 获取勤务报备统计数据
	 * @param map
	 * @return
	 */
	List<DutyReportVM> loadDutyReport(Map<String,Object> map);
}
