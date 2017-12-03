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
	  public void listcake(HttpSession session,@RequestParam("pageIndex")String p,
			  HttpServletResponse response) throws IOException {
	       
       //  ModelAndView mv = new ModelAndView();
		List<Cake> list=this.cakeServiceImpl.listAll(Integer.parseInt(p));
	     session.setAttribute("list", list);
	     //分页
		int pageCount=this.cakeServiceImpl.getPageCount();
	    // int pageCount=2;
		 session.setAttribute("pageCount",pageCount);
		int pageIndex=1;
		 session.setAttribute("pageIndex",pageIndex);
		 if(0==pageIndex|| pageIndex<0) {
			 session.setAttribute("pageIndex",1);
			 
		 }else {
			 session.setAttribute("pageIndex",pageIndex);}		 
		 
		//分类
		List <CakeType> caketypelist=this.cakeTypeServiceImpl.listCakeType();
		 session.setAttribute("caketypelist",caketypelist);
		List <CakeSize> cakesizelist=this.cakeTypeServiceImpl.listCakeSize();
		 session.setAttribute("cakesizelist",cakesizelist);
		List <CakeStep> cakesteplist=this.cakeTypeServiceImpl.listCakeStep();
		 session.setAttribute("cakesteplist",cakesteplist);		
		  response.sendRedirect("/Cake/list.jsp");
	}
	//通过蛋糕种类分类查询
	@RequestMapping("/selectByType")
	public void selectByClass(@RequestParam("typeid")String typeid,HttpSession session,
			HttpServletResponse response) throws IOException {
		
		List<Cake> CakeByTypeList=this.cakeServiceImpl.listByType(Integer.parseInt(typeid));
	     session.setAttribute("list", CakeByTypeList);
	   
	     
	     //分页
		int pageCount=this.cakeServiceImpl.getTypeCakePageCount(Integer.parseInt(typeid));
	//	 int pageCount=2;
			 session.setAttribute("pageCount",pageCount);
			int pageIndex=1;
			 session.setAttribute("pageIndex",pageIndex);
			 if(0==pageIndex|| pageIndex<0) {
				 session.setAttribute("pageIndex",1);
				 
			 }else {
				 session.setAttribute("pageIndex",pageIndex);}	
			 
			  response.sendRedirect("/Cake/list.jsp");
	}
	//通过蛋糕尺寸分类查询
		@RequestMapping("/selectBySize")
		public void selectBySize(@RequestParam("sizeid")String sizeid,HttpSession session,
				HttpServletResponse response) throws IOException {
			
			List<Cake> CakeBySizeList=this.cakeServiceImpl.listBySize((Integer.parseInt(sizeid)));
		     session.setAttribute("list", CakeBySizeList);
		   
		     
		     //分页
			int pageCount=this.cakeServiceImpl.getSizeCakePageCount(Integer.parseInt(sizeid));
		//	 int pageCount=2;
				 session.setAttribute("pageCount",pageCount);
				int pageIndex=1;
				 session.setAttribute("pageIndex",pageIndex);
				 if(0==pageIndex|| pageIndex<0) {
					 session.setAttribute("pageIndex",1);
					 
				 }else {
					 session.setAttribute("pageIndex",pageIndex);}	
				 
				  response.sendRedirect("/Cake/list.jsp");
		}
		//通过蛋糕层数分类查询
				@RequestMapping("/selectByStep")
				public void selectByStep(@RequestParam("stepid")String stepid,HttpSession session,
						HttpServletResponse response) throws IOException {					
					List<Cake> CakeByStepList=this.cakeServiceImpl.listByStep((Integer.parseInt(stepid)));
				     session.setAttribute("list", CakeByStepList);				     
				     //分页
					int pageCount=this.cakeServiceImpl.getStepCakePageCount(Integer.parseInt(stepid));
				//	 int pageCount=2;
						 session.setAttribute("pageCount",pageCount);
						int pageIndex=1;
						 session.setAttribute("pageIndex",pageIndex);
						 if(0==pageIndex|| pageIndex<0) {
							 session.setAttribute("pageIndex",1);							 
						 }else {
							 session.setAttribute("pageIndex",pageIndex);}	
						 
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
	//分类分页查询
	@RequestMapping("/speciallist")
	  public void listspecialcake(@RequestParam("typeid")String typeid,HttpSession session,@RequestParam("spageIndex")String p,
			  HttpServletResponse response) throws IOException {
		List<Cake> listByType=this.cakeTypeServiceImpl.listCakeByType(Integer.parseInt(typeid));
		session.setAttribute("list", listByType);
		//分页查询
		   int pageCount=2;
			 session.setAttribute("spageCount",pageCount);
			int pageIndex=1;
			 session.setAttribute("spageIndex",pageIndex);
			 if(0==pageIndex|| pageIndex<0) {
				 session.setAttribute("spageIndex",1);
				 
			 }else {
				 session.setAttribute("spageIndex",pageIndex);
				 	}
			 response.sendRedirect("/Cake/list.jsp");
	}

}
