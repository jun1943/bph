package com.tianyi.bph.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**短信发送工具
 * @author he
 */
public class SendSmsClient {
	private static Logger log=LoggerFactory.getLogger(SendSmsClient.class);
	
//	
//	public static void sendMessage(String phone,String message){
//		sch.sendMessage(phone, message);
//	}
	
	private static String server=SystemConfig.getInstance().getProperty(SystemConfig.SMS_SERVER);
	
	/**发送短信
	 * @param phone
	 * @param message
	 */
	public static void sendMessage(String phone,String message){
			try {
				DefaultHttpClient httpclient = new DefaultHttpClient();
				
				HttpPost httpPost = new HttpPost("http://"+server+"/");
				List <NameValuePair> nvps = new ArrayList <NameValuePair>();
				nvps.add(new BasicNameValuePair("phone", phone));
				nvps.add(new BasicNameValuePair("sms", message));
				httpPost.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8"));
		        
		        HttpResponse rsp = httpclient.execute(httpPost);
		        HttpEntity entity= rsp.getEntity();
		       
				InputStream in =  entity.getContent();
				StringBuffer out = new StringBuffer();
			    byte[] BUFFER_SIZE = new byte[100];
			    
			    int count = -1;  
			    while((count = in.read(BUFFER_SIZE,0,100)) != -1) {
			        out.append(new String(BUFFER_SIZE, 0, count));
			    }
	
			    log.debug("短信发送完成！返回消息："+out)	;
					
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
	}

	public static void main(String[] args) {
		SendSmsClient.sendMessage("13699449404", "test chinese，短信测试！");
	}
}
