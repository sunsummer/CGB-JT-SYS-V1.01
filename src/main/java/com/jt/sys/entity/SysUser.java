package com.jt.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private Date createdTime;
	private String createdUser;
	//部门id
	private Integer deptId;
	private String email;
	private Integer id;
	//手机
	private String mobile;
	
	private Date modifiedTime;
	
	private String modifiedUser;
	//密码
	private String password;
	//盐值(双重加密)
	private String salt;
	//用户名
	private String username;
	//禁用--1/启用--null
	private Integer valid=1;
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public String getEmail() {
		return email;
	}
	public Integer getId() {
		return id;
	}
	public String getMobile() {
		return mobile;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public String getPassword() {
		return password;
	}
	public String getSalt() {
		return salt;
	}
	public String getUsername() {
		return username;
	}
	public Integer getValid() {
		return valid;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
}
