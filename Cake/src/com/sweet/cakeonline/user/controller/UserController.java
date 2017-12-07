package com.sweet.cakeonline.user.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Users;
import com.sweet.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	private UserServiceImpl userServiceImpl;
	//用户登录
	@RequestMapping("/userLogin")
	public void login(@RequestParam("username") String loginName,
			@RequestParam("password") String password,
			 HttpSession session,HttpServletResponse response) throws IOException{
	//	Users user=this.userServiceImpl.login(loginName, password);
		List<Users> userList=this.userServiceImpl.listUser();
		//到集合中查找用户是否存在，此处用来模拟数据库验证  
        for(Users user:userList){  
            if(user.getName().equals(loginName) && user.getPassword().equals(password)){  
                session.setAttribute("user", user);  
                session.setAttribute("userid", user.getId());
                session.setAttribute("isLogin", "true");
//                response.sendRedirect("/Cake/index.jsp");
                break;
            }else {
            	session.setAttribute("isLogin", "false");
            }           
        }
        if(session.getAttribute("isLogin").equals("true")) {
        	  response.sendRedirect("/Cake/index.jsp");
        }else {
        	response.sendRedirect("/Cake/userLogin.jsp");
        }
	}
	
	
	//用户注册
	@RequestMapping("/userRegist")
	public void regist(@RequestParam("username") String loginName,
			@RequestParam("password") String password,@RequestParam("confirmpassword") String confirmpassword,
			@RequestParam("address") String address,@RequestParam("email") String email,
			 HttpSession session,HttpServletResponse response) throws IOException {
		List<Users> userList=this.userServiceImpl.listUser();
		session.setAttribute("isRegisted", false);
		 for(Users user:userList){  
	            if(user.getName().equals(loginName)){  
	            	session.setAttribute("isRegisted",true);
	            	  break;
	            }            }
		 if(password.equals(confirmpassword)&&session.getAttribute("isRegisted").equals(false) ) {
		Users u=new Users();
		u.setAddress(address);
		u.setEmail(email);
		u.setName(loginName);
		u.setPassword(password);
		this.userServiceImpl.addUser(u);
		session.setAttribute("userRegist", u);
		response.sendRedirect("/Cake/userLogin.jsp");;
		}else {
			response.sendRedirect("/Cake/userRegist.jsp");
		}
	}
	//更新用户信息
	@RequestMapping("/updateUserInformation")
	public void UpdateUserInformation(@RequestParam("username") String userName,
			//@RequestParam("userid")String userid,
			@RequestParam("password") String password,
			@RequestParam("confirmpassword") String confirmpassword,
			@RequestParam("address") String address,
			@RequestParam("email") String email,
			HttpSession session,HttpServletResponse response) throws IOException{
		int userid=(int) session.getAttribute("userid");
		if(password.equals(confirmpassword)) {
	   // Users u=this.userServiceImpl.findUserById(userid);
		this.userServiceImpl.updateUserInfo(userid,userName,password,email,address);
		response.sendRedirect("/Cake/index.jsp");
		}
	}
	//用户查询
	@RequestMapping("/list")
	public void list(HttpSession session,
			HttpServletResponse response,
			@RequestParam("aupageIndex")String up) throws IOException{
		List<Users> userList=this.userServiceImpl.listUserByPage(Integer.parseInt(up));
		
		//分页
		int pageCount=this.userServiceImpl.findUserPageCount();
		session.setAttribute("aupageCount",pageCount);
		int pageIndex=1;
		 session.setAttribute("aupageIndex",pageIndex);
		 if(0==pageIndex|| pageIndex<0) {
			 session.setAttribute("aupageIndex",1);
			 
		 }else {
			 session.setAttribute("aupageIndex",pageIndex);
			 	}
		 
		session.setAttribute("userList", userList);
		response.sendRedirect("/Cake/adminUsers.jsp");
	}
	//通过ID查询用户
	@RequestMapping("/findByIdList")
	public Users findById(@RequestParam("userid")String id,HttpServletResponse response) {
		return this.userServiceImpl.findUserById(Integer.parseInt(id));
	}
	//删除一个用户
		@RequestMapping("/deleteOneUser")
		public void AdminDeleteUser(HttpServletResponse response,
				HttpSession session,
				@RequestParam("userid")String userid) throws IOException {
			    this.userServiceImpl.deleteOneUser(Integer.parseInt(userid));;
				response.sendRedirect("/Cake/adminUsers.jsp");
			}
	
}


