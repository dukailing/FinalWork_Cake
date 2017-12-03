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
            
            //	 response.sendRedirect("/Cake/userLogin.jsp");

            

	}
	
	//用户注册
	@RequestMapping("/userRegist")
	public void regist(@RequestParam("username") String loginName,
			@RequestParam("password") String password,@RequestParam("confirmpassword") String confirmpassword,
			@RequestParam("address") String address,@RequestParam("email") String email,
			 HttpSession session,HttpServletResponse response) throws IOException {
		if(password.equals(confirmpassword) ) {
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
	//未用未知修改
	@RequestMapping("/list")
	public void list(HttpSession session,HttpServletResponse response) throws IOException{
		List<Users> userList=this.userServiceImpl.listUser();
		session.setAttribute("userList", userList);
		response.sendRedirect("");
	}
	@RequestMapping("/findByIdList")
	public Users findById(@RequestParam("userid")String id,HttpServletResponse response) {
		return this.userServiceImpl.findUserById(Integer.parseInt(id));
	}
	
}


