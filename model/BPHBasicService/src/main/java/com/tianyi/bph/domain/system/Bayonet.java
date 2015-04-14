package com.tianyi.bph.domain.system;

import java.util.Date;

/**
 * 
* @Title: Bayonet.java
* @Package com.tianyi.bph.domain.base
* @Description: TODO(卡口实体类)
* @author wangxing  
* @date 2015年2月3日 上午9:20:47
* @version V1.0
 */
public class Bayonet {
	
	private Integer id;// 卡口id
	
	private String bayonetName;// 卡口名称
	
	private String bayonetCode;// 卡口编码
	
	private String bayonetDirection; //卡口方向
	
	private Date createTime;// 创建时间
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBayonetName() {
		return bayonetName;
	}

	public void setBayonetName(String bayonetName) {
		this.bayonetName = bayonetName;
	}

	public String getBayonetCode() {
		return bayonetCode;
	}

	public void setBayonetCode(String bayonetCode) {
		this.bayonetCode = bayonetCode;
	}

	public String getBayonetDirection() {
		return bayonetDirection;
	}

	public void setBayonetDirection(String bayonetDirection) {
		this.bayonetDirection = bayonetDirection;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDirectionNo() {
		return directionNo;
	}

	public void setDirectionNo(String directionNo) {
		this.directionNo = directionNo;
	}

	public String getDirectionType() {
		return directionType;
	}

	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}

	public String getDirectionDescribe() {
		return directionDescribe;
	}

	public void setDirectionDescribe(String directionDescribe) {
		this.directionDescribe = directionDescribe;
	}

	public String getLaneDirection() {
		return laneDirection;
	}

	public void setLaneDirection(String laneDirection) {
		this.laneDirection = laneDirection;
	}

	public String getLaneName() {
		return laneName;
	}

	public void setLaneName(String laneName) {
		this.laneName = laneName;
	}

	public Integer getOrganId() {
		return organId;
	}

	public void setOrganId(Integer organId) {
		this.organId = organId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	public Integer getBayonetTypeCode() {
		return bayonetTypeCode;
	}

	public void setBayonetTypeCode(Integer bayonetTypeCode) {
		this.bayonetTypeCode = bayonetTypeCode;
	}

	public String getBayonetTypeName() {
		return bayonetTypeName;
	}

	public void setBayonetTypeName(String bayonetTypeName) {
		this.bayonetTypeName = bayonetTypeName;
	}

	public String getIconCode() {
		return iconCode;
	}

	public void setIconCode(String iconCode) {
		this.iconCode = iconCode;
	}

	private String directionNo; // 方向编号
	
	private String directionType; //方向类型
	
	private String directionDescribe; //方向描述
	
	private String laneDirection; // 车道方向
	
	private String laneName; // 车道名称
	
	private Integer organId; // 机构id
	
	private String longitude; // 经度坐标
	
	private String latitude; // 纬度坐标
	
	private Integer state; // 状态
	
	private Integer bayonetTypeCode; // 卡口类型id
	
	private String bayonetTypeName; //卡口类型名称
	
	private String iconCode; // 卡口图标
}
