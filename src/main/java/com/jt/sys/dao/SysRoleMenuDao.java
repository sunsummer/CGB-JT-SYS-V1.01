package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 角色和菜单之间的关系(资源的操作权限/每个角色的操作权限不同)
 * @author Administrator
 *
 */
public interface SysRoleMenuDao {
	/**
	 * 基于菜单id删除角色和菜单的关系数据
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);
	
	/**
	 * 基于角色id删除菜单与角色的关系数据
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer menuId);
	
	int insertObject(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
	
	List<Integer> findMenuIdsByRoleId(
			@Param("roleId")Integer roleId);
	
	List<Integer> findMenuIdsByRoleIds(
			@Param("roleIds")Integer... roleIds);
}













