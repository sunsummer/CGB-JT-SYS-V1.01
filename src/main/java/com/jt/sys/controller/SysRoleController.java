package com.jt.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;
import com.jt.sys.service.SysRoleService;
import com.jt.sys.vo.SysRoleMenuResult;

@Controller
@RequestMapping("/role/")
public class SysRoleController {
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(
			SysRole entity,
			Integer[] menuIds){
		sysRoleService.updateObject(entity, menuIds);
		return new JsonResult("数据保存成功");
	}
	
	//org.apache.shiro.web.mgt.DefaultWebSecurityManager
	//org.apache.shiro.web.mgt.DefaultWebSecurityManager
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("doFindObjectById")
	@ResponseBody
	 public JsonResult doFindObjectById(Integer id){
    	/*Map<String,Object> map=
    	sysRoleService.findObjectById(id);*/
    	
    	SysRoleMenuResult object = sysRoleService.findObjectById(id);
    	
    	return new JsonResult(object);
	 }
	
	/**
	 * 保存角色数据
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
	    		SysRole entity,Integer[] menuIds){
	    	sysRoleService.saveObject(entity,menuIds);
	return new JsonResult("保存成功");    
	}
	
	/**删除角色信息*/
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(
			Integer id){
		sysRoleService.deleteObject(id);
		return new JsonResult("删除成功");
	} 	
	
	/**查询角色id和那么集合*/
	@RequestMapping("doFindRoles")
	@ResponseBody
	public JsonResult doFindRoles(
			Integer id,String name){
		List<CheckBox> list = sysRoleService.findObject(id, name);
		JsonResult jsonResult = new JsonResult(list);
		return jsonResult;
	} 	
	
	@RequestMapping("doFindPageObjects")
    @ResponseBody
	public JsonResult doFindPageObjects(
			          String name,
			          Integer pageCurrent){
	    //模拟耗时操作
	    //try{Thread.sleep(5000);}catch(Exception e){}
		
    	PageObject<SysRole> pageObject=
    		sysRoleService.findPageObjects(
				name,
				pageCurrent);
	    return  new JsonResult(pageObject);
	}//底层会通过jackson将对象转换为json格式的字符串 	
	
	/**
	 * 跳转到添加/修改 界面
	 * @return
	 */
	@RequestMapping("doRoleEditUI")
	public String doRoleEditUI(){
		return "sys/role_edit";
	}
	
	@RequestMapping("doRoleListUI")
	public String doRoleListUI(){
		return "sys/role_list";
	}
}















