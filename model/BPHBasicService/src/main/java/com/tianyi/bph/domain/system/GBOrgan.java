package com.tianyi.bph.domain.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class GBOrgan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String path;
	private Integer gbPlatformId;
	private Integer parentId;
	private Integer type;
	private String stdId;

	private boolean checked;
	private boolean expanded;// 是否展开节点 0不展开 1展开

	private boolean hasChild;

	private List<GBOrgan> items;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getGbPlatformId() {
		return gbPlatformId;
	}

	public void setGbPlatformId(Integer gbPlatformId) {
		this.gbPlatformId = gbPlatformId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public List<GBOrgan> getItems() {
		return items;
	}

	public void setItems(List<GBOrgan> items) {
		this.items = items;
	}

	public void addChild(GBOrgan node) {
		if (this.items == null) {
			this.items = new ArrayList<GBOrgan>();
		}
		this.items.add(node);
	}

	public GBOrgan clone() {
		GBOrgan clone = new GBOrgan();
		BeanUtils.copyProperties(this, clone);
		return clone;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

}