package com.sweet.cakeonline.orders.orderDao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Orders;

@Repository
public class OrderDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Orders> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders");
		return q.list();
	}
	public void deleteOrder(Orders o) {
		this.sessionFactory.getCurrentSession().delete(o);
	}
	public void updateOrder(Orders o) {
		this.sessionFactory.getCurrentSession().update(o);
	}
	public void saveOrder(Orders o) {
		this.sessionFactory.getCurrentSession().save(o);
	}
	
}
