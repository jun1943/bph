package com.tianyi.bph.domain.system.autoUpdate;

/**
 * 版本文件
 * 
 * @author Administrator
 *
 */
public class VersionFile {
	
	private int id;
	private String path;
	private int type;
	private String versionCode;
	private int needInstall;
	private int needRegist;
	private int fileIndex;
	private double fileSize; 
	
	public int getFileIndex() {
		return fileIndex;
	}
	public void setFileIndex(int fileIndex) {
		this.fileIndex = fileIndex;
	}
	public double getFileSize() {
		return fileSize;
	}
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public int getNeedInstall() {
		return needInstall;
	}
	public void setNeedInstall(int needInstall) {
		this.needInstall = needInstall;
	}
	public int getNeedRegist() {
		return needRegist;
	}
	public void setNeedRegist(int needRegist) {
		this.needRegist = needRegist;
	}
	
}
