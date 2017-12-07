package com.sweet.cakeonline.adminOrders.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Orders;
@Repository
public class AdminOrdersDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	//查找已提交的所有订单
	public List<Orders> findAllOrders(int p){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders");
		//分页
		q.setFirstResult((p-1)*8);
		q.setMaxResults(8);
		
		return q.list();
	}
	
	//查找属于某用户的所有已提交订单
	public List<Orders> findAll(int p,int userid){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders where userid="+userid);
		//分页
		q.setFirstResult((p-1)*8);
		q.setMaxResults(8);
		
		return q.list();
	}
	//查找订单总数
	public int findOrderCount(){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(oid) from Orders");
		Number number = (Number)qc.uniqueResult();
		int count = number.intValue();
		return count;
	} 	
	//删除一个订单
		public void deleteOrder(int id) {
			Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Orders where oid="+id);
			q.executeUpdate();
		}
		//更新一个订单
		public void updateOrder(Orders o) {
			this.sessionFactory.getCurrentSession().update(o);
		}
		//保存一个订单
		public void saveOrder(Orders o) {
			this.sessionFactory.getCurrentSession().save(o);
		}
}
