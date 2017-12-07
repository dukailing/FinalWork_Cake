package com.sweet.cakeonline.shoppingcart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.ShoppingCart;

@Repository
public class ShoppingCartDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<ShoppingCart> findAll(int p,int userid){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from ShoppingCart where userid="+userid);

		q.setFirstResult((p-1)*3);
		q.setMaxResults(3);
		
		return q.list();
	}

	//删除一个订单
	public void deleteShop(ShoppingCart c) {
		this.sessionFactory.getCurrentSession().delete(c);
	}
	//通过订单编号查找订单
	public ShoppingCart findById(int id) {
		ShoppingCart sh=this.sessionFactory.getCurrentSession().get(ShoppingCart.class,id);
		return sh;
		
	}
	//查询所有购物车订单总数
		public int findShopCount(int userid){
			Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(sid) from ShoppingCart where userid="+userid);
			Number number = (Number)qc.uniqueResult();
			int count = number.intValue();
			return count;
		} 	
	public void updateShop(ShoppingCart c) {
		this.sessionFactory.getCurrentSession().update(c);
	}
	public void saveShop(ShoppingCart c) {
		this.sessionFactory.getCurrentSession().save(c);
	}
	//清空购物车
	public void deleteShoppingCart(int userid) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("delete from ShoppingCart where userid="+userid);
		q.executeUpdate();

	}

}
