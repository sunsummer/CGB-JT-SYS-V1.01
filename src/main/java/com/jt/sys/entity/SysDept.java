package com.jt.sys.entity;
import java.io.Serializable;
import java.util.Date;
public class SysDept implements Serializable{
	private static final long serialVersionUID = -5259265803332215029L;
	private Date createdTime;
	private String createdUser;
	private Integer id;
	private Date modifiedTime;
	private String modifiedUser;
	private String name;
	private String note;
	private Integer parentId;
	private Integer sort;
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
	public Integer getSort() {
		return sort;
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
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "SysDept [id=" + id + ", name=" + name + ", parentId=" + parentId + ", sort=" + sort + ", note=" + note
				+ "]";
	}
}
