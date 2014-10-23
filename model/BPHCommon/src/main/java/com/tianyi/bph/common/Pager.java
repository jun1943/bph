package com.tianyi.bph.common;

import java.util.List;
/**
 * 用于分页
 * 
 * @author heshencao@163.com 2013-3-21 下午4:46:09
 * @param <E>
 */
public class Pager<E> {

	/** 总行数 */
	private int totalRows;

	/** 每页显示的行数 */
	private int pageSize;

	/** 当前页号 */
	private int currentPage;

	/** 总页数 */
	private Integer totalPages;
	
	private Integer pageNo;

	/** 当前页在数据库中的起始行 */
	// private int startRow;

	private List<E> data;

	public Pager(){
	}
	public Pager(int pageSize,int currentPage){
		this.pageSize=pageSize;
		this.currentPage=currentPage;
	}
	
	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPages() {

		return totalPages!=null?totalPages:(totalRows>0&&pageSize>0)?(totalRows+pageSize-1)/pageSize:0;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public <T> Pager<T> copy(List<T> data){
		Pager<T> page=new Pager<T>();
		page.currentPage=this.currentPage;
		page.pageSize=this.pageSize;
		page.totalPages=this.totalPages;
		page.totalRows=this.totalRows;
		page.data=data;
		
		return page;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
}