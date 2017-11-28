package com.sweet.cakeonline.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.admin.service.AdminServiceImpl;
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
	private CakeServiceImpl cakeServiceImpl;
	@Resource
	private UserServiceImpl userServiceImpl;
	@Resource
	private OrderServiceImpl orderServiceImpl;
	
	
	//管理员登录并进入管理页面
	@RequestMapping("/adminLogin")
	public String login(@RequestParam("username") String loginName,
			@RequestParam("password") String password,
			Model model, HttpSession session,HttpServletResponse response) throws IOException{
	//	Users user=this.userServiceImpl.login(loginName, password);
		List<Admin> adminList=this.adminServiceImpl.listAdmin();
		//到集合中查找用户是否存在，此处用来模拟数据库验证  
        for(Admin admin:adminList){  
            if(admin.getAname().equals(loginName) && admin.getPassword().equals(password)){  
                model.addAttribute("user", admin);  
            	//查找所有用户
        		List<Users> list=this.userServiceImpl.listUser();
        		model.addAttribute("userlist", list);
        		
        		//查找所有订单
        		List<Orders> orderlist=this.orderServiceImpl.listAll();
        		model.addAttribute("orderlist", orderlist);
        		
        		//查找所有蛋糕
        		List<Cake> cakelist=this.cakeServiceImpl.listAll();
        		model.addAttribute("cakelist", cakelist);
        		//response.sendRedirect("adminOrders");
               return "adminOrders";  
            }  
        }  
        // response.sendRedirect("adminLogin");
        return "adminLogin";
	}
	//查找所有蛋糕
//	@RequestMapping("admin/cakelist")
//	public String list(Model model){
//		List<Cake> list=this.cakeServiceImpl.listAll();
//		model.addAttribute("list", list);
//		return "list";
//	}
//	@RequestMapping("cake/save")
//	public String save(Model model) {
//		
//	}
	
	
	//删除一个蛋糕
	@RequestMapping("/deleteCake")
	public void delete(Cake c,HttpServletResponse response) throws IOException {
		cakeServiceImpl.deleteOneCake(c);
		response.sendRedirect("adminOrders");
		//return "redirect:adminOrders";
	}

}
