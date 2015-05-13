package com.tianyi.bph.domain.system;

import java.util.ArrayList;
import java.util.List;

public class AreaGroup {
    private Integer groupId;

    private Integer areaGroupType;

    private String areaGroupContent;
    
    //private List<JsonPoint> jsonPs=new ArrayList<JsonPoint>();

   
    /*private JsonPoint jsonPoint;

	public JsonPoint getJsonPoint() {
		return jsonPoint;
	}

	public void setJsonPoint(JsonPoint jsonPoint) {
		this.jsonPoint = jsonPoint;
	}*/
/*
	public List<JsonPoint> getJsonPs() {
		return jsonPs;
	}

	public void setJsonPs(List<JsonPoint> jsonPs) {
		this.jsonPs = jsonPs;
	}*/

	public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getAreaGroupType() {
        return areaGroupType;
    }

    public void setAreaGroupType(Integer areaGroupType) {
        this.areaGroupType = areaGroupType;
    }

    public String getAreaGroupContent() {
        return areaGroupContent;
    }

    public void setAreaGroupContent(String areaGroupContent) {
        this.areaGroupContent = areaGroupContent;
    }
}