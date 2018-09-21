package com.jt.sys.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * POJO: 日志实体对象(对应jtsys数据库中sys_logs这个表)
 * 封装系统的日志信息
 */
public class SysLog implements Serializable{
	private static final long serialVersionUID = -4523256868571326166L;
	/**这个日志的创建时间*/
	private Date createdTime;
	private Integer id;
	/**用户端的ip地址*/
	private String ip;
	/**执行这个操作对应的方法*/
	private String method;
	/**执行的操作*/
	private String operation;
	/**调用方法时传入的参数*/
	private String params;
	/**方法的执行时间*/
	private Long time;
	/**操作用户*/
	private String username;
	
	public SysLog() {
		super();
	}
	public SysLog(Date createdTime, Integer id, String ip, String method, String operation, String params, Long time,
			String username) {
		super();
		this.createdTime = createdTime;
		this.id = id;
		this.ip = ip;
		this.method = method;
		this.operation = operation;
		this.params = params;
		this.time = time;
		this.username = username;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public Integer getId() {
		return id;
	}
	public String getIp() {
		return ip;
	}
	public String getMethod() {
		return method;
	}
	public String getOperation() {
		return operation;
	}
	public String getParams() {
		return params;
	}
	public Long getTime() {
		return time;
	}
	public String getUsername() {
		return username;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}






