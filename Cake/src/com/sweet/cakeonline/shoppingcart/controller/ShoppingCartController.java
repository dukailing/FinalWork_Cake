package com.sweet.cakeonline.shoppingcart.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.entity.ShoppingCart;
import com.sweet.cakeonline.entity.Users;
import com.sweet.cakeonline.shoppingcart.service.ShoppingCartServiceImpl;
import com.sweet.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("shoppingcart")
public class ShoppingCartController {
	@Resource
	private ShoppingCartServiceImpl shoppingCartServiceImpl; 
	@Resource
	private UserServiceImpl userServiceImpl;
	//查找未提交订单
	@RequestMapping("/listShop")
	public void listShop(HttpSession session,@RequestParam("userid")int userid,
			@RequestParam("spageIndex")String p,HttpServletResponse response) throws IOException {
		List<ShoppingCart> shoppingCartList=this.shoppingCartServiceImpl.listAll(Integer.parseInt(p),userid);
		session.setAttribute("shoppingcartlist", shoppingCartList);
	
		//分页查询
		   int pageCount=1;
			 session.setAttribute("spageCount",pageCount);
			int pageIndex=1;
			 session.setAttribute("spageIndex",pageIndex);
			 if(0==pageIndex|| pageIndex<0) {
				 session.setAttribute("spageIndex",1);
				 
			 }else {
				 session.setAttribute("spageIndex",pageIndex);
				 	}
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	//加入购物车，存入数据库
	@RequestMapping("/addShop")
	public void addShop(@RequestParam("price")String price,
			@RequestParam("cakeid")int id,
			@RequestParam("cakeimg")String cakeimg,
			@RequestParam("cakename") String cname,
			@RequestParam("userid") String userid,
			@RequestParam("quantity")String count,
			HttpServletResponse response) throws IOException {
		ShoppingCart sh=new ShoppingCart();

		
		sh.setCname(cname);
		sh.setCid(id);
		sh.setCakeimg(cakeimg);
		sh.setPrice(Float.parseFloat(price));
		sh.setUserid(Integer.parseInt(userid));
		sh.setCount(1);
		//sh.setCount(Integer.parseInt(count));
	//	Users u=this.userServiceImpl.findUserById(Integer.parseInt(userid));
	//	u.getShopSet().add(sh);
		this.shoppingCartServiceImpl.addOneCake(sh);
		response.sendRedirect("/Cake/singleCake.jsp");
	//	response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	//修改购买数量
	@RequestMapping("/updateCount")
	public void UpdateCoun(@RequestParam("NewCount")String count,
			@RequestParam("sid")String sid,
			HttpSession session,
			HttpServletResponse response) throws IOException {
		ShoppingCart sh=this.shoppingCartServiceImpl.findById(Integer.parseInt(sid));
		sh.setCount(Integer.parseInt(count));
		this.shoppingCartServiceImpl.updateOneCake(sh);
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	@RequestMapping("/deleteshop")
	public void deleteShop(@RequestParam("ShopId")String shopid,HttpServletResponse response) throws IOException {
		
		ShoppingCart sh=this.shoppingCartServiceImpl.findById(Integer.parseInt(shopid));
		this.shoppingCartServiceImpl.deleteOneCake(sh);
		response.sendRedirect("/Cake/shoppingCart.jsp");
		
	}
	
}
