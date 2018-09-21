package com.jt.sys.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.entity.SysRole;
import com.jt.sys.service.SysRoleService;
import com.jt.sys.vo.SysRoleMenuResult;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao; 
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	/**
	 * 删除指定id的数据
	 */
	@Override
	public int deleteObject(Integer id) {
		//1. 验证参数的有效性
		if(id==null||id<1){
			throw new IllegalArgumentException("id值不正确");
		}
		//2. 删除role表中指定id的数据
		int rows = sysRoleDao.deleteObject(id);
		if(rows==0){
			throw new ServiceException("要删除的可能已经不存在了");
		}
		//3. 删除中间表中对应的数据
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		
		sysUserRoleDao.deleteObjectsByRoleId(id);
		//sysUserRoleDao.deleteObjectsById("role_id", id);
		
		//4. 返回结果集
		return rows;
	}
	
	@Override
	public PageObject<SysRole> findPageObjects(
			String name,
			Integer pageCurrent) {
		//1.参数有效性验证(只验证pageCurrent)
		if(pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("页码值不正确");
		}
		//2.查询总记录数并进行验证
		int rowCount=sysRoleDao.getRowCount(name);
		if(rowCount==0)
	    throw new ServiceException("没有对应记录");
		//3.查询当前页日志数据
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records=
				sysRoleDao.findPageObjects(name,
				startIndex, pageSize);
		//4.对查询结果进行封装
		PageObject<SysRole> po=new PageObject<SysRole>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageSize(pageSize);
		po.setPageCurrent(pageCurrent);
		
		po.setPageCount((rowCount-1)/pageSize+1);
		//5.返回结果
		return po;
	}
	
	/**
	 * 查询所有角色
	 */
	@Override
	public List<SysRole> findRoleAll() {
		List<SysRole> list = sysRoleDao.findRoleAll();
		return list;
	}
	
	@Override
	public int updateObject(SysRole entity,Integer[] menuIds) {
		//1.合法性验证
		if(entity==null){
			throw new ServiceException("保存数据不能为空");
		}
		if(StringUtils.isEmpty(entity.getName())){
			throw new ServiceException("角色名不能为空");
		}
		if(menuIds ==null ||menuIds.length==0){
			throw new ServiceException("必须为角色赋予权限");
		}
		//2.保存角色自身数据
		int rows=sysRoleDao.updateObject(entity);
		
		//3.保存角色和菜单之间关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		
		sysRoleMenuDao.insertObject(entity.getId(), menuIds);
		//4.返回结果
		return rows;
	}
	
	@Override
	 public int saveObject(SysRole entity,Integer[] menuIds) {
    	//1.合法性验证
    	if(entity==null){
    		throw new ServiceException("保存数据不能为空");
    	}
    	if(StringUtils.isEmpty(entity.getName())){
    		throw new ServiceException("角色名不能为空");
    	}
    	if(menuIds ==null ||menuIds.length==0){
    		throw new ServiceException("必须为角色赋予权限");
    	}
    	//2.保存角色自身数据
    	int rows=sysRoleDao.insertObject(entity);
    	//3.保存角色和菜单之间关系数据
    	sysRoleMenuDao.insertObject(
    			entity.getId(),	//来自角色自身信息的写入操作
    			menuIds);//menuIds来自页面用户的选择
    	//4.返回结果
    	return rows;
	 }
	

	@Override
	public SysRoleMenuResult findObjectById(Integer id) {
		//1.合法性验证
		if(id==null||id<=0)
		throw new ServiceException("id的值不合法");
		//2.执行查询
		
		SysRoleMenuResult findObjectById = sysRoleDao.findObjectById(id);
		
		
		//3.验证结果并返回
		if(findObjectById.getRole()==null){
			throw new ServiceException("此记录已经不存在");
		}
		
		return findObjectById;
	}

	@Override
	public List<CheckBox> findObject(Integer id, String name) {
		List<CheckBox> list = sysRoleDao.findObject(id, name);
		return list;
	}
}

















