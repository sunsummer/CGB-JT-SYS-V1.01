package com.jt.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.order.entity.Order;
import com.jt.order.service.OrderService;

@RequestMapping("/order/")
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 返回添加订单界面
	 * @return
	 */
	@RequestMapping("doOrderEditUI")
	public String doAddUI(){
		return "order/order_edit";
	};
    
    /**
	 * 删除是定id的订单数据
	 * @param show
	 * @return
	 */
	@RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
    	orderService.deleteById(id);
    	return new JsonResult("订单信息删除成功");
    };
	
	/**
	 * 查询所有订单信息列表
	 * @param show 订单信息是否显示(true 显示/false 不显示)
	 * @return
	 */
	@RequestMapping("doFindOrderList")
    @ResponseBody
    public JsonResult doFindOrderList(
    		String shows,Integer pageCurrent){
		PageObject<Order> list = orderService.findOrderAll(shows, pageCurrent);
    	return new JsonResult(list);
    };
	
	/**
	 * 返回订单列表界面
	 * @return
	 */
	@RequestMapping("doListUI")
	public String doListUI(){
		return "order/order_list";
	}
	
	/**
	 * 返回订单回收站界面
	 * @return
	 */
	@RequestMapping("doRecoveryLidtUI")
	public String doRecoveryLidtUI(){
		return "order/order_recoveryList";
	}
	
	/**
     * 修改指定id的shows值
     * @param show
     * @return
     */
    @RequestMapping("doUpdateShowsById")
    @ResponseBody
    public JsonResult doUpdateShowsById(
    		String shows,Integer id){
    	
    	orderService.updateShowsById(shows, id);
    	
    	//返回结果集
    	String value = "订单删除成功";
    	if("false".equals(shows)){
    		value = "订单恢复成功";
    	}
    	return new JsonResult(value);
    }
}
