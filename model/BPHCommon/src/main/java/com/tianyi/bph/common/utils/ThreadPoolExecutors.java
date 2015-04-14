package com.tianyi.bph.common.utils;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author heshengchao@qq.com 
 * @since  2013-11-6 上午9:19:39
 */
public class ThreadPoolExecutors {
	/**
	 * 线程池
	 */
	final static ThreadPoolExecutor executor=new ThreadPoolExecutor(2, 50,60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
	/**
	 * @param cmd
	 */
	public static void run(Runnable cmd){
		executor.execute(cmd);
	}
}
