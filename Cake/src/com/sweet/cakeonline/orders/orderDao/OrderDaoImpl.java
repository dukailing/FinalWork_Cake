package com.sweet.cakeonline.orders.orderDao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Orders;
import com.sweet.cakeonline.entity.ShoppingCart;

@Repository
public class OrderDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查找属于某用户的所有已提交订单
	 * @param page
	 * @param userid
	 * @return
	 */
	public List<Orders> findAll(int page,int userid){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders where userid="+userid);
		//分页
		q.setFirstResult((page-1)*3);
		q.setMaxResults(3);		
		return q.list();
	}
	/**
	 * 查找订单总数
	 * @param userid
	 * @return
	 */
	public int findOrderCount(int userid){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(oid) from Orders where userid="+userid);
		Number number = (Number)qc.uniqueResult();
		int count = number.intValue();
		return count;
	} 	
	/**
	 * 保存一个订单
	 * @param order
	 */
	public void saveOrder(Orders order) {
		this.sessionFactory.getCurrentSession().save(order);
	}
	
}
