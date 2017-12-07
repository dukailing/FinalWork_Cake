package com.sweet.cakeonline.cake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sweet.cakeonline.cake.dao.CakeDaoImpl;
import com.sweet.cakeonline.entity.Cake;


@Service
@Transactional(readOnly=true)
public class CakeServiceImpl {

	@Resource
	private CakeDaoImpl cakeDaoImpl;
	//查找所有蛋糕
	public List<Cake> listAll(int p){
		return this.cakeDaoImpl.findAll(p);
	}
	//分类查询蛋糕
	public List<Cake> listByType(int typeid,int p){
		return this.cakeDaoImpl.findByType(typeid,p);
	}
	//分类查询蛋糕
		public List<Cake> listBySize(int sizeid,int p){
			return this.cakeDaoImpl.findByType(sizeid,p);
		}
	//分层数查询蛋糕
	public List<Cake> listByStep(int stepid,int p){
			return this.cakeDaoImpl.findByType(stepid,p);
		}
	//删除一个蛋糕
	public void deleteOneCake(Cake c) {
		this.cakeDaoImpl.deleteCake(c);
	}
	//更新一个蛋糕
	public void updateOneCake(Cake c) {
		this.cakeDaoImpl.updateCake(c);
	}
	//增加蛋糕
	public void addOneCake(Cake c) {
		this.cakeDaoImpl.saveCake(c);
	}

	//得到总页码数
	public int getPageCount() {
		 return (int) Math.ceil((this.cakeDaoImpl.findRowsCount())/9);		
	}
	//得到通过分类查询页码总数
	public int getTypeCakePageCount(int typeid) {
		return (int) Math.ceil((this.cakeDaoImpl.findTypeCakeRowsCount(typeid))/3);
	}
	//得到通过分尺寸查询页码总数
		public int getSizeCakePageCount(int sizeid) {
			return (int) Math.ceil((this.cakeDaoImpl.findSizeCakeRowsCount(sizeid)/3));
		}
	//得到通过分尺寸查询页码总数
		public int getStepCakePageCount(int stepid) {
			return (int) Math.ceil((this.cakeDaoImpl.findStepCakeRowsCount(stepid)/3));
				}
		
	

}
