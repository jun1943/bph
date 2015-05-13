package com.tianyi.bph.domain.system;

public class FtpConfig {
	/**
	 * ftp服务配置
	 */
	private String ftpIp;
	private String ftpPort;
	private String ftpAccount;
	private String ftpPwd;
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
}
