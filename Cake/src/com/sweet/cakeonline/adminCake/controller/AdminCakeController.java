package com.sweet.cakeonline.adminCake.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.adminCake.service.AdminCakeServiceImpl;
import com.sweet.cakeonline.entity.Cake;

@Controller
@RequestMapping("admincake")
public class AdminCakeController {
	@Resource
	private AdminCakeServiceImpl adminCakeServiceImpl;
	//查找所有蛋糕品种
	@RequestMapping("/listAdminCake")
	public void ListAdminCake(HttpServletResponse response,HttpSession session,@RequestParam("acpageIndex")String cp) throws IOException {
		List<Cake> cakelist=this.adminCakeServiceImpl.listAll(Integer.parseInt(cp));
		//分页
		int pageCount=this.adminCakeServiceImpl.getPageCount();
		session.setAttribute("acpageCount",pageCount);
		int pageIndex=1;
		 session.setAttribute("acpageIndex",pageIndex);
		 if(0==pageIndex|| pageIndex<0) {
			 session.setAttribute("acpageIndex",1);
			 
		 }else {
			 session.setAttribute("acpageIndex",pageIndex);
			 	}
		
		session.setAttribute("admincakelist", cakelist);
		response.sendRedirect("/Cake/adminCakes.jsp");
	}
	//删除一个蛋糕品种
	@RequestMapping("/deleteOneCake")
	public void AdminDeleteCake(HttpServletResponse response,
			HttpSession session,
			@RequestParam("cakeid")String cakeid) throws IOException {
		this.adminCakeServiceImpl.deleteOneCake(Integer.parseInt(cakeid));
		response.sendRedirect("/Cake/adminCakes.jsp");
	}
	
	
	
}
