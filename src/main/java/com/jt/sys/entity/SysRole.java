package com.jt.sys.entity;
import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable{

	private static final long serialVersionUID = -6134997909495982844L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Date createdTime;
	private String createdUser;
	private Integer id;
	private Date modifiedTime;
	private String modifiedUser;
	private String name;
	private String note;

	public Date getCreatedTime() {
		return createdTime;
	}


	public String getCreatedUser() {
		return createdUser;
	}


	public Integer getId() {
		return id;
	}


	public Date getModifiedTime() {
		return modifiedTime;
	}


	public String getModifiedUser() {
		return modifiedUser;
	}


	public String getName() {
		return name;
	}


	public String getNote() {
		return note;
	}


	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}


	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "SysRole [id=" + id + ", name=" + name + ", note=" + note + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser
				+ "]";
	}
}
