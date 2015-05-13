package com.tianyi.bph.domain.system;

public class MqConfig {
	/**
	 * mq 服务配置
	 */
	private String mqIp;
	private String mqPort;
	private String mqAccount;
	private String mqPwd;
	private String mqExchangeName;
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
}
