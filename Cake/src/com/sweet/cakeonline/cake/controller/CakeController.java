package com.sweet.cakeonline.cake.controller;

import java.io.IOException;
import java.util.ArrayList;
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
	
	/**
	 * 转到蛋糕表单页面
	 * @param page
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/list")
	public void listCake(@RequestParam(value="pageIndex",defaultValue="1")Integer page,
        HttpSession session,
		HttpServletResponse response) throws IOException {
		List<Cake> list=this.cakeServiceImpl.listAll(page);
	    session.setAttribute("list", list);
	    //分页
		int pageCount=this.cakeServiceImpl.getPageCount();
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
	
	/**
	 * 通过蛋糕种类分类查询
	 * @param typeid
	 * @param page
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selectByType")
	public void selectByClass(
			@RequestParam("typeid")String typeid,		
			@RequestParam(value="pageIndex",defaultValue="1")Integer page,
            HttpSession session,
			HttpServletResponse response) throws IOException {	
        List<Cake> CakeByTypeList=this.cakeServiceImpl.listByType(Integer.parseInt(typeid),page);
	    session.setAttribute("list", CakeByTypeList);	   	     
	    //分页
		int pageCount=this.cakeServiceImpl.getTypeCakePageCount(Integer.parseInt(typeid));
		session.setAttribute("pageCount",pageCount);
		int pageIndex=1;
		session.setAttribute("pageIndex",pageIndex);
		if(0==pageIndex|| pageIndex<0) {
			session.setAttribute("pageIndex",1);			 
		}else {
		    session.setAttribute("pageIndex",pageIndex);}			 
			response.sendRedirect("/Cake/list.jsp");
	}
	
	/**
	 * 通过蛋糕尺寸分类查询
	 * @param sizeid
	 * @param session
	 * @param response
	 * @param page
	 * @throws IOException
	 */
	@RequestMapping("/selectBySize")
	public void selectBySize(@RequestParam("sizeid")String sizeid,
			HttpSession session,
			HttpServletResponse response,
			@RequestParam(value="pageIndex",defaultValue="1")Integer page) throws IOException {			
		List<Cake> CakeBySizeList=this.cakeServiceImpl.listBySize(Integer.parseInt(sizeid),page);
		session.setAttribute("list", CakeBySizeList);		   	     
		//分页
		int pageCount=this.cakeServiceImpl.getSizeCakePageCount(Integer.parseInt(sizeid));
		session.setAttribute("pageCount",pageCount);
		int pageIndex=1;
		session.setAttribute("pageIndex",pageIndex);
		if(0==pageIndex|| pageIndex<0) {
			session.setAttribute("pageIndex",1);					 
		}else {
			session.setAttribute("pageIndex",pageIndex);}					 
			response.sendRedirect("/Cake/list.jsp");
		}
	/**
	 * 通过蛋糕层数分类查询
	 * @param stepid
	 * @param page
	 * @param session
	 * @param response
	 * @throws IOException
	 */
    @RequestMapping("/selectByStep")
	public void selectByStep(
			@RequestParam("stepid")Integer stepid,
			@RequestParam(value="pageIndex",defaultValue="1")Integer page,
			HttpSession session,
			HttpServletResponse response) throws IOException {					
		List<Cake> CakeByStepList=this.cakeServiceImpl.listByStep(stepid,page);
		session.setAttribute("list", CakeByStepList);				     
		//分页
		int pageCount=this.cakeServiceImpl.getStepCakePageCount(stepid);
		session.setAttribute("pageCount",pageCount);
		int pageIndex=1;
		session.setAttribute("pageIndex",pageIndex);
		if(0==pageIndex|| pageIndex<0) {
		    session.setAttribute("pageIndex",1);							 
		}else {
		    session.setAttribute("pageIndex",page);
		}							 
		response.sendRedirect("/Cake/list.jsp");
	}
    /**
     * 转到蛋糕详情页面
     * @param cakeId
     * @param session
     * @param request
     * @param response
     * @throws IOException
     */

    @RequestMapping("singleCake")
	public void listsinglecake(@RequestParam(value="cakeid")Integer cakeId,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List list=(List) session.getAttribute("list");
		Cake cake=(Cake) list.get(cakeId);
		session.setAttribute("singlecake", cake);
		session.setAttribute("list", list);
		response.sendRedirect("/Cake/singleCake.jsp");  
	}
    /**
     * 搜索查询蛋糕  
     * @throws IOException
     */
	@RequestMapping("/searchList")
	public void SearchCakeList(
			@RequestParam("search")String search,
			HttpServletResponse response,HttpSession session
			) throws IOException {
		List<Cake> list=this.cakeServiceImpl.listAll(1);
		List<Cake> searchList=new ArrayList<Cake>();
		for(Cake c:list) {
		    if(c.getGname().contains(search)) {
			searchList.add(c);
			}
		}
		//分页
		int pageCount=(int)(searchList.size()/9);
		session.setAttribute("pageCount",pageCount);
		int pageIndex=1;
		session.setAttribute("pageIndex",pageIndex);
		if(0==pageIndex|| pageIndex<0) {
            session.setAttribute("pageIndex",1);							 
		}else {
			session.setAttribute("pageIndex",pageIndex);}		
		session.setAttribute("list", searchList);
		response.sendRedirect("/Cake/list.jsp");
	}

}
