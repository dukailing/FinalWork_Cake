package com.sweet.cakeonline.orders.orderController;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.entity.Orders;
import com.sweet.cakeonline.entity.ShoppingCart;
import com.sweet.cakeonline.entity.Users;
import com.sweet.cakeonline.orders.orderService.OrderServiceImpl;
import com.sweet.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("order")
public class OrderController {
	@Resource
	private OrderServiceImpl oderServiceImpl;
	@Resource
	private UserServiceImpl userServiceImpl;
	//提交订单进入数据库
	@RequestMapping("/deliverOrder")
	public void DeliverOrder(@RequestParam("price")float price,
			@RequestParam("cakeid")int id,
			@RequestParam("cakeimg")String cakeimg,
			@RequestParam("cakename") String cname,
			@RequestParam("userid") String userid,
			//@RequestParam("quantity")int count,
			@RequestParam("quantity")String count,
			HttpServletResponse response) throws IOException {
		Orders order=new Orders();
		order.setCid(id);
		order.setCname(cname);
		order.setCount(Integer.parseInt(count));
		//int total=Integer.parseInt(count)*price;
		//order.setCount(Integer.parseInt(count));
		float total=(float)(Integer.parseInt(count))*price;
		order.setTotal(total);
		Users u=this.userServiceImpl.findUserById(Integer.parseInt(userid));
		order.setUsers(u);
	    order.setCakeimg(cakeimg);
	    this.oderServiceImpl.addOneOrder(order);
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	//查看已提交订单
	@RequestMapping("/listOrders")
		public void listOrders(HttpSession session,@RequestParam("userid")int userid,
				@RequestParam("opageIndex")String p,HttpServletResponse response) throws IOException {
			List<Orders> orders=this.oderServiceImpl.listAll(Integer.parseInt(p), userid);
			session.setAttribute("orders", orders);
		
			//分页查询
			   int pageCount=1;
				 session.setAttribute("opageCount",pageCount);
				int pageIndex=1;
				 session.setAttribute("opageIndex",pageIndex);
				 if(0==pageIndex|| pageIndex<0) {
					 session.setAttribute("opageIndex",1);
					 
				 }else {
					 session.setAttribute("opageIndex",pageIndex);
					 	}
			response.sendRedirect("/Cake/orders.jsp");
		}
}
