package com.sweet.cakeonline.cake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sweet.cakeonline.cake.dao.CakeSizeDaoImpl;
import com.sweet.cakeonline.cake.dao.CakeStepDaoImpl;
import com.sweet.cakeonline.cake.dao.CakeTypeDaoImpl;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.CakeSize;
import com.sweet.cakeonline.entity.CakeStep;
import com.sweet.cakeonline.entity.CakeType;

@Service
public class CakeTypeServiceImpl {
	@Resource
	private CakeTypeDaoImpl cakeTypeDaoImpl;
	@Resource
	private CakeStepDaoImpl cakeStepDaoImpl;
	@Resource
	private CakeSizeDaoImpl cakeSizeDaoImpl;
	/**
	 * 查找所有蛋糕种类
	 * @return
	 */
	public List<CakeType> listCakeType(){
		return this.cakeTypeDaoImpl.findAll();
	}
	
	/**
	 * 查找所有蛋糕尺寸
	 * @return
	 */
	public List<CakeSize> listCakeSize(){
		return this.cakeSizeDaoImpl.findAll();
	}
	/**
	 * 查找所有蛋糕层数
	 * @return
	 */
	public List<CakeStep> listCakeStep(){
		return this.cakeStepDaoImpl.findAll();
	}
	/**
	 * 查找某种蛋糕
	 * @param typeid
	 * @return
	 */
	public List<Cake> listCakeByType(int typeid){
		return this.cakeTypeDaoImpl.findByType(typeid);		
	}
}
