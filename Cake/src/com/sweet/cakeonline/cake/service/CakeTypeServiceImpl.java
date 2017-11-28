package com.sweet.cakeonline.cake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sweet.cakeonline.cake.dao.CakeSizeDaoImpl;
import com.sweet.cakeonline.cake.dao.CakeStepDaoImpl;
import com.sweet.cakeonline.cake.dao.CakeTypeDaoImpl;
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
	
	public List<CakeType> listCakeType(){
		return this.cakeTypeDaoImpl.findAll();
	}
	public List<CakeSize> listCakeSize(){
		return this.cakeSizeDaoImpl.findAll();
	}
	public List<CakeStep> listCakeStep(){
		return this.cakeStepDaoImpl.findAll();
	}
}
