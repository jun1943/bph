package domain;

public class DBInfo {

	public String url;
	public String port;
	public String SID;
	public String driverClass;
	public String loginName;
	public String loginPwd;
	
	private String getUrl(){
		return url;
	}
	private String setUrl(String url){
		this.url=url;
	}
	
}
