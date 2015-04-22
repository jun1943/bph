package com.tianyi.bph.vo;

import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tianyi.bph.common.JsonUtils;
import com.tianyi.bph.domain.system.Area;

public class AreaVO {
	public AreaVO() {
	}

	public AreaVO(Area area) {
		if (area != null) {
			setId(area.getId());
			setAreaName(area.getAreaName());
			setAreaType(area.getAreaType());
			setCreateTime(area.getCreateTime());
			if (StringUtils.hasLength(area.getDisplayProperty())) {
				setDisplayProperty(JsonUtils.toObj(area.getDisplayProperty(),
						DisplayProperty.class));
			} else {
				setDisplayProperty(null);
			}
			if (StringUtils.hasLength(area.getMapProperty())) {
				List<MapProperty> relist = JsonUtils.toObj(
						area.getMapProperty(),
						new TypeReference<List<MapProperty>>() {
						});
				setMapProperty(relist);
			} else {
				setMapProperty(null);
			}
			if (area.getRelationUserKeys() != null
					&& !area.getRelationUserKeys().isEmpty()) {
				setRelationUserIds(area.getRelationUserKeys());
			}
			setFlag(area.getFlag());
			setOrganId(area.getOrganId());
			setNnt(area.getNnt());
			setTel(area.getTel());
		}
	}

	private Integer id;

	private String areaName;

	private Integer areaType;// 区域类型 1巡区， 2 社区，3 辖区

	private Integer organId;

	private Boolean changeRange;

	private Date createTime;

	private Integer flag;// 1正常 2 弃用

	private Integer createUserId;

	private String tel;

	private Integer nnt;

	private DisplayProperty displayProperty;

	private List<MapProperty> mapProperty;

	private List<Integer> relationUserIds;// 关联警员

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public Integer getOrganId() {
		return organId;
	}

	public void setOrganId(Integer organId) {
		this.organId = organId;
	}

	public Boolean getChangeRange() {
		return changeRange;
	}

	public void setChangeRange(Boolean changeRange) {
		this.changeRange = changeRange;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getNnt() {
		return nnt;
	}

	public void setNnt(Integer nnt) {
		this.nnt = nnt;
	}

	public DisplayProperty getDisplayProperty() {
		return displayProperty;
	}

	public void setDisplayProperty(DisplayProperty displayProperty) {
		this.displayProperty = displayProperty;
	}

	public List<MapProperty> getMapProperty() {
		return mapProperty;
	}

	public void setMapProperty(List<MapProperty> mapProperty) {
		this.mapProperty = mapProperty;
	}

	public Area ctrate() {
		Area area = new Area();
		area.setId(this.id);
		area.setAreaName(this.areaName);
		area.setAreaType(this.areaType);
		area.setCreateTime(this.createTime);
		if (this.displayProperty != null) {
			area.setDisplayProperty(JsonUtils.toJson(this.displayProperty));
		} else {
			area.setDisplayProperty(null);
		}
		if (this.mapProperty != null) {
			area.setMapProperty(JsonUtils.toJson(this.mapProperty));
		} else {
			area.setDisplayProperty(null);
		}
		if (this.relationUserIds != null) {
			area.setRelationUserKeys(relationUserIds);
		}
		area.setFlag(this.flag);
		area.setOrganId(this.organId);
		area.setNnt(this.nnt);
		area.setTel(this.tel);
		return area;
	}

	public List<Integer> getRelationUserIds() {
		return relationUserIds;
	}

	public void setRelationUserIds(List<Integer> relationUserIds) {
		this.relationUserIds = relationUserIds;
	}

}