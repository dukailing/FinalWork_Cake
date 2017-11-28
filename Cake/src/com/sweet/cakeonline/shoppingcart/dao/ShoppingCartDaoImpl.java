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
	
	public List<ShoppingCart> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("ShoppingCart");

		q.setFirstResult(0);
		q.setMaxResults(9);
		
		return q.list();
	}
	public int findRowsCount(){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from ShoppingCart");
		return Integer.parseInt(qc.toString());
	} 	
	public void deleteShop(ShoppingCart c) {
		this.sessionFactory.getCurrentSession().delete(c);
	}
	public void updateShop(ShoppingCart c) {
		this.sessionFactory.getCurrentSession().update(c);
	}
	public void saveShop(ShoppingCart c) {
		this.sessionFactory.getCurrentSession().save(c);
	}

}
