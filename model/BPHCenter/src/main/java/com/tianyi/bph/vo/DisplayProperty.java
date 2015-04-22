package com.tianyi.bph.vo;

public class DisplayProperty {
	private String name;
	private String borderColor;

	private double borderOpacity;

	private String fillColor;
	private double fillOpacity;

	private double x;

	private double y;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public double getBorderOpacity() {
		return borderOpacity;
	}

	public void setBorderOpacity(double borderOpacity) {
		this.borderOpacity = borderOpacity;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public double getFillOpacity() {
		return fillOpacity;
	}

	public void setFillOpacity(double fillOpacity) {
		this.fillOpacity = fillOpacity;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "";
	}
}