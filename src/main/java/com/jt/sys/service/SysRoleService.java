package com.jt.sys.service;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.Node;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysDept;
import com.jt.sys.entity.SysLog;
import com.jt.sys.entity.SysRole;
import com.jt.sys.vo.SysRoleMenuResult;

public interface SysRoleService {
	
	int deleteObject(Integer id);
	
	/**
     * 依据条件分页查询日志信息
     * @param username 用户名
     * @param pageCurrent 当前页码
     * @return 对查询结果的封装
     */
	 PageObject<SysRole> findPageObjects(
			 String name,
			 Integer pageCurrent);
	 
	 /**
	 * 查询所有角色
	 */
	public List<SysRole> findRoleAll();
	 
	 public int saveObject(SysRole entity,Integer[] menuIds);
	 
	 public int updateObject(SysRole entity,Integer[] menuIds);
	 
	 SysRoleMenuResult findObjectById(Integer id) ;
	 
	 List<CheckBox> findObject(Integer id,String name);
}
