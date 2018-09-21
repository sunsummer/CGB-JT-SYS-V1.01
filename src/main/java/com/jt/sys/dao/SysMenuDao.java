package com.jt.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;
/**
 * 菜单的持久层对象
 * @author ta
 */
public interface SysMenuDao {
	
	/**
	 * 基于菜单id执行菜单的删除操作
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 查询所有菜单以及菜单对应的上级菜单信息
	 * @return
	 */
	List<Map<String,Object>> findObjects();
	
    /**
     * 查询zTree呈现菜单数据时
     * 需要的菜单节点信息
     * @return
     */
	List<Node> findZtreeMenuNodes();
	
	/**统计此菜单对应的子菜单的个数
	 * @param id 菜单id
	 * @return 菜单的个数
	 */
	int getChildCount(Integer id);
	/**
	 * 写入菜单信息
	 * @param entity
	 * @return
	 */
	int insertObject(SysMenu entity);
	
	
	/**
	 * 修改菜单信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
	
	/**
	 * 基于菜单id获取权限标识
	 * @param menuIds
	 * @return
	 */
	List<String> findPermissionsByMenu(
			@Param("menuIds")Integer... menuIds);
}





