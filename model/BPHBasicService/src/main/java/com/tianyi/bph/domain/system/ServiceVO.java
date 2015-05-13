package com.tianyi.bph.domain.system;

public class ServiceVO {
	/**
	 * mq 服务配置
	 */
	private String mqIp;
	private String mqPort;
	private String mqAccount;
	private String mqPwd;
	private String mqExchangeName;
	
	/**
	 * ftp服务配置
	 */
	private String ftpIp;
	private String ftpPort;
	private String ftpAccount;
	private String ftpPwd;
	
	/**
	 * gps服务配置
	 */
	private String gpsIp;
	private String gpsPort;
	private String gpsAccount;
	public String getMqIp() {
		return mqIp;
	}
	public void setMqIp(String mqIp) {
		this.mqIp = mqIp;
	}
	public String getMqPort() {
		return mqPort;
	}
	public void setMqPort(String mqPort) {
		this.mqPort = mqPort;
	}
	public String getMqAccount() {
		return mqAccount;
	}
	public void setMqAccount(String mqAccount) {
		this.mqAccount = mqAccount;
	}
	public String getMqPwd() {
		return mqPwd;
	}
	public void setMqPwd(String mqPwd) {
		this.mqPwd = mqPwd;
	}
	public String getMqExchangeName() {
		return mqExchangeName;
	}
	public void setMqExchangeName(String mqExchangeName) {
		this.mqExchangeName = mqExchangeName;
	}
	public String getFtpIp() {
		return ftpIp;
	}
	public void setFtpIp(String ftpIp) {
		this.ftpIp = ftpIp;
	}
	public String getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}
	public String getFtpAccount() {
		return ftpAccount;
	}
	public void setFtpAccount(String ftpAccount) {
		this.ftpAccount = ftpAccount;
	}
	public String getFtpPwd() {
		return ftpPwd;
	}
	public void setFtpPwd(String ftpPwd) {
		this.ftpPwd = ftpPwd;
	}
	public String getGpsIp() {
		return gpsIp;
	}
	public void setGpsIp(String gpsIp) {
		this.gpsIp = gpsIp;
	}
	public String getGpsPort() {
		return gpsPort;
	}
	public void setGpsPort(String gpsPort) {
		this.gpsPort = gpsPort;
	}
	public String getGpsAccount() {
		return gpsAccount;
	}
	public void setGpsAccount(String gpsAccount) {
		this.gpsAccount = gpsAccount;
	}
	public String getGpsPwd() {
		return gpsPwd;
	}
	public void setGpsPwd(String gpsPwd) {
		this.gpsPwd = gpsPwd;
	}
	private String gpsPwd;
}
