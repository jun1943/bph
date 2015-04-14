package com.tianyi.bph.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * GPS实时位置信息
 * 
 * @author sfg
 * @date 
 */
public class GPSInfor  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;			//主键
	private String gpsId;		//GPS设备Id
	private Date   addressTime;	//位置时间
	private double speed;		//速度
	private int	   position;	//定位：1定位，0不定位
	private double gpsX;		//经度
	private double gpsY;		//纬度
	private double high;		//高度
	private double direction;	//方向
	private String address;		//位置
	private String name;		//GPS设备
	private int	   gpsType;		//GPS类型：1车牌、
	private int	   gpsUnit;		//GPS来源单位：
	
	
	public int getGpsUnit() {
		return gpsUnit;
	}
	public void setGpsUnit(int gpsUnit) {
		this.gpsUnit = gpsUnit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGpsId() {
		return gpsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setGpsId(String gpsId) {
		this.gpsId = gpsId;
	}
	public Date getAddressTime() {
		return addressTime;
	}
	public void setAddressTime(Date addressTime) {
		this.addressTime = addressTime;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getGpsX() {
		return gpsX;
	}
	public void setGpsX(double gpsX) {
		this.gpsX = gpsX;
	}
	public double getGpsY() {
		return gpsY;
	}
	public void setGpsY(double gpsY) {
		this.gpsY = gpsY;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getDirection() {
		return direction;
	}
	public void setDirection(double direction) {
		this.direction = direction;
	}
	public int getGpsType() {
		return gpsType;
	}
	public void setGpsType(int gpsType) {
		this.gpsType = gpsType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
