package com.tianyi.bph.domain.system;

/**
 * 摄像头
 * 
 * @author Administrator
 *
 */
public class Camera {
	
	private int cameraId; //摄像头id
	private String cameraDeviceCode;//摄像头编号
	private String name;	//名称
	private String source;	//来源
	private String type;	//类型
	private String longitude;	//经度
	private String latitude;	//纬度
	private String angle;	//角度
	private String direction;	//方向
	private String viewRange;	//视角范围
	
	public int getCameraId() {
		return cameraId;
	}
	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}
	public String getCameraDeviceCode() {
		return cameraDeviceCode;
	}
	public void setCameraDeviceCode(String cameraDeviceCode) {
		this.cameraDeviceCode = cameraDeviceCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getAngle() {
		return angle;
	}
	public void setAngle(String angle) {
		this.angle = angle;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getViewRange() {
		return viewRange;
	}
	public void setViewRange(String viewRange) {
		this.viewRange = viewRange;
	}
	
	
}
