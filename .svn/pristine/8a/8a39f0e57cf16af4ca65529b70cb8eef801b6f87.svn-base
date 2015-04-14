package com.tianyi.bph.domain.system;

import java.util.Date;

public class Organ {
    private Integer id;

    //机构编码
    private String code;

    private String name;

    private Integer parentId;
    //父对象
    private Organ parentOrgan;

    //路径
    private String path;

    private String shortName;

    //机构类型编码
    private String orgTypeCode;
    
    private OrganType organType;

    //机构警种编码
    private String orgPcCgyCode;
    
    private OrgPcCgy orgPcCgy;
    //级别
    private Integer levle;
    
    //0正常 1 禁用
    private Integer state = 0;

    private Date createTime;

    //预置 0非预置 1预置
    private Short preset = 0;

    private Date updateTime;

    private String note;

    //排序号
    private Integer sortNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode == null ? null : orgTypeCode.trim();
    }

    public String getOrgPcCgyCode() {
        return orgPcCgyCode;
    }

    public void setOrgPcCgyCode(String orgPcCgyCode) {
        this.orgPcCgyCode = orgPcCgyCode == null ? null : orgPcCgyCode.trim();
    }

    public Integer getLevle() {
        return levle;
    }

    public void setLevle(Integer levle) {
        this.levle = levle;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getPreset() {
        return preset;
    }

    public void setPreset(Short preset) {
        this.preset = preset;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

	public Organ getParentOrgan() {
		return parentOrgan;
	}

	public void setParentOrgan(Organ parentOrgan) {
		this.parentOrgan = parentOrgan;
	}

	public OrganType getOrganType() {
		return organType;
	}

	public void setOrganType(OrganType organType) {
		this.organType = organType;
	}

	public OrgPcCgy getOrgPcCgy() {
		return orgPcCgy;
	}

	public void setOrgPcCgy(OrgPcCgy orgPcCgy) {
		this.orgPcCgy = orgPcCgy;
	}
}