package com.jt.sys.entity;
import java.io.Serializable;
import java.util.Date;
/**
 * POJO:菜单实体对象(封装菜单记录信息)
 */

public class SysMenu implements Serializable{//POPO
	private static final long serialVersionUID = -8805983256624854549L;
	private Date createdTime;
	private String createdUser;
	private Integer id;
	private Date modifiedTime;
	private String modifiedUser;
	private String  name;
	private String  note;
	private Integer parentId;
	private String  permission;
	private Integer sort;
	private Integer type;
	private String  url;
	
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
	public Integer getParentId() {
		return parentId;
	}
	public String getPermission() {
		return permission;
	}
	public Integer getSort() {
		return sort;
	}
	public Integer getType() {
		return type;
	}
	public String getUrl() {
		return url;
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
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
