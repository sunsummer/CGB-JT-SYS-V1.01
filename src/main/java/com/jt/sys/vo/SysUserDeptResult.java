package com.jt.sys.vo;

import java.io.Serializable;
import java.util.Date;
import com.jt.sys.entity.SysDept;

public class SysUserDeptResult implements Serializable{
	private static final long serialVersionUID = 5477389876913514595L;
	private Date createdTime;
	private String createdUser;
	private String email;
	private Integer id;
	private String mobile;
	private Date modifiedTime;
	private String modifiedUser;
	private String password;//md5
	private String salt;
	private SysDept sysDept;
	private String username;
	private Integer valid=1;
	
	/**
	 * 在控制层将此对象转换为json串时,此时会调用对象
	 * 的get方法,当检测到get方法上有@JsonSerialize
	 * 注解时,底层系统会调用此注解using属性指定的类
	 * 中的serialize方法将日期对象序列化为指定格式
	 * @return
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	public String getCreatedUser() {
		return createdUser;
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
	public SysDept getSysDept() {
		return sysDept;
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
	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	
	
	
}
