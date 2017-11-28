package com.sweet.cakeonline.cake.dao;

import java.util.List;

import javax.annotation.Resource;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.CakeStep;


@Repository
public class CakeStepDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<CakeStep> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from CakeStep");
		return q.list();
	}
	
	
	
}
