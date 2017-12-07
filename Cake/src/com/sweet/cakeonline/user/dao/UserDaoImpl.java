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
	//分页查找所有 用户
	public List findAllByPage(int p){
			Query q=this.sessionFactory.getCurrentSession().createQuery("from Users");
			q.setFirstResult((p-1)*8);
			q.setMaxResults(8);
			return q.list();
		}
	//查找订单总数
		public int findUserCount(){
			Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(id) from Users");
			Number number = (Number)qc.uniqueResult();
			int count = number.intValue();
			return count;
		} 	
	//查找所有 用户
	public List findAll(){
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
	public void deleteUser(int id) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Users where id="+id);
		q.executeUpdate();
		}
	//通过id更新用户数据

	public void udateUser(int userid,String name,String password,String email,String address) {
//	   this.sessionFactory.getCurrentSession().update(u);
	 Query q=this.sessionFactory.getCurrentSession().createQuery("update Users set name=:name,password=:password,"
	 		+ "email=:email,address=:address where id=:id");
		//		,password="+ password+",email="+email+",address="+address+"w
		q.setParameter("name",name);
		q.setParameter("password",password);
		q.setParameter("email", email);
		q.setParameter("address", address);
		q.setParameter("id", userid);
		q.executeUpdate();
	    }
}
