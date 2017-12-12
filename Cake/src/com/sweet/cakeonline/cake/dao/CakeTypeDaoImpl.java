package com.sweet.cakeonline.cake.dao;

import java.util.List;

import javax.annotation.Resource;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.CakeType;

@Repository
public class CakeTypeDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查找所有蛋糕类型
	 * @return
	 */
	public List<CakeType> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from CakeType");
		return q.list();
	}
	/**
	 * 查询某蛋糕种类的蛋糕
	 * @param typeid
	 * @return
	 */
	public List<Cake> findByType(int typeid){
		Query q=this.sessionFactory.getCurrentSession().createQuery
		    ("select c.CakeList from CakeType c where c.typeid="+typeid);
		return q.list();
	}
	
	
}
