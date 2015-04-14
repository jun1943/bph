package com.tianyi.bph.web;

import java.util.Collection;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tianyi.bph.domain.system.User;


public class PrivilegeCache {
	private static final Logger logger=LoggerFactory.getLogger(PrivilegeCache.class);
    /** 缓存的用户列表 */
     private Map<String,PrivilegeUser> userMap=new ConcurrentHashMap<String,PrivilegeUser>();
     /**设置当前Request环境中的用户信息；*/
     static final ThreadLocal<PrivilegeUser> threadLocal = new ThreadLocal<PrivilegeUser>();
    /** token:username */
//    private final static Map<Long, PrivilegeUser> tokenUserMap      = new ConcurrentHashMap<Long, PrivilegeUser>();

//    public final static String                      SESSION_USER_ID = "SESSION_USER_ID";
    public final static PrivilegeCache	instance = new PrivilegeCache();

    /**
     * 
     */
    private PrivilegeCache() { 
    	//每分钟检查一次。Cookie超时；
    	new java.util.Timer(true).schedule(new TimerTask() {
			@Override public void run() {
				long now=System.currentTimeMillis();
				for(Map.Entry<String,PrivilegeUser> en:userMap.entrySet()){
					//超过30分钟，没有操作，要求重新登录；
					if((now-en.getValue().lastOptTime)>(60*30*1000)){
						logger.info("会话["+en.getKey()+","+en.getValue().lastOptTime+"]超过30分钟未操作，清除出系统！");
						userMap.remove(en.getKey());
					}
				}
			}
		}, 10*60*1000);
    	
    };


    /**
     * 添加用户
     * @param user
     */
    public void addPrivilege(long userID, User user,HttpSession session) {
        PrivilegeUser pu = new PrivilegeUser();
        pu.setID(user.getId());
        pu.setUsername(user.getUserId());
        pu.setPassword(user.getPassword());
        pu.setShowName(user.getUserName());
        pu.lastOptTime=System.currentTimeMillis();//最近的操作时间 
        userMap.put(session.getId(), pu);
    }

    public PrivilegeUser getPrivilege(HttpSession session) {
    	PrivilegeUser pu =userMap.get(session.getId());
    	if(pu!=null){
    		pu.lastOptTime=System.currentTimeMillis();//最近的操作时间 
    		threadLocal.set(pu);
    	}
    	return pu ;
    }
    
    public void removePrivelegeUser(HttpSession session) {
    	userMap.remove(session.getId());
	}

    public static class PrivilegeUser {
        private Long                          ID;
        private String                        username;
        private String                        password;
        private String                        showName;
		/** 针对终端登陆用户，通过IP分辨 */
        private String                        IP;
        private Collection<PrivilegeFunction> funs;        
        private long lastOptTime;

		
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Collection<PrivilegeFunction> getFuns() {
            return this.funs;
        }

        public void setFuns(Collection<PrivilegeFunction> funs) {
            this.funs = funs;
        }

        public String getShowName() {
            return showName;
        }

        public void setShowName(String showName) {
            this.showName = showName;
        }

        public String getIP() {
            return IP;
        }

        public void setIP(String iP) {
            IP = iP;
        }

        public Long getID() {
            return ID;
        }

        public void setID(Long id) {
            ID = id;
        }
		public long getLastOptTime() {
			return lastOptTime;
		}
		public void setLastOptTime(long lastOptTime) {
			this.lastOptTime = lastOptTime;
		}
    }

    public static class PrivilegeFunction {
        private String   url;
        private String[] paramters;
        private String   name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String[] getParamters() {
            return paramters;
        }

        public void setParamters(String[] paramters) {
            this.paramters = paramters;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

   

    /**
     * 获取当前Request环境中的用户信息；
     * 
     * @return
     */
    public final static PrivilegeUser currentUser() {
        return threadLocal.get();
    }


	
}
