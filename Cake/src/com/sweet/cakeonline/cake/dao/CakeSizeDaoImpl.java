package com.sweet.cakeonline.cake.dao;

import java.util.List;

import javax.annotation.Resource;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.CakeSize;

@Repository
public class CakeSizeDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查询所有蛋糕size
	 * @return
	 */
	public List<CakeSize> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from CakeSize");
		return q.list();
	}
	/**
	 * 查询某蛋糕尺寸的蛋糕
	 * @param sizeid
	 * @return
	 */
	public List<Cake> findBySize(int sizeid){
		Query q=this.sessionFactory.getCurrentSession().createQuery("select CakeSet from CakeSize where sizeid="+sizeid);
		return q.list();
	}
	
	
}
