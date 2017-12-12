package com.sweet.cakeonline.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.sweet.cakeonline.entity.Users;

@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 通过姓名查找用户
	 * @param name
	 * @return
	 */
	public Users findByName(String name){
		Users user=this.sessionFactory.getCurrentSession().get(Users.class, name); 
		return user;
	}
	/**
	 * 通过Id查找用户
	 * @param id
	 * @return
	 */
	public Users findById(int id){
		Users user=this.sessionFactory.getCurrentSession().get(Users.class, id);
		return user;
	}
	/**
	 * 分页查找所有 用户
	 * @param page
	 * @return
	 */
	public List findAllByPage(int page){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Users");
		q.setFirstResult((page-1)*8);
		q.setMaxResults(8);
		return q.list();
	}
	/**
	 * 查找订单总数
	 * @return
	 */
	public int findUserCount(){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from Users");
		Number number = (Number)qc.uniqueResult();
		int count = number.intValue();
		return count;
	} 	
	/**
	 * 查找所有 用户
	 * @return
	 */
	public List findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Users");
		return q.list();
	}
	/**
	 * 保存用户数据
	 * @param name
	 * @param password
	 * @param address
	 * @param email
	 */
	public void saveUser(String name,String password,String address,String email){
		Users u=new Users();
		u.setName(name);
		u.setPassword(password);
		u.setAddress(address);
		u.setEmail(email);
	
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.save(u);
		t.commit();
		s.close();
	}
	/**
	 * 删除用户数据
	 * @param id
	 */
	public void deleteUser(int id) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Users where id="+id);
		q.executeUpdate();
		}
	/**
	 * 通过id更新用户数据
	 * @param userid
	 * @param name
	 * @param password
	 * @param email
	 * @param address
	 */
	public void udateUser(int userid,String name,String password,String email,String address) {
	 Query q=this.sessionFactory.getCurrentSession().createQuery("update Users set name=:name,password=:password,"
	 		+ "email=:email,address=:address where id=:id");
		q.setParameter("name",name);
		q.setParameter("password",password);
		q.setParameter("email", email);
		q.setParameter("address", address);
		q.setParameter("id", userid);
		q.executeUpdate();
	}
}
