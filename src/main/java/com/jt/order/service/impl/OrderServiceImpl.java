package com.jt.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.order.dao.OrderDao;
import com.jt.order.entity.Order;
import com.jt.order.service.OrderService;
import com.jt.sys.entity.SysLog;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public int deleteById(Integer id) {
		//1. 验证参数的有效性
		if(id==null||id<1){
			throw new IllegalArgumentException("id值不正确");
		}
		//2. 执行删除操作
		int rows = orderDao.deleteById(id);
		if(rows==0){
			throw new ServiceException("订单数据可能已经被删除了");
		}
		//3. 返回结果集合
		return rows;
	}

	/**
	 * 返回所有订单列表信息
	 */
	@Override
	public PageObject<Order> findOrderAll(
			String shows,Integer pageCurrent) {
		//1.参数有效性验证(只验证pageCurrent)
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.查询总记录数并进行验证
		int rowCount=orderDao.getRowCount(shows);
		if(rowCount==0){
			throw new ServiceException("没有对应记录");
		}
		//3.查询当前页日志数据
		int pageSize=10;
		int startIndex=(pageCurrent-1)*pageSize;
		List<Order> records=
			orderDao.findOrderAll(shows,startIndex,pageSize);
		
		//4.对查询结果进行封装
		PageObject<Order> po=new PageObject<Order>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageSize(pageSize);
		po.setPageCurrent(pageCurrent);
		po.setPageCount((rowCount-1)/pageSize+1);
		//5.返回结果
		return po;
	}

	@Override
	public int updateShowsById(String shows, Integer id) {
		//1. 验证数据有效性
		if(id==null||id<1){
			throw new IllegalArgumentException("id值不正确");
		}
		//2. 执行sql操作
		if("true".equals(shows)){//反转shows参数值(显示/隐藏当前条目信息)
			shows = "false";
		} else {
			shows = "true";
		}
		int rows = orderDao.updateShowsById(id, shows);
		if(rows==0){
			throw new ServiceException("订单可能已经不存在了");
		}
		//3. 返回结果集
		return rows;
	}

}

















