package com.sweet.cakeonline.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.admin.service.AdminServiceImpl;
import com.sweet.cakeonline.adminCake.service.AdminCakeServiceImpl;
import com.sweet.cakeonline.cake.service.CakeServiceImpl;
import com.sweet.cakeonline.entity.Admin;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Orders;
import com.sweet.cakeonline.entity.Users;
import com.sweet.cakeonline.orders.orderService.OrderServiceImpl;
import com.sweet.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Resource
	private AdminServiceImpl adminServiceImpl;
	@Resource
	private UserServiceImpl userServiceImpl;
	@Resource
	private OrderServiceImpl orderServiceImpl;
	@Resource 
	AdminCakeServiceImpl adminCakeServiceImpl;
	
	
	//管理员登录后进入管理订单、用户、商品页面
	@RequestMapping("/adminLogin")
	public void login(@RequestParam("adminname") String loginName,
			@RequestParam("password") String password,
		    HttpSession session,HttpServletResponse response) throws IOException{
        //查找所有管理员
		List<Admin> adminList=this.adminServiceImpl.listAdmin();
	//	 session.setAttribute("aisRegisted", true);
		//到集合中查找用户是否存在，此处用来模拟数据库验证  
        for(Admin admin:adminList){  
            if(admin.getAname().equals(loginName) && admin.getPassword().equals(password)){  
               session.setAttribute("adminuser", admin); 
               session.setAttribute("adminname", admin.getAname());
               session.setAttribute("aisRegisted", true);
               response.sendRedirect("/Cake/adminIndex.jsp");
               } else {
            	   session.setAttribute("aisRegisted", false);
            	   response.sendRedirect("/Cake/adminLogin.jsp");
               }
        }   
	}

}
