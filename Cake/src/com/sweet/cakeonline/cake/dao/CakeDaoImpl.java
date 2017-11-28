package com.sweet.cakeonline.cake.dao;

import java.util.List;

import javax.annotation.Resource;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Cake;

@Repository
public class CakeDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public List<Cake> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake");

		q.setFirstResult(0);
		q.setMaxResults(9);
		
		return q.list();
	}
	
	public int findRowsCount(){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from Cake");
		return Integer.parseInt(qc.toString());
	} 	
	public void deleteCake(Cake c) {
		this.sessionFactory.getCurrentSession().delete(c);
	}
	public void updateCake(Cake c) {
		this.sessionFactory.getCurrentSession().update(c);
	}
	public void saveCake(Cake c) {
		this.sessionFactory.getCurrentSession().save(c);
	}
	
	/**
     * 分页查询
     * @param hql 查询的条件
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return 返回查询记录集合
     */
   @SuppressWarnings("unchecked")
   public List<Cake> queryForPage(int offset, int length) {
       // TODO Auto-generated method stub
       List<Cake> entitylist=null;
       try{
           Query query = this.sessionFactory.getCurrentSession().createQuery("from Course");
           query.setFirstResult(offset);
           query.setMaxResults(length);
           entitylist = query.list();
           
       }catch(RuntimeException re){
           throw re;
       }
       
       return entitylist;
   }
}
