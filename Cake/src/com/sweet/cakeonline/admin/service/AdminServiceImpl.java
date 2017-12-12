package com.sweet.cakeonline.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sweet.cakeonline.admin.dao.AdminDaoImpl;
import com.sweet.cakeonline.entity.Admin;
import com.sweet.cakeonline.entity.Users;
@Service
public class AdminServiceImpl {
	@Resource
	private AdminDaoImpl adminDaoImpl;
	/**
	 * 查找管理员
	 * @return adminList
	 */
	public List<Admin> listAdmin(){
	    return adminDaoImpl.findAll();
	}
}
