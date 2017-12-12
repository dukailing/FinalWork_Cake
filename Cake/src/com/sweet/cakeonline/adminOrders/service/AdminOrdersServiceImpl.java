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
	/**
	 *  查找所有订单
	 * @return
	 */
	public List<Orders> listAllOrders(){
		return this.adminOrdersDaoImpl.findAllOrders();
	}
	/**
	 * 通过id查询订单
	 * @param id
	 * @return
	 */
	public Orders selectByOrderid(int id) {
		return this.selectByOrderid(id);
	}
	/**
	 * 查找某用户所有蛋糕订单
	 * @param page
	 * @param userid
	 * @return
	 */
	public List<Orders> listAll(int page,int userid){
		return this.adminOrdersDaoImpl.findAll(page,userid);
	}
	/**
	 * 查找提交订单总数
	 * @return
	 */
	public int findOrderPageCount() {
		if(adminOrdersDaoImpl.findOrderCount()%8==0) {
			return (int)(adminOrdersDaoImpl.findOrderCount()/8);
		}else {
			return (int)(adminOrdersDaoImpl.findOrderCount()/8+1);	
		}	
	}
	/**
	 * 查找所有订单
	 * @param page
	 * @return
	 */
	public List<Orders> listAllOrders(int page){
		return this.adminOrdersDaoImpl.findAllOrders(page);
	}
	/**
	 * 删除一个蛋糕
	 * @param id
	 */
	public void deleteOneOrder(int id) {
		this.adminOrdersDaoImpl.deleteOrder(id);
	}
	/**
	 * 更新一个蛋糕
	 * @param order
	 */
	public void updateOneOrder(Orders order) {
		this.adminOrdersDaoImpl.updateOrder(order);
	}
	/**
	 * 增加或修改蛋糕订单 
	 * @param order
	 */
	public void addOneOrder(Orders order) {
		this.adminOrdersDaoImpl.saveOrder(order);
	}
}
