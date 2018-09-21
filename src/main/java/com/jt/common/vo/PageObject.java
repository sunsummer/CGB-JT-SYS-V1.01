package com.jt.common.vo;

import java.io.Serializable;
import java.util.List;
/**
 * 业务层值对象，负责封装业务层数据
 * @param <T>
 */
public class PageObject<T> implements Serializable{//类泛型
	private static final long serialVersionUID = 3361603153415782373L;
	/**总页数*/
	private int pageCount;
	/**当前页的页码*/
	private int pageCurrent=1;
	/**页面大小*/
	private int pageSize=3;
	/**当前页的记录信息*/
	private List<T> records;
	/**总记录数*/
	private int rowCount;
	public int getPageCount() {
		return pageCount;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public int getPageSize() {
		return pageSize;
	}
	public List<T> getRecords() {
		return records;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setPageCount(int pageCount) {
		
		this.pageCount = pageCount;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	
	
	
	
	
	
}
