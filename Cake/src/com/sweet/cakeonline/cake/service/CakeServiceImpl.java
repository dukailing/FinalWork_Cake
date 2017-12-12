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
	/**
	 * 分页查找所有蛋糕
	 * @param page
	 * @return
	 */
	public List<Cake> listAll(int page){
		return this.cakeDaoImpl.findAll(page);
	}
	/**
	 * 查找所有蛋糕
	 * @return
	 */
	public List<Cake> listAllCake(){
		return this.cakeDaoImpl.findAllCake();
	}	
	/**
	 * 分类查询蛋糕
	 * @param typeid
	 * @param page
	 * @return
	 */
	public List<Cake> listByType(int typeid,int page){
		return this.cakeDaoImpl.findByType(typeid,page);
	}
	/**
	 * 分类查询蛋糕
	 * @param sizeid
	 * @param page
	 * @return
	 */
	public List<Cake> listBySize(int sizeid,int page){
		return this.cakeDaoImpl.findByType(sizeid,page);
	}
	/**
	 * 分层数查询蛋糕
	 * @param stepid
	 * @param page
	 * @return
	 */
	public List<Cake> listByStep(int stepid,int page){
		return this.cakeDaoImpl.findByType(stepid,page);
	}
	/**
	 * 得到总页码数
	 * @return
	 */
	public int getPageCount() {
		 return (int) Math.ceil((this.cakeDaoImpl.findRowsCount())/9);		
	}
	/**
	 * 得到通过分类查询页码总数
	 * @param typeid
	 * @return
	 */
	public int getTypeCakePageCount(int typeid) {
		return (int) Math.ceil((this.cakeDaoImpl.findTypeCakeRowsCount(typeid))/3);
	}
	/**
	 * 得到通过分尺寸查询页码总数
	 * @param sizeid
	 * @return
	 */
	public int getSizeCakePageCount(int sizeid) {
		return (int) Math.ceil((this.cakeDaoImpl.findSizeCakeRowsCount(sizeid)/3));
	}
	/**
	 * 得到通过分尺寸查询页码总数
	 * @param stepid
	 * @return
	 */
	public int getStepCakePageCount(int stepid) {
		return (int) Math.ceil((this.cakeDaoImpl.findStepCakeRowsCount(stepid)/3));
	}
		
	

}
