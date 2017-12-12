package com.sweet.cakeonline.orders.orderService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sweet.cakeonline.cake.dao.CakeDaoImpl;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Orders;
import com.sweet.cakeonline.orders.orderDao.OrderDaoImpl;
@Repository
@Transactional(readOnly=false)
public class OrderServiceImpl {
	@Resource
	private OrderDaoImpl orderDaoImpl;
	/**
	 * 查找某用户所有蛋糕订单
	 * @param page
	 * @param userid
	 * @return
	 */
	public List<Orders> listAll(int page,int userid){
		return this.orderDaoImpl.findAll(page,userid);
	}
	/**
	 * 查找提交订单总数
	 * @param userid
	 * @return
	 */
	public int findOrderPageCount(int userid) {
		if(this.orderDaoImpl.findOrderCount(userid)%3==0) {
			return (int)(this.orderDaoImpl.findOrderCount(userid)/3);
		}else {
		return (int)(this.orderDaoImpl.findOrderCount(userid)/3+1);	
		}
	}
	/**
	 * 增加订单
	 * @param order
	 */
	public void addOneOrder(Orders order) {
		this.orderDaoImpl.saveOrder(order);
	}
}

