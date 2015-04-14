package com.tianyi.bph.domain.system;

import java.util.Date;

/**
 * 卡点
 * 
 * @author Administrator
 *
 */
public class CardPoint {
	
	private int cardPointId;		//卡点id
	private int circleLayerId;	//所属圈层 +
	private String name;			//名称
	private int organId;			//责任机构
	private int type;				//类型
	private String angle;			//角度
	private String telephone;	//电话 +
	private int intercomGroupId;	//对讲机组号
	private String latitude;		//纬度
	private String longitude;		//经度
	private String altitude;	//海拔高度+
	private String assignment;		//职责
	private String policeNote;	//警力描述+
	private String equipment;	//携行装备+
	private int iconId;			//图标编号+
	private Date createTime;		//创建时间
	private Date updateTime;		//更新时间
	
	/*private int respPoliceId;		//责任人
	private int circleLayer;		//所属圈层
	private int isstation;			//是否驻扎
	private int armsPoliceCount;	//武警数量
	private int peoplePoliceCount;	//民警数量
	private int trafficPoliceCount;	//交警数量
	private int policeTotal;		//警力数量
	private int isDisplayPatlabor;	//是否显示机动警察*/	
	
	public int getCircleLayerId() {
		return circleLayerId;
	}
	public void setCircleLayerId(int circleLayerId) {
		this.circleLayerId = circleLayerId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getPoliceNote() {
		return policeNote;
	}
	public void setPoliceNote(String policeNote) {
		this.policeNote = policeNote;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public int getIconId() {
		return iconId;
	}
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
	public int getCardPointId() {
		return cardPointId;
	}
	public void setCardPointId(int cardPointId) {
		this.cardPointId = cardPointId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrganId() {
		return organId;
	}
	public void setOrganId(int organId) {
		this.organId = organId;
	}
//	public int getRespPoliceId() {
//		return respPoliceId;
//	}
//	public void setRespPoliceId(int respPoliceId) {
//		this.respPoliceId = respPoliceId;
//	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAngle() {
		return angle;
	}
	public void setAngle(String angle) {
		this.angle = angle;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
//	public int getCircleLayer() {
//		return circleLayer;
//	}
//	public void setCircleLayer(int circleLayer) {
//		this.circleLayer = circleLayer;
//	}
	public int getIntercomGroupId() {
		return intercomGroupId;
	}
	public void setIntercomGroupId(int intercomGroupId) {
		this.intercomGroupId = intercomGroupId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
//	public int getIsstation() {
//		return isstation;
//	}
//	public void setIsstation(int isstation) {
//		this.isstation = isstation;
//	}
//	public int getArmsPoliceCount() {
//		return armsPoliceCount;
//	}
//	public void setArmsPoliceCount(int armsPoliceCount) {
//		this.armsPoliceCount = armsPoliceCount;
//	}
//	public int getPeoplePoliceCount() {
//		return peoplePoliceCount;
//	}
//	public void setPeoplePoliceCount(int peoplePoliceCount) {
//		this.peoplePoliceCount = peoplePoliceCount;
//	}
//	public int getTrafficPoliceCount() {
//		return trafficPoliceCount;
//	}
//	public void setTrafficPoliceCount(int trafficPoliceCount) {
//		this.trafficPoliceCount = trafficPoliceCount;
//	}
//	public int getPoliceTotal() {
//		return policeTotal;
//	}
//	public void setPoliceTotal(int policeTotal) {
//		this.policeTotal = policeTotal;
//	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
//	public int getIsDisplayPatlabor() {
//		return isDisplayPatlabor;
//	}
//	public void setIsDisplayPatlabor(int isDisplayPatlabor) {
//		this.isDisplayPatlabor = isDisplayPatlabor;
//	}
	
}
