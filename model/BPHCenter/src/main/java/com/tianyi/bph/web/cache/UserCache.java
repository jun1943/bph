package com.tianyi.bph.web.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import com.tianyi.bph.domain.system.User;

public class UserCache {
	
	public final static UserCache instance=new UserCache();
	
	private Map<String,User> userMap=new ConcurrentHashMap<String,User>();
	
	private static Map<String,HttpSession> sessionMap=new ConcurrentHashMap<String,HttpSession>();
	
	private UserCache(){
		//每分钟检查一次。Cookie超时；
    	/*new java.util.Timer(true).schedule(new TimerTask() {
			@Override public void run() {
				long now=System.currentTimeMillis();
				for(Map.Entry<String,User> en:userMap.entrySet()){
					//超过30分钟，没有操作，要求重新登录；
					if((now-en.getValue().lastOptTime)>(60*30*1000)){
						logger.info("会话["+en.getKey()+","+en.getValue().lastOptTime+"]超过30分钟未操作，清除出系统！");
						userMap.remove(en.getKey());
					}
				}
			}
		}, 10*60*1000);*/
	}
	/**
	 * 把用户放入缓存
	 * @param user
	 */
	public void addUserCache(User user,HttpSession session){
		userMap.put(session.getId(),user);
	}
	/**
	 * 将客户端的sessionId 和一个session对象对应起来。保证session客户端session始终只有一个
	 * @param sessionId
	 * @param session
	 */
	public static void addSession(String sessionId,HttpSession session){
		sessionMap.put(sessionId, session);
	}
	/**
	 * 通过客户端传过来的session值,获取session对象
	 * @param sessionId
	 * @param session
	 * @return
	 */
	public static HttpSession getSession(String sessionId){
		return sessionMap.get(sessionId);
	}
	
	
	/**
	 * 移出用户信息
	 * @param userId
	 */
	public void remove(HttpSession session){
		userMap.remove(session.getId());
	}
	/**
	 * 获取缓存信息
	 * @param userId
	 * @return
	 */
	public User getUser(HttpSession session){
		return userMap.get(session.getId());
	}
	/**
	 * 通过sessionId来获取对象
	 * @param sessionId
	 * @return
	 */
	public User getUser(String sessionId){
		return userMap.get(sessionId);
	}
}
