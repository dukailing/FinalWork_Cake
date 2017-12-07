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
	//分页查询所有蛋糕
	public List<Cake> findAll(int p){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake");

		q.setFirstResult((p-1)*9);
		q.setMaxResults(9);
		
		return q.list();
	}	
	//通过种类分类查询
	public List<Cake> findByType(int typeid,int p){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake where typeid="+typeid);
		q.setFirstResult((p-1)*9);
		q.setMaxResults(9);
		return q.list();
	}
	//通过尺寸分类查询
	public List<Cake> findBySize(int sizeid,int p){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake where sizeid="+sizeid);
		q.setFirstResult((p-1)*9);
		q.setMaxResults(9);
		return q.list();
	}
	//通过层数分类查询
	public List<Cake> findByStep(int stepid,int p){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake where stepid="+stepid);
		q.setFirstResult((p-1)*9);
		q.setMaxResults(9);
		return q.list();
	}
	 
	//查询所有蛋糕总数
	public int findRowsCount(){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from Cake");
		Number number = (Number)qc.uniqueResult();
		int count = number.intValue();
		return count;
	} 	
	//查询属于某类的蛋糕总数
	public int findTypeCakeRowsCount(int typeid){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from Cake where typeid="+typeid);
		Number number = (Number)qc.uniqueResult();
		int count = number.intValue();
		return count;
	} 	
	//查询属于某尺寸的蛋糕总数
		public int findSizeCakeRowsCount(int sizeid){
			Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from Cake where sizeid="+sizeid);
			Number number = (Number)qc.uniqueResult();
			int count = number.intValue();
			return count;
		} 	
	//查询属于某层数的蛋糕总数
		public int findStepCakeRowsCount(int stepid){
			Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from Cake where stepid="+stepid);
			Number number = (Number)qc.uniqueResult();
			int count = number.intValue();
			return count;
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

}
