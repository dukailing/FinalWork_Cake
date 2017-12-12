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
	/**
	 * 分页查询所有购物车内订单
	 * @param page
	 * @param userid
	 * @return
	 */
	public List<ShoppingCart> findAll(int page,int userid){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from ShoppingCart where userid="+userid);
		q.setFirstResult((page-1)*3);
		q.setMaxResults(3);		
		return q.list();
	}
	/**
	 * 删除一个订单
	 * @param sc
	 */
	public void deleteShop(ShoppingCart sc) {
		this.sessionFactory.getCurrentSession().delete(sc);
	}
	/**
	 * 通过订单编号查找订单
	 * @param id
	 * @return
	 */
	public ShoppingCart findById(int id) {
		ShoppingCart sh=this.sessionFactory.getCurrentSession().get(ShoppingCart.class,id);
		return sh;		
	}
	/**
	 * 查询所有购物车订单总数
	 * @param userid
	 * @return
	 */
		public int findShopCount(int userid){
			Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(sid) from ShoppingCart where userid="+userid);
			Number number = (Number)qc.uniqueResult();
			int count = number.intValue();
			return count;
		} 
	/**
	 * 更新购物车
	 * @param c
	 */
	public void updateShop(ShoppingCart sc) {
		this.sessionFactory.getCurrentSession().update(sc);
	}
	/**
	 * 保存购物车
	 * @param sc
	 */
	public void saveShop(ShoppingCart sc) {
		this.sessionFactory.getCurrentSession().save(sc);
	}
	/**
	 * 清空购物车
	 * @param userid
	 */
	public void deleteShoppingCart(int userid) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("delete from ShoppingCart where userid="+userid);
		q.executeUpdate();
	}
}
