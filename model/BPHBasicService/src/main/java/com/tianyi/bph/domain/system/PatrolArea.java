package com.tianyi.bph.domain.system;

/**
 * 巡逻区域
 * 
 * @author Administrator
 *
 */
public class PatrolArea {

	private int id;					//编号
	private String backColor;		//背景色
	private String backTransparence;//背景透明色
	private String coordinates;		//坐标系
	private String lineColor;		//边框色
	private String lineTransparence;//边框透明色
	private String name;			//巡区名称
	private String note;			//备注
	private int organId;			//机构编号
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBackColor() {
		return backColor;
	}
	public void setBackColor(String backColor) {
		this.backColor = backColor;
	}
	public String getBackTransparence() {
		return backTransparence;
	}
	public void setBackTransparence(String backTransparence) {
		this.backTransparence = backTransparence;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getLineColor() {
		return lineColor;
	}
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public String getLineTransparence() {
		return lineTransparence;
	}
	public void setLineTransparence(String lineTransparence) {
		this.lineTransparence = lineTransparence;
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
	public int getOrganId() {
		return organId;
	}
	public void setOrganId(int organId) {
		this.organId = organId;
	}
	
}
