package com.jt.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.order.entity.Order;

public interface OrderDao {
	
	/**删除指定id的条目信息*/
	public int deleteById(Integer id);
	
	
	/**
	 * 分页查询指定shows信息的订单
	 * @return List<Order>
	 */
	public List<Order> findOrderAll(
		@Param("shows")String  shows,
		@Param("startIndex")Integer startIndex,
		@Param("pageSize")Integer pageSize);
	
	/**统计总记录数*/
	int getRowCount(@Param("shows")String shows);
	
	/**修改指定id的shows值*/
	public int updateShowsById(
			@Param("id")Integer id,
			@Param("shows")String shows);
}
