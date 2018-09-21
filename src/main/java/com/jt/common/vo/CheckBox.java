package com.jt.common.vo;

import java.io.Serializable;
/**
 * 用于封装数据的节点对象
 * 1)sys_menus (存储的是菜单信息)
 * 2)sys_role_menus(存储的是菜单和角色的关系数据)
 */
public class CheckBox implements Serializable{
	
	private static final long serialVersionUID = -224148797542502698L;
	
	private Integer id;
	private String name;
	
	@Override
	public String toString() {
		return "CheckBox [id=" + id + ", name=" + name + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
