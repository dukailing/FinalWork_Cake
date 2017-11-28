package com.sweet.cakeonline.user.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sweet.cakeonline.entity.Users;
import com.sweet.cakeonline.user.dao.UserDaoImpl;

@Service
//@Transactional(readOnly=true)
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	
//	public Users login(String name, String pwd){
//		Users lu=this.userDaoImpl.findByName(name);
//		if(lu!=null){
//			if(lu.getPassword().equals(pwd)){
//				return lu;
//			}else{
//				return null;
//			}
//		}else{
//			return null;
//		}
//	}
	//添加用户
	public void addUser(Users u){
		 userDaoImpl.saveUser(u.getName(),u.getPassword(),u.getAddress(),u.getEmail()  );
	}
	//查找用户
	public List<Users> listUser(){
	return userDaoImpl.findAll();
	}
}
