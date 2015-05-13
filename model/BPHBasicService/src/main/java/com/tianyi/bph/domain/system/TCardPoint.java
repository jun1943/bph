package com.tianyi.bph.domain.system;

import java.util.Date;
import java.util.Set;

/**
 * 卡点机动组 信息表
 * 
 * @author Administrator
 * 
 */
public class TCardPoint {
	private Integer id;

	private String name;// 卡点机动组名字

	private String communityGroupNum;// 组呼号

	private Integer layersId;// 圈层id

	private Integer peoplePoliceCount;// 民警数量

	private Integer trafficPoliceCount;// 交警数量

	private Integer armsPoliceCount;// 武警数量

	private String assignment;// 责任，职责人

	private Integer cardType;// 类型 1卡点 2机动组

	private Double longitude;// 经度 精确到米

	private Double latitude;// 纬度 精确到米

	private Integer iconId;// Icon_id 图标id

	private Boolean mark;// 是否标注

	private Integer organId;// 机构id

	private String equip;// 武器

	private String tel;

	private Date createTime;

	private Set<Integer> policeUsers;// 关联警员

	private Set<Integer> cameras;// 关联天网设备

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommunityGroupNum() {
		return communityGroupNum;
	}

	public void setCommunityGroupNum(String communityGroupNum) {
		this.communityGroupNum = communityGroupNum;
	}

	public Integer getLayersId() {
		return layersId;
	}

	public void setLayersId(Integer layersId) {
		this.layersId = layersId;
	}

	public Integer getPeoplePoliceCount() {
		return peoplePoliceCount;
	}

	public void setPeoplePoliceCount(Integer peoplePoliceCount) {
		this.peoplePoliceCount = peoplePoliceCount;
	}

	public Integer getTrafficPoliceCount() {
		return trafficPoliceCount;
	}

	public void setTrafficPoliceCount(Integer trafficPoliceCount) {
		this.trafficPoliceCount = trafficPoliceCount;
	}

	public Integer getArmsPoliceCount() {
		return armsPoliceCount;
	}

	public void setArmsPoliceCount(Integer armsPoliceCount) {
		this.armsPoliceCount = armsPoliceCount;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getIconId() {
		return iconId;
	}

	public void setIconId(Integer iconId) {
		this.iconId = iconId;
	}

	public Boolean getMark() {
		return mark;
	}

	public void setMark(Boolean mark) {
		this.mark = mark;
	}

	public Integer getOrganId() {
		return organId;
	}

	public void setOrganId(Integer organId) {
		this.organId = organId;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	public Set<Integer> getPoliceUsers() {
		return policeUsers;
	}

	public void setPoliceUsers(Set<Integer> policeUsers) {
		this.policeUsers = policeUsers;
	}

	public Set<Integer> getCameras() {
		return cameras;
	}

	public void setCameras(Set<Integer> cameras) {
		this.cameras = cameras;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}