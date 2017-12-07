package com.sweet.cakeonline.adminOrders.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sweet.cakeonline.adminOrders.dao.AdminOrdersDaoImpl;
import com.sweet.cakeonline.entity.Orders;

@Repository
@Transactional(readOnly=false)
public class AdminOrdersServiceImpl {
	@Resource
	private AdminOrdersDaoImpl adminOrdersDaoImpl;
	//查找某用户所有蛋糕订单
		public List<Orders> listAll(int p,int userid){
			return this.adminOrdersDaoImpl.findAll(p,userid);
		}
		//查找提交订单总数
		public int findOrderPageCount() {
			if(adminOrdersDaoImpl.findOrderCount()%8==0) {
				return (int)(adminOrdersDaoImpl.findOrderCount()/8);
			}else {
				return (int)(adminOrdersDaoImpl.findOrderCount()/8+1);	
				}	

		}
		//查找所有订单
		public List<Orders> listAllOrders(int p){
			return this.adminOrdersDaoImpl.findAllOrders(p);
		}
		//删除一个蛋糕
		public void deleteOneOrder(int id) {
			this.adminOrdersDaoImpl.deleteOrder(id);
		}
		//更新一个蛋糕
		public void updateOneOrder(Orders o) {
			this.adminOrdersDaoImpl.updateOrder(o);
		}
		//增加蛋糕dingdan 
		public void addOneOrder(Orders o) {
			this.adminOrdersDaoImpl.saveOrder(o);
		}
}
