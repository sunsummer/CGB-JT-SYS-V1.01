package com.jt.sys.vo;

import java.util.List;

import com.jt.sys.entity.SysRole;

/**
 * 通过此对象封装角色和角色对应的菜单id
 */
public class SysRoleMenuResult {
	
	//private SysRole sysRole;
	private SysRole role;
	private List<Integer> menuIds;
	
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
}
