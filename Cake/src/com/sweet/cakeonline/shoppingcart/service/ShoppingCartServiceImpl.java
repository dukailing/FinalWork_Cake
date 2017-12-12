package com.sweet.cakeonline.shoppingcart.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.ShoppingCart;
import com.sweet.cakeonline.shoppingcart.dao.ShoppingCartDaoImpl;

@Service
@Transactional(readOnly=false)
public class ShoppingCartServiceImpl {
	@Resource
	private ShoppingCartDaoImpl shoppingCartDaoImpl;
	/**
	 * 查找所有购物车商品
	 * @param page
	 * @param userid
	 * @return
	 */
	public List<ShoppingCart> listAll(int page,int userid){
		return this.shoppingCartDaoImpl.findAll(page,userid);
	}
    /**
     * 通过id查找订单
     * @param id
     * @return
     */
	public ShoppingCart findById(int id) {
		return this.shoppingCartDaoImpl.findById(id);
	}
	/**
	 * 删除一个蛋糕订单
	 * @param sc
	 */
	public void deleteOneCake(ShoppingCart sc) {
		this.shoppingCartDaoImpl.deleteShop(sc);
	}
    /**
     * 清空购物车
     * @param userid
     */
	public void deleteSoppingCart(int userid) {
		this.shoppingCartDaoImpl.deleteShoppingCart(userid);
	}
	/**
	 * 查找购物车未提交订单页数
	 * @param userid
	 * @return
	 */
	public int findShopPageCount(int userid) {
		if((this.shoppingCartDaoImpl.findShopCount(userid))%3==0) {
		return (int)(this.shoppingCartDaoImpl.findShopCount(userid)/3);
		}else {
		return (int)(this.shoppingCartDaoImpl.findShopCount(userid)/3+1);	
		}
	}	
    /**
     * 更新一个蛋糕订单
     * @param sc
     */
		public void updateOneCake(ShoppingCart sc) {
			this.shoppingCartDaoImpl.updateShop(sc);
		}
	/**
	 * 增加蛋糕
	 * @param sc
	 */
		public void addOneCake(ShoppingCart sc) {
			this.shoppingCartDaoImpl.saveShop(sc);
		}		
}
