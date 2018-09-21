package com.jt.sys.dao;
import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysDept;
public interface SysDeptDao {
	int deleteObject(Integer id);
	List<Map<String,Object>> findObjects();
	List<Node> findZTreeNodes();
	int getChildCount(Integer id);
	int insertObject(SysDept entity);
	int updateObject(SysDept entity);
}
