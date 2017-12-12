package com.sweet.cakeonline.shoppingcart.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
	
	/**
	 * 查找未提交订单,进入购物车页面
	 * @param userid
	 * @param p
	 * @param session
	 * @param response
	 * @throws IOException
	 */

	@RequestMapping("/listShop")
	public void listShop(
			@RequestParam("userid")int userid,
			@RequestParam("spageIndex")Integer page,
			HttpSession session,HttpServletResponse response) throws IOException {
		List<ShoppingCart> shoppingCartList=this.shoppingCartServiceImpl.listAll(page,userid);
		session.setAttribute("shoppingcartlist", shoppingCartList);        
		//分页查询
		int pageCount=this.shoppingCartServiceImpl.findShopPageCount(userid);
		session.setAttribute("spageCount",pageCount);
		int pageIndex=1;
		session.setAttribute("spageIndex",pageIndex);
		if(0==pageIndex|| pageIndex<0) {
			session.setAttribute("spageIndex",1);				 
		}else {
			session.setAttribute("spageIndex",page);
		}
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	
	/**
	 * 加入购物车，存入数据库
	 * @param price
	 * @param id
	 * @param cakeimg
	 * @param cname
	 * @param userid
	 * @param count
	 * @param session
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/addShop")
	public void addShop(@RequestParam("price")Float price,
			@RequestParam("cakeid")int id,
			@RequestParam("cakeimg")String cakeimg,
			@RequestParam("cakename") String cname,
			@RequestParam("userid") Integer userid,
			@RequestParam("quantity")Integer count,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ShoppingCart sh=new ShoppingCart();		
		sh.setCname(cname);
		sh.setCid(id);
		sh.setCakeimg(cakeimg);
		sh.setPrice(price);
		sh.setUserid(userid);
		sh.setCount(1);
		this.shoppingCartServiceImpl.addOneCake(sh);
		response.sendRedirect("/Cake/singleCake.jsp");
	}
	/**
	 * 修改购买数量
	 * @param count
	 * @param sid
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/updateCount")
	public void UpdateCoun(@RequestParam("NewCount")Integer count,
			@RequestParam("sid")Integer sid,
			HttpSession session,
			HttpServletResponse response) throws IOException {
		ShoppingCart sh=this.shoppingCartServiceImpl.findById(sid);
		sh.setCount(count);
		this.shoppingCartServiceImpl.updateOneCake(sh);
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	
	/**
	 * 删除购物车某一订单
	 * @param shopid
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteshop")
	public void deleteShop(@RequestParam("ShopId")Integer shopid,
			HttpServletResponse response) throws IOException {		
		ShoppingCart sh=this.shoppingCartServiceImpl.findById(shopid);
		this.shoppingCartServiceImpl.deleteOneCake(sh);
		response.sendRedirect("/Cake/shoppingCart.jsp");		
	}	
	/**
	 *  清空购物车
	 * @param userid
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/deleteShoppingcart")
	public void deleteShoppingcart(@RequestParam("userid")Integer userid,
			HttpServletResponse response,HttpSession session
			) throws IOException {	
		this.shoppingCartServiceImpl.deleteSoppingCart(userid);
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}		
}
	

