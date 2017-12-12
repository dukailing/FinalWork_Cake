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
	/**
	 * 分页查询所有蛋糕
	 * @param page
	 * @return
	 */
	public List<Cake> findAll(int page){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake");
		q.setFirstResult((page-1)*9);
		q.setMaxResults(9);	
		return q.list();
	}	
	/**
	 * 通过id查询蛋糕
	 * @param id
	 * @return cake
	 */
	public Cake selectByCakeid(int id) {
		return this.sessionFactory.getCurrentSession().get(Cake.class,id);
	}
    /**
     * 查询所有蛋糕总数
     * @return
     */
    public int findRowsCount(){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from Cake");
		Number number = (Number)qc.uniqueResult();
		int count = number.intValue();
		return count;
	} 	
    /**
     * 删除一个蛋糕品种
     * @param id
     */
    public void deleteCake(int id) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Cake where id="+id);
		q.executeUpdate();
	}
    /**
     * 更新一个蛋糕品种
     * @param cake
     */
	public void updateCake(Cake cake) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(cake);
	}
	/**
	 * 增加一个蛋糕品种
	 * @param cake
	 */
	public void saveCake(Cake cake) {
		this.sessionFactory.getCurrentSession().save(cake);
	}
}
