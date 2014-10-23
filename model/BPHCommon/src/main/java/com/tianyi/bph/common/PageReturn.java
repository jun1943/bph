/**
 * Rest接口返回数据的包装器，主要用于通知是否操作（调用）成功与否（包含错误信息或Code）
 * @author fantedan@tieserv.com
 * @date  2015-1-13 下午3:07:36
 */
package com.tianyi.bph.common;

import java.io.Serializable;


/**
 *
 * @author fantedan@tieserv.com
 * @date  2015-1-13 下午3:07:36
 */
public class PageReturn implements Serializable {

	/** 变量 serialVersionUID(long) */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String description;
	private Object data;
	
	private int totalRows;
	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public Object getData() {
		return data;
	}
	
	/**
	 * @param obj 无用的参数，防止在JSON序列化时调用此方法，调用时请置为NULL.
	 * @return
	 */
	public Object getData(Object obj) {
		return this.data;
	}
	public void setData(Object obj) {
		this.data = obj;
	}
	
	public static PageReturn SUCCESS(){
		return SUCCESS("操作成功");
	}
	public static PageReturn SUCCESS(Object Data){
		return SUCCESS("操作成功",Data);
	}
	
	/**
	 * @param msg 成功信息
	 * @return
	 */
	public static PageReturn SUCCESS(String description){
		PageReturn rp=new PageReturn();
		rp.code=MessageCode.STATUS_SUCESS;
		rp.description=description;
		return rp;
	}
	
	/**
	 * @param msg  成功信息
	 * @param data 返回数据
	 * @return
	 */
	public static PageReturn SUCCESS(String description,Object data){
		PageReturn rp=new PageReturn();
		rp.code=MessageCode.STATUS_SUCESS;
		rp.description=description;
		rp.setData(data);
		return rp;
	}
	
	/** 
	 * @param msg 错误消息
	 * @return
	 */
	public static PageReturn FAILUER(String description){
		PageReturn rp=new PageReturn();
		rp.code=MessageCode.STATUS_FAIL;
		rp.description=description;
		return rp;
	}
	
	/** 
	 * @param msg 错误消息
	 * @return
	 */
	public static PageReturn FAILUER(String description,Object data){
		PageReturn rp=new PageReturn();
		rp.code=MessageCode.STATUS_FAIL;
		rp.description=description;
		rp.data=data;
		return rp;
	}
	
	/**
	 *  自定义信息
	 */
	public static PageReturn MESSAGE(int code){
		PageReturn rp=new PageReturn();
		rp.code=code;
		return rp;
	}

	public static PageReturn MESSAGE(int code, String description){
		PageReturn rp=new PageReturn();
		rp.code=code;
		rp.description=description;
		return rp;
	}
	
	public static PageReturn MESSAGE(int code, String description, Object data){
		PageReturn rp=new PageReturn();
		rp.code=code;
		rp.description=description;
		rp.data=data;
		return rp;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @param msg  成功信息
	 * @param taltalRows 返回list记录数
	 * @param data 返回数据
	 * @return
	 */
	public static PageReturn MESSAGE(int code, String description,int totalRows,Object data){
		PageReturn rp=new PageReturn();
		rp.code=code;
		rp.totalRows=totalRows;
		rp.description=description;
		rp.setData(data);
		return rp;
	}
}
