package com.jt.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import com.jt.sys.vo.SysUserDeptResult;

@RequestMapping("/user/")
@Controller
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("doUserListUI")
	public String doUserListUI(){
		return "sys/user_list";
	}
	
	@RequestMapping("doUserEditUI")
	public String doUserEditUI(){
		return "sys/user_edit";
	}
	
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(
			String username,
			String password){
		
		//1. 封装用户身份信息
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		
		//2. 执行登陆操作
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		
		//登陆成功后顺序执行下列方法
		JsonResult jsonResult = new JsonResult("登陆成功");
		return jsonResult;
	}
	
	/**
	 * 用户界面列表参数请求
	 * @param username		用户名
	 * @param pageCurrent	分页页码
	 * @return				数据结果集合
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
		String username,Integer pageCurrent){
		PageObject<SysUserDeptResult> pageObject = 
			sysUserService.findPageObjects(username,pageCurrent);
		return new JsonResult(pageObject);
	}
	
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id,Integer valid){
		//1. 将参数传给业务层
		sysUserService.validById(id, valid,"admin");
		//2. 将结果封装到jsonResult中
		JsonResult jsonResult = new JsonResult("用户状态修改成功");
		//3. 返回结果集
		return jsonResult;
	}
	/**
	 * 返回角色列表信息
	 */
	@RequestMapping("doFindRoles")
	@ResponseBody
	public JsonResult doFindRoles(){
		List<SysRole> list = sysUserService.findRoleAll();
		return new JsonResult(list);
	}
	
	/**
	 * 修改用户数据
	 */
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			SysUser entity,Integer... roleIds){
		sysUserService.updateObject(entity, roleIds);
		JsonResult jsonResult = new JsonResult("用户修改成功");
		return jsonResult;
	}
	/**
	 * 添加用户数据
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
			SysUser entity,Integer... roleIds){
		sysUserService.saveObject(entity, roleIds);
		JsonResult jsonResult = new JsonResult("用户保存成功");
		return jsonResult;
	}
	
	/**
	 * 根据用户id查询用户数据和角色id
	 */
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(
			Integer id){
		Map<String,Object> map = sysUserService.findObjectById(id);
		JsonResult jsonResult = new JsonResult(map);
		return jsonResult;
	}
}























