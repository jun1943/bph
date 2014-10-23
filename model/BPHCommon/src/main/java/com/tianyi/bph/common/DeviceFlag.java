package com.tianyi.bph.common;

public enum DeviceFlag{
	FLAG("设备查询标示");
	public enum Status{
		NO_STATUS{
			@Override
			public int value() {
				return 0;
			}
		},HAS_STATUS{
			@Override
			public int value() {
				return 0;
			}
		};
		public abstract int value();
	}
	public enum Share{
		NO_SHARE,HAS_SHARE,ONLY_SHARE
	}
	public enum DeviceType{
		ALL,IPC,DVR,NVR
	}
	public enum Active{
		ALL,ISACTIVED
	}
	private DeviceFlag(String s){
		this.s = s;
	}
	private String s;
	public int rvalue(DeviceFlag flag){
		switch (flag) {
		case FLAG:
			
			break;

		default:
			break;
		}
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(DeviceFlag.FLAG.s);
	}
}
