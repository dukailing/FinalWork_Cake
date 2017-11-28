package com.sweet.cakeonline.cake.dao;

import java.util.List;

import javax.annotation.Resource;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.CakeType;

@Repository
public class CakeTypeDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<CakeType> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from CakeType");
		return q.list();
	}
	
	
	
}
