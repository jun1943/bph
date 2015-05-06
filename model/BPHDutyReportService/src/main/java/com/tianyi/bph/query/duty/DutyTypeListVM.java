package com.tianyi.bph.query.duty;

import java.util.List;

public class DutyTypeListVM {

	/**
	 * 属性列表
	 */
	private String properties;
	/**
	 * 上级节点名称
	 */
	private String parentName;
	/**
	 * 上级节点全路径
	 */
	private String parentFullPath;
	/**
	 * id值，默认为0
	 */
	private Integer id;
	/**
	 * 勤务类型名称
	 */
    private String name;
    /**
	 * 上级节点id
	 */
    private Integer parentId;
    /**
	 * 节点层级，默认为0 
	 */
    private Integer level =0;
    /**
	 * 是否子节点
	 */
    private Boolean isLeaf;
    /**
	 * 节点全路径
	 */
    private String fullpath;
    /**
	 * 是否显示名称
	 */
    private String isShowname;
    /**
	 * 最大警员数目
	 */
    private String maxPolice;
    /**
	 * 附加属性
	 */
    private String attireType;
    /**
	 * 属性id
	 */
    private String dutyPropertyId;
    /**
	 * 着装方式id
	 */
    private String assoTaskType;
    /**
	 * 平台标识
	 */
    private Boolean syncState;
    /**
	 * 平台id
	 */
    private Integer platformId;
    /**
	 * 武装方式id
	 */
    private String armamentType;
    /**
	 * 是否启用
	 */
    private String isUsed;
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentFullPath() {
		return parentFullPath;
	}
	public void setParentFullPath(String parentFullPath) {
		this.parentFullPath = parentFullPath;
	}
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Boolean getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getFullpath() {
		return fullpath;
	}
	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}
	public String getIsShowname() {
		return isShowname;
	}
	public void setIsShowname(String isShowname) {
		this.isShowname = isShowname;
	}
	public String getMaxPolice() {
		return maxPolice;
	}
	public void setMaxPolice(String maxPolice) {
		this.maxPolice = maxPolice;
	}
	public String getAttireType() {
		return attireType;
	}
	public void setAttireType(String attireType) {
		this.attireType = attireType;
	}
	public String getDutyPropertyId() {
		return dutyPropertyId;
	}
	public void setDutyPropertyId(String dutyPropertyId) {
		this.dutyPropertyId = dutyPropertyId;
	}
	public String getAssoTaskType() {
		return assoTaskType;
	}
	public void setAssoTaskType(String assoTaskType) {
		this.assoTaskType = assoTaskType;
	}
	public Boolean getSyncState() {
		return syncState;
	}
	public void setSyncState(Boolean syncState) {
		this.syncState = syncState;
	}
	public Integer getPlatformId() {
		return platformId;
	}
	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}
	public String getArmamentType() {
		return armamentType;
	}
	public void setArmamentType(String armamentType) {
		this.armamentType = armamentType;
	}
	public String getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
}
