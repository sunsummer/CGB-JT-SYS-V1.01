package com.jt.sys.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysRole;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import com.jt.sys.vo.SysUserDeptResult;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Resource
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public PageObject<SysUserDeptResult> findPageObjects(
			String username, 
			Integer pageCurrent) {
		//1.数据合法性验证
		if(pageCurrent==null||pageCurrent<=0)
		throw new ServiceException("参数不合法");
		//2.依据条件获取总记录数
		int rowCount=sysUserDao.getRowCount(username);
        if(rowCount==0)
		throw new ServiceException("记录不存在");
		//3.计算startIndex的值
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		//4.依据条件获取当前页数据
		List<SysUserDeptResult> records = 
			sysUserDao.findPageObjects(username, startIndex, pageSize);
		
		//5.封装数据
		PageObject<SysUserDeptResult> pageObject = new PageObject<>();
		
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		//pageObject.setRowCount(rowCount);
		
		return pageObject;
	}

	@Override
	public int validById(
			Integer id, 
			Integer valid,
			String modifiedUser) {
		//1. 数据合法性验证
		if(id==null||id<1){
			throw new ServiceException("id参数不合法");
		}
		if(valid==null||(valid!=1&&valid!=0)){
			throw new ServiceException("valid参数不合法");
		}
		if(StringUtils.isEmpty(modifiedUser)){
			throw new ServiceException("修改用户不能为空");
		}
		//2. 依据id修改标记值
		int rows = sysUserDao.validById(id, valid, modifiedUser);
		//3. 判断返回结果集
		if(rows==0){
			throw new ServiceException("用户状态修改失败");
		}
		//4. 返回结果集
		return rows;
	}

	/**
	 * 查询所有角色信息
	 */
	@Override
	public List<SysRole> findRoleAll() {
		List<SysRole> list = sysUserDao.findRoleAll();
		return list;
	}

	@Override
	public int saveObject(SysUser entity, Integer... roleIds) {
		//1.验证数据合法性
		if(entity==null){
			throw new ServiceException("保存对象不能为空");
		}
		if(StringUtils.isEmpty(entity.getUsername())){
			throw new ServiceException("用户名不能为空");
		}
		if(StringUtils.isEmpty(entity.getPassword())){
			throw new ServiceException("密码不能为空");
		}
        if(roleIds==null || roleIds.length==0){
        	throw new ServiceException("至少要为用户分配角色");
        }
        
		//2.将数据写入数据库
		String salt=UUID.randomUUID().toString();
		entity.setSalt(salt);
		//加密(shiro中的api)
			//DigestUtils.md5DigestAsHex(inputStream)	//spring自带的md5加密算法
		SimpleHash sHash=new SimpleHash(
			"MD5",					//加密方法
			entity.getPassword(),	//密码
			salt);					//盐值
		entity.setPassword(sHash.toHex());	//密码转换为16进制输出

		int rows=sysUserDao.insertObject(entity);
	    sysUserRoleDao.insertObject(
				entity.getId(),	//获取userid
				roleIds);		//"1,2,3,4";
	    
		//3.返回结果
		return rows;
	}

	@Override
	public Map<String, Object> findObjectById(Integer userId) {
		//1.合法性验证
		if(userId==null||userId<=0)
		throw new ServiceException(
		"参数数据不合法,userId="+userId);
		//2.业务查询
		SysUserDeptResult user=
		sysUserDao.findObjectById(userId);
		if(user==null)
		throw new ServiceException("此用户已经不存在");
		List<Integer> roleIds=
		sysUserRoleDao.findRoleIdsByUserId(userId);
		//3.数据封装
		Map<String,Object> map=new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}

	@Override
	public int updateObject(SysUser entity, Integer... roleIds) {
		//1.合法验证
	    if(entity==null){
	    	throw new ServiceException("用户信息不能为空");
	    }
	    if(StringUtils.isEmpty(entity.getUsername())){
	    	throw new ServiceException("用户名不能为空");
	    }
	    //用户名已经存在的验证,尝试自己实现.
	    if(StringUtils.isEmpty(roleIds)){
	    	throw new ServiceException("用户必须选一个角色");
	    }
	    
	    /*if(!StringUtils.isEmpty(entity.getPassword())){
	    	//对密码加密
	    	String salt=UUID.randomUUID().toString();
	    	SimpleHash hash=//shiro
	    	new SimpleHash(
	    			"MD5",
	    			entity.getPassword(),
	    			salt);
	    	entity.setPassword(hash.toString());
	    }*/
	    
		//2.更新数据
	    int rows=0;
	    
	    try{
		    rows=sysUserDao.updateObject(entity);
		    //删除用户和角色关系数据
		    	//sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		    
		    sysUserRoleDao.deleteObjectsById("user_id", entity.getId());
		    
		    //添加用户和角色关系数据
		    sysUserRoleDao.insertObject(
		    entity.getId(),roleIds);
	    }catch(Throwable e){
			e.printStackTrace();
			//发起报警信息
			throw new ServiceException("服务端现在异常,请稍后访问");
	    }
		//3.返回结果
		return rows;
	}
}





















