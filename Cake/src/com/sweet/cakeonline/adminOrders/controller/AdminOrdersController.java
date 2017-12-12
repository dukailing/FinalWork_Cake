package com.sweet.cakeonline.adminOrders.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.cakeonline.adminOrders.service.AdminOrdersServiceImpl;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.Orders;
import com.sweet.cakeonline.entity.Users;
import com.sweet.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("adminorder")
public class AdminOrdersController {
	@Resource
	private AdminOrdersServiceImpl  adminOrdersServiceImpl ;
	@Resource UserServiceImpl usersServiceImpl;
	
	/**
	 * 分页查找所有订单
	 * @param op
	 * @param response
	 * @param session
	 * @throws IOException
	 */
		@RequestMapping("/listAdminOrder")
		public void ListAdminCake(@RequestParam("aopageIndex")Integer op,
				HttpServletResponse response,HttpSession session) throws IOException {
		List<Orders> orderlist=this.adminOrdersServiceImpl.listAllOrders(op);
        List<Integer> userids=new ArrayList<Integer>();
        for(Orders or:orderlist) {
            userids.add(or.getOid());
        }
        session.setAttribute("userids", userids);
		//分页
		int pageCount=this.adminOrdersServiceImpl.findOrderPageCount();
		session.setAttribute("aopageCount",pageCount);
		int pageIndex=1;
		session.setAttribute("aopageIndex",pageIndex);
		if(0==pageIndex|| pageIndex<0) {
			session.setAttribute("aopageIndex",1);				 
		}else {
            session.setAttribute("aopageIndex",pageIndex);
		}			
		session.setAttribute("adminorderlist", orderlist);
		response.sendRedirect("/Cake/adminOrders.jsp");
	}
		
	/**
	* 删除一个订单
	* @param orderid
	* @param response
	* @param session
    * @throws IOException
	*/
    @RequestMapping("/deleteOneOrder")
	public void AdminDeleteOrder(
		        @RequestParam("orderid")String orderid,
				HttpServletResponse response,
				HttpSession session) throws IOException {
		this.adminOrdersServiceImpl.deleteOneOrder(Integer.parseInt(orderid));
		response.sendRedirect("/Cake/adminOrders.jsp");
	}
    /**
     * 增加或修改一个订单
     * @param oid
     * @param cid
     * @param cname
     * @param count
     * @param total
     * @param userid
     * @param response
     * @param request
     * @throws IOException
     */
	@RequestMapping("/saveOneOrders")		
	public void saveOneOrders(
			@RequestParam("oid")Integer oid,
			@RequestParam("cid")Integer cid,
			@RequestParam("cname")String cname,
			@RequestParam("count")Integer count,
			@RequestParam("total")Float total,
			@RequestParam("userid")Integer userid,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		Orders order=new Orders();
		//更新一个订单
		List <Orders> orderL=this.adminOrdersServiceImpl.listAllOrders();
		for(Orders torder: orderL) {
			if(torder.getOid()==oid) {
				order=this.adminOrdersServiceImpl.selectByOrderid(oid);
				order.setCid(cid);
				order.setOid(oid);
				order.setCname(cname);
				order.setCount(count);
				order.setTotal(total);
				Users user=this.usersServiceImpl.findUserById(userid);
				order.setUsers(user);
				this.adminOrdersServiceImpl.updateOneOrder(order);;
				request.setAttribute("oisUpdated", true);
				break;
			}else {
				request.setAttribute("oisUpdated",false);
			}				
		}		
		//保存一个订单
		if(request.getAttribute("oisUpdated").equals(false)) {	
		    order.setCid(cid);
		    order.setOid(oid);
		    order.setCname(cname);
			order.setCount(count);
			order.setTotal(total);
			Users user=this.usersServiceImpl.findUserById(userid);
			order.setUsers(user);
			this.adminOrdersServiceImpl.addOneOrder(order);
			}
		response.sendRedirect("/Cake/adminOrders.jsp");
			
		}
		
}
