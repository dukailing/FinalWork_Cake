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
	/**
	 * 查找所有蛋糕
	 * @param page
	 * @return
	 */
	public List<Cake> listAll(int page){
		return this.adminCakeDaoImpl.findAll(page);
	}
	/**
	 * 删除一个蛋糕
	 * @param id
	 */
	public void deleteOneCake(int id) {
		this.adminCakeDaoImpl.deleteCake(id);
	}
	/**
	 * 更新一个蛋糕
	 * @param cake
	 */
	public void updateOneCake(Cake cake) {
		this.adminCakeDaoImpl.updateCake(cake);
	}
	/**
	 * 增加蛋糕
	 * @param cake
	 */
	public void addOneCake(Cake cake) {
		this.adminCakeDaoImpl.saveCake(cake);
	}
	/**
	 * 通过id查询蛋糕
	 * @return
	 */
	public Cake getCakeById(int id) {
	return this.adminCakeDaoImpl.selectByCakeid(id);
	}
	/**
	 * 得到总页码数
	 * @return
	 */
	public int getPageCount() {
        if((this.adminCakeDaoImpl.findRowsCount())%9==0) {
		    return (int)(this.adminCakeDaoImpl.findRowsCount()/9);
		}else {
		    return (int)(this.adminCakeDaoImpl.findRowsCount()/9+1);	
		}	
	}
}
