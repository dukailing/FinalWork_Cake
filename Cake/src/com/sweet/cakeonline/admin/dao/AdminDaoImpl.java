package com.sweet.cakeonline.admin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public class AdminDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	//查找所有管理员
		public List findAll(){
			int p=0;
				Query q=this.sessionFactory.getCurrentSession().createQuery("from Admin");
				q.setFirstResult((p-1)*9);
				q.setMaxResults(9);
				return q.list();
			}
}
