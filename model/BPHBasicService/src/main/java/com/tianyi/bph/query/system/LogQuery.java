package com.tianyi.bph.query.system;

import java.util.Date;

import com.tianyi.bph.query.BaseQuery;

public class LogQuery extends BaseQuery {
	private Date startTime;
	private Date endTime;
	
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	private Integer logTypeId;
	public Integer getLogTypeId() {
		return logTypeId;
	}
	public void setLogTypeId(Integer logTypeId) {
		this.logTypeId = logTypeId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
