package com.sweet.cakeonline.adminCake.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sweet.cakeonline.entity.Cake;
@Repository
public class AdminCakeDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	//分页查询所有蛋糕
	public List<Cake> findAll(int p){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake");
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

	//删除一个蛋糕品种
	public void deleteCake(int id) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Cake where id="+id);
		q.executeUpdate();
	}
	//更新一个蛋糕品种
	public void updateCake(Cake c) {
		this.sessionFactory.getCurrentSession().update(c);
	}
	//增加一个蛋糕品种
	public void saveCake(Cake c) {
		this.sessionFactory.getCurrentSession().save(c);
	}
}
