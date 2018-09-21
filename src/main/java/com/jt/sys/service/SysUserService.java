package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;
import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;

public interface SysUserService {
	
	PageObject<SysUserDeptResult> findPageObjects(
		String username, Integer pageCurrent);
	
	/**
	 * 根据id修改标记值
	 * @param id	唯一id
	 * @param valid 启用/禁用标记值
 	 * @return
	 */
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);
	
	/**
	  * 查询所有角色信息
	  * @return
	  */
	 List<SysRole> findRoleAll();
	 
	 /**
	  * 保存用户数据信息
	  * @param userId	用户id
	  * @param roleIds	角色id
	  * @return			
	  */
	 int saveObject(SysUser entity,Integer... roleIds);
	 
	 int updateObject(SysUser entity,Integer... roleIds);

	 /**
	  * 基于用户id查询用户数据和角色id
	  * @return
	  */
	 public Map<String, Object> findObjectById(Integer userId);
	 
	 
}


















