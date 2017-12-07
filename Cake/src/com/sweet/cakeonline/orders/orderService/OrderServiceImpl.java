package com.sweet.cakeonline.orders.orderService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.cake.dao.CakeDaoImpl;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Orders;
import com.sweet.cakeonline.orders.orderDao.OrderDaoImpl;
@Repository
public class OrderServiceImpl {
	@Resource
	private OrderDaoImpl orderDaoImpl;
	//查找某用户所有蛋糕订单
	public List<Orders> listAll(int p,int userid){
		return this.orderDaoImpl.findAll(p,userid);
	}
	//查找提交订单总数
	public int findOrderPageCount(int userid) {
		if(this.orderDaoImpl.findOrderCount(userid)%3==0) {
			return (int)(this.orderDaoImpl.findOrderCount(userid)/3);
		}else {
		return (int)(this.orderDaoImpl.findOrderCount(userid)/3+1);	
		}
	}
//	//查找所有订单
//	public List<Orders> listAllOrders(int p){
//		return this.orderDaoImpl.findAllOrders(p);
//	}
//	//删除一个蛋糕
//	public void deleteOneOrder(Orders o) {
//		this.orderDaoImpl.deleteOrder(o);
//	}
//	//更新一个蛋糕
//	public void updateOneOrder(Orders o) {
//		this.orderDaoImpl.updateOrder(o);
//	}
	//增加蛋糕
	public void addOneOrder(Orders o) {
		this.orderDaoImpl.saveOrder(o);
	}
}

