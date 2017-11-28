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
	//查找所有蛋糕
	public List<Orders> listAll(){
		return this.orderDaoImpl.findAll();
	}
	//删除一个蛋糕
	public void deleteOneOrder(Orders o) {
		this.orderDaoImpl.deleteOrder(o);
	}
	//更新一个蛋糕
	public void updateOneOrder(Orders o) {
		this.orderDaoImpl.updateOrder(o);
	}
	//增加蛋糕
	public void addOneOrder(Orders o) {
		this.orderDaoImpl.saveOrder(o);
	}
}

