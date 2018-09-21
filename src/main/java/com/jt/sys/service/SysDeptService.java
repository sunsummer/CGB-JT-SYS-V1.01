package com.jt.sys.service;
import java.util.List;
import java.util.Map;
import com.jt.common.vo.Node;
import com.jt.sys.entity.SysDept;

public interface SysDeptService {
	int deleteObject(Integer id);
	List<Map<String,Object>> findObjects();
	
	List<Node> findZTreeNodes();
	int saveObject(SysDept entity);
	
	int updateObject(SysDept entity);
}
