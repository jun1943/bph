package com.tianyi.bph.domain.system;

/**
 * 必达点位
 * 
 * @author Administrator
 *
 */
public class PatrolPoint {

	private int id;				//编号
	private String coordinate;	//坐标
	private String name;		//名称
	private String note;		//备注
	private int patrolAreaId;	//区域编号
	private String radius;		//半径
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getPatrolAreaId() {
		return patrolAreaId;
	}
	public void setPatrolAreaId(int patrolAreaId) {
		this.patrolAreaId = patrolAreaId;
	}
	public String getRadius() {
		return radius;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}
	
}
