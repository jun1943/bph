package com.tianyi.bph.query.duty;

import com.tianyi.bph.domain.duty.PoliceGroup;
 
/**
 * 警员分组model类，继承警员分组实体类，用于前台显示使用
 * @author lq
 */
public class PoliceGroupVM extends PoliceGroup{
	/**
	 * 组织结构名称
	 */
	private String orgName;
	/**
	 * 组织机构编码
	 */
	private String orgCode;
	/**
	 * 组织机构路径
	 */
	private String orgPath;
	/**
	 * 是否共享到下级
	 */
	private String shareTypeDesc;
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgPath() {
		return orgPath;
	}
	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}
	public String getShareTypeDesc() {
		
		switch(this.getShareType())
		{
		case 0:
			this.shareTypeDesc="不共享";
			break;
		case 1:
			this.shareTypeDesc="共享到下级";
			break;
		}

		return shareTypeDesc;
	}
	public void setShareTypeDesc(String shareTypeDesc) {
		this.shareTypeDesc = shareTypeDesc;
	}
	
	
}
