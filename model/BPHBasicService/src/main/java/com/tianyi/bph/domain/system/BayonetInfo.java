package com.tianyi.bph.domain.system;

import java.util.Date;

public class BayonetInfo {
    private Integer bayonetId;

    private String name;

    private String code;

    private String direction;

    private Integer organId;

    private Integer lane;

    private String longitude;

    private String latitude;

    private String altitude;

    private Date createTime;

    private String describe;

    private Integer state;
    
    private String laneCode;//车道编码
    
    private String laneName;//车道名称
    
    private String laneDirection;//车道方向
    
    private Integer laneIDX;//车道序号 

    public String getLaneCode() {
		return laneCode;
	}

	public void setLaneCode(String laneCode) {
		this.laneCode = laneCode;
	}

	public String getLaneName() {
		return laneName;
	}

	public void setLaneName(String laneName) {
		this.laneName = laneName;
	}

	public String getLaneDirection() {
		return laneDirection;
	}

	public void setLaneDirection(String laneDirection) {
		this.laneDirection = laneDirection;
	}

	public Integer getLaneIDX() {
		return laneIDX;
	}

	public void setLaneIDX(Integer laneIDX) {
		this.laneIDX = laneIDX;
	}

	public Integer getBayonetId() {
        return bayonetId;
    }

    public void setBayonetId(Integer bayonetId) {
        this.bayonetId = bayonetId;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getLane() {
        return lane;
    }

    public void setLane(Integer lane) {
        this.lane = lane;
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

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}