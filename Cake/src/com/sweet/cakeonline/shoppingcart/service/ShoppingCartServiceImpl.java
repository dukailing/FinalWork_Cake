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
	   //查找所有购物车商品
		public List<ShoppingCart> listAll(int p,int userid){
			return this.shoppingCartDaoImpl.findAll(p,userid);
		}
		//通过id查找订单
		public ShoppingCart findById(int id) {
			return this.shoppingCartDaoImpl.findById(id);
		}
		//删除一个蛋糕订单
		public void deleteOneCake(ShoppingCart c) {
			this.shoppingCartDaoImpl.deleteShop(c);
		}
		//更新一个蛋糕订单
		public void updateOneCake(ShoppingCart c) {
			this.shoppingCartDaoImpl.updateShop(c);
		}
		//增加蛋糕
		public void addOneCake(ShoppingCart c) {
			this.shoppingCartDaoImpl.saveShop(c);
		}
}
