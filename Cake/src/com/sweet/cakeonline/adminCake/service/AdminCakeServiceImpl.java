package com.sweet.cakeonline.adminCake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sweet.cakeonline.adminCake.dao.AdminCakeDaoImpl;
import com.sweet.cakeonline.entity.Cake;

@Service
@Transactional(readOnly=false)
public class AdminCakeServiceImpl {
	@Resource
	private AdminCakeDaoImpl adminCakeDaoImpl;
	//查找所有蛋糕
	public List<Cake> listAll(int p){
		return this.adminCakeDaoImpl.findAll(p);
	}
	//删除一个蛋糕
	public void deleteOneCake(int id) {
		this.adminCakeDaoImpl.deleteCake(id);
	}
	//更新一个蛋糕
	public void updateOneCake(Cake c) {
		this.adminCakeDaoImpl.updateCake(c);
	}
	//增加蛋糕
	public void addOneCake(Cake c) {
		this.adminCakeDaoImpl.saveCake(c);
	}
	//得到总页码数
	public int getPageCount() {
		if((this.adminCakeDaoImpl.findRowsCount())%9==0) {
			return (int)(this.adminCakeDaoImpl.findRowsCount()/9);
		}else {
			return (int)(this.adminCakeDaoImpl.findRowsCount()/9+1);	
			}	
	}
}
