package com.sweet.cakeonline.user.controller;

import java.util.List;

import javax.annotation.Resource;
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
	public String login(@RequestParam("username") String loginName,
			@RequestParam("password") String password,
			Model model, HttpSession session){
	//	Users user=this.userServiceImpl.login(loginName, password);
		List<Users> userList=this.userServiceImpl.listUser();
		//到集合中查找用户是否存在，此处用来模拟数据库验证  
        for(Users user:userList){  
            if(user.getName().equals(loginName) && user.getPassword().equals(password)){  
                model.addAttribute("user", user);  
                return "index";  
            }  
        }  
//        return "loginForm";  
//    }  
//		if(user!=null){
//			session.setAttribute("user", user);
//			return "index";
//		}else{
//			model.addAttribute("errorinfo", "您的账号密码不正确！");
			return "userLogin";
	}
	
	//用户注册
	@RequestMapping("/userRegist")
	public String regist(@RequestParam("username") String loginName,
			@RequestParam("password") String password,@RequestParam("confirmpassword") String confirmpassword,
			@RequestParam("address") String address,@RequestParam("email") String email,
			Model model, HttpSession session) {
		if(password.equals(confirmpassword) ) {
		Users u=new Users();
		u.setAddress(address);
		u.setEmail(email);
		u.setName(loginName);
		u.setPassword(password);
		this.userServiceImpl.addUser(u);
		model.addAttribute("user", u);
		return "userLogin";
		}else {
			return "userRegist";
		}
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Users> userList=this.userServiceImpl.listUser();
		model.addAttribute("userList", userList);
		return "list";
	}
	
}


