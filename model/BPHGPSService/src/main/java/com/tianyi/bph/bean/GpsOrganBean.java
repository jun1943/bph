package com.tianyi.bph.bean;

import java.io.Serializable;

public class GpsOrganBean implements Serializable{

	private static final long serialVersionUID = 8801447437222115966L;
	
	private int 	gpsId;
	private String  gpsName;
	private String  gpsCode; 
	private int 	organId;
	private String  organName;
	private String  organPath;
	
	public int getGpsId() {
		return gpsId;
	}
	public void setGpsId(int gpsId) {
		this.gpsId = gpsId;
	}
	public String getGpsName() {
		return gpsName;
	}
	public void setGpsName(String gpsName) {
		this.gpsName = gpsName;
	}
	public String getGpsCode() {
		return gpsCode;
	}
	public void setGpsCode(String gpsCode) {
		this.gpsCode = gpsCode;
	}
	public int getOrganId() {
		return organId;
	}
	public void setOrganId(int organId) {
		this.organId = organId;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public String getOrganPath() {
		return organPath;
	}
	public void setOrganPath(String organPath) {
		this.organPath = organPath;
	}
	
}
