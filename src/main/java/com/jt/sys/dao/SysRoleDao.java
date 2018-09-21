package com.jt.sys.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.CheckBox;
import com.jt.sys.entity.SysRole;
import com.jt.sys.vo.SysRoleMenuResult;


public interface SysRoleDao {
	
	/**
	 * j基于id执行删除操作
	 * @param id
	 * @return 删除的行数
	 */
	int deleteObject(Integer id);
	
	/**
	 * 基于条件分页查询日志信息
	 * @param username  查询条件(例如查询哪个用户的日志信息)
	 * @param startIndex 当前页的起始位置
	 * @param pageSize 当前页的页面大小
	 * @return 当前页的日志记录信息
	 * 数据库中每条日志信息封装到一个SysLog对象中
	 */
	List<SysRole> findPageObjects(
	     @Param("name")String name,
	     @Param("startIndex")Integer startIndex,
	     @Param("pageSize")Integer pageSize);
	
	/**
	 * 查询所有角色
	 */
	public List<SysRole> findRoleAll();
	
	/**
	 * 基于条件查询总记录数
	 * @param username 查询条件(例如查询哪个用户的日志信息)
	 * @return 总记录数(基于这个结果可以计算总页数)
	 * 说明：假如如下方法没有使用注解修饰，在基于名字进行查询
	 * 时候会出现There is no getter for property named
	 * 'username' in 'class java.lang.String'
	 */
	int getRowCount(@Param("name") String name);
	
	int insertObject(SysRole entity);
	
	int updateObject(SysRole entity);
	
	//SysRole findObjectById(Integer id);
	
	SysRoleMenuResult findObjectById(Integer id);
	
	
	
	List<CheckBox> findObject(Integer id,String name);
}
















