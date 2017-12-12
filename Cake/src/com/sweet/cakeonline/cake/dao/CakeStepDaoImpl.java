package com.sweet.cakeonline.cake.dao;

import java.util.List;

import javax.annotation.Resource;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.CakeStep;


@Repository
public class CakeStepDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查找所有蛋糕step
	 * @return
	 */
	public List<CakeStep> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from CakeStep");
		return q.list();
	}	
	/**
	 * 查询某种蛋糕setp的蛋糕
	 * @param typeid
	 * @return
	 */
	public List<Cake> findByStep(int stepid){
		Query q=this.sessionFactory.getCurrentSession().createQuery
		    ("select c.CakeList from CakeStep c where c.stepid="+stepid);
		return q.list();
	}
}
