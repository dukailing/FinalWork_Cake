package com.sweet.cakeonline.cake.dao;

import java.util.List;

import javax.annotation.Resource;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.CakeSize;

@Repository
public class CakeSizeDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<CakeSize> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from CakeSize");
		return q.list();
	}
	
	
	
}
