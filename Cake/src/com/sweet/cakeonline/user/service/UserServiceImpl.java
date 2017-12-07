package com.sweet.cakeonline.user.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sweet.cakeonline.entity.Users;
import com.sweet.cakeonline.user.dao.UserDaoImpl;

@Service
@Transactional(readOnly=false)
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	
	//添加用户
	public void addUser(Users u){
		 userDaoImpl.saveUser(u.getName(),u.getPassword(),u.getAddress(),u.getEmail()  );
	}
	//分页查找用户
	public List<Users> listUserByPage(int p){
	return userDaoImpl.findAllByPage(p);
	}
	//查找提交订单总数
		public int findUserPageCount() {
			if(userDaoImpl.findUserCount()%8==0) {
				return (int)(userDaoImpl.findUserCount()/8);
			}else {
				return (int)(userDaoImpl.findUserCount()/8+1);	
			}	
		}
	//查找用户
	public List<Users> listUser(){
	return userDaoImpl.findAll();
	}
	//删除一个用户
	public void deleteOneUser(int id) {
		this.userDaoImpl.deleteUser(id);;
	}
	//通过id查找用户
	public Users findUserById(int id) {
		return this.userDaoImpl.findById(id);
	}
	//更新用户信息
	public void updateUserInfo(int userid,String name,String password,String email,String address) {
		this.userDaoImpl.udateUser(userid,name,password,email,address);
	}
}
