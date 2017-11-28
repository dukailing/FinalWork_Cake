package com.sweet.cakeonline.cake.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sweet.cakeonline.cake.service.CakeServiceImpl;
import com.sweet.cakeonline.cake.service.CakeTypeServiceImpl;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.CakeSize;
import com.sweet.cakeonline.entity.CakeStep;
import com.sweet.cakeonline.entity.CakeType;

@Controller
@RequestMapping("cake")
public class CakeController {
	
	@Resource
	private CakeServiceImpl cakeServiceImpl;
	@Resource
	private CakeTypeServiceImpl cakeTypeServiceImpl;
	
    //转到蛋糕表单页面
	@RequestMapping("/list")
	  public void listcake(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
	       
       //  ModelAndView mv = new ModelAndView();
		List<Cake> list=this.cakeServiceImpl.listAll();
	     session.setAttribute("list", list);
	     //分页
//		int pageCount=this.cakeServiceImpl.getPageCount();
	     int pageCount=2;
		 session.setAttribute("pageCount",pageCount);
		int pageIndex=1;
		 session.setAttribute("pageIndex",pageIndex);
		 if(0==pageIndex|| pageIndex<0) {
			 session.setAttribute("pageIndex",1);
			 
		 }else {
			 session.setAttribute("pageIndex",pageIndex);
			 	}
		//分类
		List <CakeType> caketypelist=this.cakeTypeServiceImpl.listCakeType();
		 session.setAttribute("caketypelist",caketypelist);
		List <CakeSize> cakesizelist=this.cakeTypeServiceImpl.listCakeSize();
		 session.setAttribute("cakesizelist",cakesizelist);
		List <CakeStep> cakesteplist=this.cakeTypeServiceImpl.listCakeStep();
		 session.setAttribute("cakesteplist",cakesteplist);		
		  response.sendRedirect("/Cake/list.jsp");
	}
	//转到蛋糕详情页面
	@RequestMapping("singleCake")
	  public void listsinglecake(@RequestParam(value="cakeid")String cakeId,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
	       //@RequestParam(value="cakeid")String cakeId,d
		//response.sendRedirect("singleCake");
		List list=(List) session.getAttribute("list");
		Cake cake=(Cake) list.get(Integer.parseInt(cakeId));
		session.setAttribute("singlecake", cake);
		session.setAttribute("list", list);
		  response.sendRedirect("/Cake/singleCake.jsp");
	}

}
