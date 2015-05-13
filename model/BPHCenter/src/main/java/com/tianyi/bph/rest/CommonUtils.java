package com.tianyi.bph.rest;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Formatter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

	    /**取得客户端的IP地址
	     * @return
	     */
	    public static String getRemoteIp(HttpServletRequest request) {
	        String ip = request.getHeader("x-forwarded-for");
	        if (ip == null || ip.length()<1 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length()<1 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length()<1 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	            System.out.println(request.getRemoteHost());
	        }
	        return ip;
	    }
	    
	    public static void getConfig(){ 
	        try{ 
	            InetAddress address = InetAddress.getLocalHost(); 
	            NetworkInterface ni = NetworkInterface.getByInetAddress(address); 
	            //ni.getInetAddresses().nextElement().getAddress();  
	            byte[] mac = ni.getHardwareAddress(); 
	            String sIP = address.getHostAddress(); 
	            String sMAC = ""; 
	            Formatter formatter = new Formatter(); 
	            for (int i = 0; i < mac.length; i++) { 
	                sMAC = formatter.format(Locale.getDefault(), "%02X%s", mac[i], 
	                        (i < mac.length - 1) ? "-" : "").toString(); 
	 
	            } 
	            System.out.println("IP：" + sIP); 
	            System.out.println("MAC：" + sMAC); 
	        }catch(Exception e){ 
	            e.printStackTrace(); 
	        } 
	    } 

}
