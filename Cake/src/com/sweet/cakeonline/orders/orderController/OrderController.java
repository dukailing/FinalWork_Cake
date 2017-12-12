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
import com.sweet.cakeonline.shoppingcart.service.ShoppingCartServiceImpl;
import com.sweet.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("order")
public class OrderController {
	@Resource
	private OrderServiceImpl oderServiceImpl;
	@Resource
	private UserServiceImpl userServiceImpl;
	@Resource
	private ShoppingCartServiceImpl shoppingCartServiceImpl;
	
	/**
	 * 提交订单进入数据库
	 * @param price
	 * @param id
	 * @param shopid
	 * @param cakeimg
	 * @param cname
	 * @param userid
	 * @param count
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deliverOrder")
	public void DeliverOrder(@RequestParam("price")float price,
			@RequestParam("cakeid")Integer id,
			@RequestParam("sid")String shopid,
			@RequestParam("cakeimg")String cakeimg,
			@RequestParam("cakename") String cname,
			@RequestParam("userid") String userid,
			//@RequestParam("quantity")int count,
			@RequestParam("quantity")String count,
			HttpServletResponse response) throws IOException {
		//将购物车物品提交进订单数据库
		Orders order=new Orders();
		order.setCid(id);
		order.setCname(cname);
		order.setCount(Integer.parseInt(count));
		float total=(float)(Integer.parseInt(count))*price;
		order.setTotal(total);
		Users u=this.userServiceImpl.findUserById(Integer.parseInt(userid));
		order.setUsers(u);
	    order.setCakeimg(cakeimg);
	    this.oderServiceImpl.addOneOrder(order);	
		//删除购物车中的订单
		ShoppingCart sh=this.shoppingCartServiceImpl.findById(Integer.parseInt(shopid));
		this.shoppingCartServiceImpl.deleteOneCake(sh);
		//页面跳转
		response.sendRedirect("/Cake/shoppingCart.jsp");
	}
	
	/**
	 * 查看已提交订单
	 * @param userid
	 * @param page
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/listOrders")
		public void listOrders(
				@RequestParam("userid")int userid,
				@RequestParam("opageIndex")Integer page,
				HttpSession session,
				HttpServletResponse response) throws IOException {
			List<Orders> orders=this.oderServiceImpl.listAll(page, userid);
			session.setAttribute("orders", orders);	
			//分页查询
			int pageCount=this.oderServiceImpl.findOrderPageCount(userid);
			session.setAttribute("opageCount",pageCount);
			int pageIndex=1;
			session.setAttribute("opageIndex",pageIndex);
			if(0==pageIndex|| pageIndex<0) {
				session.setAttribute("opageIndex",1);					 
			}else {
				session.setAttribute("opageIndex",page);
			}
			response.sendRedirect("/Cake/orders.jsp");
		}
}
