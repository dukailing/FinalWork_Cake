package com.sweet.cakeonline.adminOrders.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.adminOrders.service.AdminOrdersServiceImpl;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Orders;

@Controller
@RequestMapping("adminorder")
public class AdminOrdersController {
	@Resource
	private AdminOrdersServiceImpl  adminOrdersServiceImpl ;
	//查找所有蛋糕品种
		@RequestMapping("/listAdminOrder")
		public void ListAdminCake(HttpServletResponse response,HttpSession session,@RequestParam("aopageIndex")String op) throws IOException {
			List<Orders> orderlist=this.adminOrdersServiceImpl.listAllOrders(Integer.parseInt(op));

			//分页
			int pageCount=this.adminOrdersServiceImpl.findOrderPageCount();
			session.setAttribute("aopageCount",pageCount);
			int pageIndex=1;
			 session.setAttribute("aopageIndex",pageIndex);
			 if(0==pageIndex|| pageIndex<0) {
				 session.setAttribute("aopageIndex",1);
				 
			 }else {
				 session.setAttribute("aopageIndex",pageIndex);
				 	}
			
			session.setAttribute("adminorderlist", orderlist);
			response.sendRedirect("/Cake/adminOrders.jsp");
		}
		//删除一个订单
		@RequestMapping("/deleteOneOrder")
		public void AdminDeleteOrder(HttpServletResponse response,
				HttpSession session,
				@RequestParam("orderid")String orderid) throws IOException {
			this.adminOrdersServiceImpl.deleteOneOrder(Integer.parseInt(orderid));
			response.sendRedirect("/Cake/adminOrders.jsp");
		}
}
