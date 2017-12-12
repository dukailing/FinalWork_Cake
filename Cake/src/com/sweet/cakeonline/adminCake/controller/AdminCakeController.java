package com.sweet.cakeonline.adminCake.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.adminCake.service.AdminCakeServiceImpl;
import com.sweet.cakeonline.cake.service.CakeServiceImpl;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Users;
import com.sweet.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("admincake")
public class AdminCakeController {
	@Resource
	private AdminCakeServiceImpl adminCakeServiceImpl;
	@Resource 
	private CakeServiceImpl cakeServiceImpl;
	/**
	 * 查找所有蛋糕品种
	 * @param cp
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	//
	@RequestMapping("/listAdminCake")
	public void ListAdminCake(@RequestParam("acpageIndex")Integer cp,
	HttpServletResponse response,HttpSession session) throws IOException {
		List<Cake> cakelist=this.adminCakeServiceImpl.listAll(cp);
		//分页
		int pageCount=this.adminCakeServiceImpl.getPageCount();	
		int pageIndex=1;	
		 if(0==pageIndex|| pageIndex<0) {
			 session.setAttribute("acpageIndex",1);
			 
		 }else {
			 session.setAttribute("acpageIndex",pageIndex);
			 	}		
		session.setAttribute("acpageIndex",pageIndex);
		session.setAttribute("acpageCount",pageCount);
		session.setAttribute("admincakelist", cakelist);
		response.sendRedirect("/Cake/adminCakes.jsp");
	}
    /**
     * 删除一个蛋糕品种
     * @param cakeid
     * @param response
     * @param session
     * @throws IOException
     */
	@RequestMapping("/deleteOneCake")
	public void AdminDeleteCake(@RequestParam("cakeid")String cakeid,
			HttpServletResponse response,
			HttpSession session) throws IOException {
		this.adminCakeServiceImpl.deleteOneCake(Integer.parseInt(cakeid));
		response.sendRedirect("/Cake/adminCakes.jsp");
	}
	/**
	 * 增加或修改一个蛋糕品种
	 * @param cid
	 * @param name
	 * @param detail
	 * @param price
	 * @param img
	 * @param img1
	 * @param img2
	 * @param img3
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/updateOneCake")
	public void UpdateOneCake(
			@RequestParam("cakeid")Integer cid,
			@RequestParam("gname")String name,
			@RequestParam("detail")String detail,
			@RequestParam("price")String price,
			@RequestParam("listimg")String img,
			@RequestParam("img1")String img1,
			@RequestParam("img2")String img2,
			@RequestParam("img3")String img3,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		Cake cake=new Cake();
		List<Cake> clist=this.cakeServiceImpl.listAllCake();
		for(Cake tcake:clist) {
			if(tcake.getId()==cid) {
				cake=this.adminCakeServiceImpl.getCakeById(cid);			
				cake.setGname(name);
				cake.setDetail(detail);
				cake.setPrice(Float.parseFloat(price));
				cake.setListimg(img);
				cake.setImg1(img1);
				cake.setImg2(img2);
				cake.setImg3(img3);
				this.adminCakeServiceImpl.updateOneCake(cake);
				request.setAttribute("isUpdated", true);
				break;
			}
			else {
				request.setAttribute("isUpdated",false);
			}
		}
		if(request.getAttribute("isUpdated").equals(false)) {		
			cake.setId(cid);
			cake.setGname(name);
			cake.setDetail(detail);
			cake.setPrice(Float.parseFloat(price));
			cake.setListimg(img);
			cake.setImg1(img1);
			cake.setImg2(img2);
			cake.setImg3(img3);
		this.adminCakeServiceImpl.addOneCake(cake);
		}
		response.sendRedirect("/Cake/adminCakes.jsp");
	}
}
