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
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(Users user){
		 userDaoImpl.saveUser(user.getName(),user.getPassword(),user.getAddress(),user.getEmail()  );
	}
	/**
	 * 分页查找用户
	 * @param page
	 * @return
	 */
	public List<Users> listUserByPage(int page){
	    return userDaoImpl.findAllByPage(page);
	}
	/**
	 * 查找提交订单总数
	 * @return
	 */
	public int findUserPageCount() {
		if(userDaoImpl.findUserCount()%8==0) {
			return (int)(userDaoImpl.findUserCount()/8);
		}else {
			return (int)(userDaoImpl.findUserCount()/8+1);	
		}	
	}
	/**
	 * 查找用户
	 * @return
	 */
	public List<Users> listUser(){
	    return userDaoImpl.findAll();
	}
	/**
	 * 删除一个用户
	 * @param id
	 */
	public void deleteOneUser(int id) {
		this.userDaoImpl.deleteUser(id);;
	}
	/**
	 * 通过id查找用户
	 * @param id
	 * @return
	 */
	public Users findUserById(int id) {
		return this.userDaoImpl.findById(id);
	}
	/**
	 * 更新用户信息
	 * @param userid
	 * @param name
	 * @param password
	 * @param email
	 * @param address
	 */
	public void updateUserInfo(int userid,String name,String password,String email,String address) {
		this.userDaoImpl.udateUser(userid,name,password,email,address);
	}
}
