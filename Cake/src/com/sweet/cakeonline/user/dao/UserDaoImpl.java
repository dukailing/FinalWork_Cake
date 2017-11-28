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
	//通过姓名查找用户
	public Users findByName(String name){
//		return super.get(loginName);
		Users user=this.sessionFactory.getCurrentSession().get(Users.class, name);
		//Query q=this.sessionFactory.getCurrentSession().createQuery("from Users");  
		return user;
	}
	//通过Id查找用户
	public Users findById(int id){
//		return super.get(loginName);
		Users user=this.sessionFactory.getCurrentSession().get(Users.class, id);
		return user;
	}
	//查找所有 用户
	public List findAll(){
//			return super.get(loginName);
			Query q=this.sessionFactory.getCurrentSession().createQuery("from Users");
			return q.list();
		}
	//保存用户数据
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
	//删除用户数据
	public void deleteUser(Users u) {
	     this.sessionFactory.getCurrentSession().delete(u);
		}
	//更新用户数据
	public void udateUser(Users u) {
	     this.sessionFactory.getCurrentSession().update(u);
	    }
}
