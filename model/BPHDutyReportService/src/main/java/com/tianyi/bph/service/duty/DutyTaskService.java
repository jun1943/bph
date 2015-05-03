package com.tianyi.bph.service.duty;

import java.util.List;

import com.tianyi.bph.domain.duty.Org;
import com.tianyi.bph.domain.system.Organ;
import com.tianyi.bph.query.duty.TaskTargetVM;
 

/**
 * 勤务报备，关联任务列表获取
 * @author lq
 *
 */
public interface DutyTaskService {
	/**
	 * 根据任务类型，组织机构，获取报备任务列表
	 * @param taskType
	 * @param org
	 * @return
	 */
	List<TaskTargetVM>  loadTaskTargetVMList(Integer taskType,Organ org);
}
