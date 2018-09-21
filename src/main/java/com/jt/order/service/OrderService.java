package com.jt.order.service;

import com.jt.common.vo.PageObject;
import com.jt.order.entity.Order;

public interface OrderService {
	
	/**删除指定id的订单信息*/
	public int deleteById(Integer id);
	
	/**
	 * 分页查询所有订单信息
	 * @return List<Order>
	 */
	public PageObject<Order> findOrderAll(
		String show,Integer pageCurrent);
	
	
	public int updateShowsById(String shows,Integer id);
}
