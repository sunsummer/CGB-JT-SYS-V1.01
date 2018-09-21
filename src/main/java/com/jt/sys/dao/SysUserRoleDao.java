package com.jt.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;
/**
 * 此dao肤色操作用户和角色的关系表
 * 
 * 1. 用户和角色之间的关系 (多对多)m2m
 * 2. 多对多关系在表中如何实现(中间表--关系表)
 * @author Administrator
 *
 */
public interface SysUserRoleDao {
	
	/**
	 * 基于角色id删除用户和角色对应的方法
	 * @param roleId 角色id
	 * @return 删除的行数
	 */
	int deleteObjectsByRoleId(Integer roleId);
	
	/**
	 * 负责将用户与角色的关系数据写入到数据库
	 * @param userId 用户id
	 * @param roleIds 多个角色id
	 * @return
	 */
	int insertObject(
			@Param("userId")Integer userId,
			@Param("roleIds")Integer[]roleIds);

	List<Integer> findRoleIdsByUserId(Integer id);
	
	int deleteObjectsByUserId(Integer userId);
	
	int deleteObjectsById(
		@Param("columuName")	String columuName,
		@Param("Id")			Integer Id);
}










