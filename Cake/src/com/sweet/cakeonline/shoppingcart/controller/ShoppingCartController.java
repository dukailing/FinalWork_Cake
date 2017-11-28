package com.sweet.cakeonline.shoppingcart.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.entity.ShoppingCart;

@Controller
@RequestMapping("shoppingcart")
public class ShoppingCartController {
	@RequestMapping("/listShop")
	public void listShop(HttpServletResponse response) throws IOException {
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	@RequestMapping("/addShop")
	public void addShop(@RequestParam("price")float price,
			@RequestParam("cakeid")int id,
			@RequestParam("cakename") String cname,
			HttpServletResponse response) throws IOException {
		ShoppingCart sh=new ShoppingCart();
		sh.setCname(cname);
		sh.setCid(id);
		sh.setPrice(price);
		
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	
}
