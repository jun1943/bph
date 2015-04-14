package com.tianyi.bph.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Oragan
 * 
 * @author Administrator
 *
 */
public class Organ implements Serializable{
	
	private static final long serialVersionUID = -9123568058978312142L;
	
	private int id;
	private String name; 		// 机构名称
	private String code; 		// 机构编号
	private String shortName; 	// 机构简称
	private Organ parent;		// 父机构
	private String path; 		// 机构path
	private String note; 		// 备注
	private Integer typeCode;	// 警种类别码 10000：局 10001：交警 10002：治安 10003：刑侦
								// 10004：国保 10005：巡警
								// 10006：政治处 10007：指挥中心 10008：经侦 10009：禁毒 10010：特警 10011：看守所 10012：纪委
								// 10013：督察 10014：派出所 10015：作战室 10016：指挥岗
	private Integer organCode; 	// 机构类型 20001：市局直属 20002：分局机关 20003：派出所 20004：市局 20005：分局
	private Integer level; 		// 指挥岗 上级 1 下级0
	private List<Integer> children = new ArrayList<Integer>();
	private String cmsLoginName; // 基础平台帐号
	private String cmsPassword;  // 基础平台密码
	private boolean bindFlag; 	 // 是否绑定
	private Date lastBindTime;   // 最后绑定时间
	private Integer bindUserId;  // 绑定用户
	private String coordinates;  // 坐标
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Organ getParent() {
		return parent;
	}
	public void setParent(Organ parent) {
		this.parent = parent;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}
	public Integer getOrganCode() {
		return organCode;
	}
	public void setOrganCode(Integer organCode) {
		this.organCode = organCode;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public List<Integer> getChildren() {
		return children;
	}
	public void setChildren(List<Integer> children) {
		this.children = children;
	}
	public String getCmsLoginName() {
		return cmsLoginName;
	}
	public void setCmsLoginName(String cmsLoginName) {
		this.cmsLoginName = cmsLoginName;
	}
	public String getCmsPassword() {
		return cmsPassword;
	}
	public void setCmsPassword(String cmsPassword) {
		this.cmsPassword = cmsPassword;
	}
	public boolean isBindFlag() {
		return bindFlag;
	}
	public void setBindFlag(boolean bindFlag) {
		this.bindFlag = bindFlag;
	}
	public Date getLastBindTime() {
		return lastBindTime;
	}
	public void setLastBindTime(Date lastBindTime) {
		this.lastBindTime = lastBindTime;
	}
	public Integer getBindUserId() {
		return bindUserId;
	}
	public void setBindUserId(Integer bindUserId) {
		this.bindUserId = bindUserId;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
}
