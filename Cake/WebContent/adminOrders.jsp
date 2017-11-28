
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>adminOrders</title>
	<style>
		*{
			font-size: 16px;
			margin:0 auto;
			padding:0;
			text-align:center;
			color: #34495e;
		}
		body{
			width: 100%;
		}
		.mybody{
			width: 1200px;
			padding-top: 50px;
		}
		table{
			border: 1px #ddd solid;
			border-collapse:collapse;
		}
		.tableone{
		    width:1000px;
		}
		
		
		td,th{
			border: 1px #ddd solid;
			padding: 8px;
		}
		.title{
			font-size: 18px;
		}
		a{
			text-decoration: none;
			
		}
		.nav li a:link{
			color: #005599;
			height: 30px;
			width: 150px;
			display: block;
		}
		.nav li a:hover{
			color: #fff;
			background: #005599;
			
		}
		.nav li a:active{
			color: #fff;
			background: #005599;
		}
		.nav{
			width: 150px;
			position: fixed;
			left: 20px;
			top: 300px;
		}
		li{
			list-style: none;
			line-height: 30px;
		}
		.footer li{
			display: inline;
			margin: 0 10px 0 10px;
			line-height: 30px;
			width: 100px;
			border: 1px #ddd solid;
			padding: 8px;
			border-radius: 3px;
		}
		.footer li a{
			display: inline-block;
			width: 100px;
			height: 30px;
		}
		.footer{
			margin-top: 30px;
		}
		.footer li a:hover{
			color: #22AADD;
		}
		#pagetwo,#pagethree{
			margin-top: 500px;
		}
	</style>
</head>
<body>
	<div class="mybody">	
	<!--pageone-->
		<div id="pageone">
			<!--导航-->
			<ul class="nav">
				<li><a href="#pageone">商品管理</a></li>
				<li><a href="#pagetwo">用户管理</a></li>
				<li><a href="#pagethree">订单管理</a></li>
			</ul>
			
			<!-- 使用table来显示数据 -->
			<table class="tableone">
				<tr>
					<th class="title" colspan="9">商品列表</th>
				</tr>
				<tr>
					<th>蛋糕编号</th>
					<th>蛋糕名称</th>
					<th style="width:100px;">蛋糕信息</th>
					<th>蛋糕价格</th>
					<th>蛋糕图片</th>
					<th>蛋糕图片一</th>
					<th>蛋糕图片二</th>
					<th>蛋糕图片三</th>
					<th></th>
				</tr>
		<c:forEach items="${cakelist}" var="cake" varStatus="i">
				<!-- 将cake对象中的数据显示出来 -->
				<tr>
			        <td>${cake.id }</td>
					<td>${cake.gname }</td>
					<td>${cake.detail}</td>
					<td>${cake.price }</td>
					<td>${cake.listimg }</td>
					<td>${cake.img1 }</td>
					<td>${cake.img2 }</td>
					<td>${cake.img3 }</td>
					<td><a href="admin/delete">delete <c:out value="${i.index}"/></a></td>
				</tr>
			</c:forEach>
			</table>

		
			<ul class="footer">
			<c:if test="${pageIndex>1 }">
			<li><a href="PageDivide?pageIndex=1">首页</a></li>
			<li><a href="PageDivide?pageIndex=${pageIndex-1}">上一页</a>&nbsp;&nbsp;</li></c:if>
			<c:if test="${pageIndex<pageCount }">
			<li><a href="PageDivide?pageIndex=${pageIndex+1}">下一页</a>&nbsp;&nbsp;</li>
			<li><a href="PageDivide?pageIndex=${pageCount}">页尾</a>&nbsp;&nbsp;</li>
			</c:if>
			</ul>
		</div>	
		<!--pagetwo-->
		<div id="pagetwo">
			
			
			<!-- 使用table来显示数据 -->
<table>
				<tr>
					<th class="title" colspan="6">用户管理</th>
				</tr>
				<tr>
					<th>用户编号</th>
					<th>用户姓名</th>
					<th>用户密码</th>
					<th>用户地址</th>
					<th>邮箱</th>
					<th>delete</th>
				</tr>
            <c:forEach var="user" items="${userlist }" varStatus="i">
				<!-- 将book对象中的数据显示出来 -->
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.password }</td>
					<td>${user.address }</td>
					<td>${user.email }</td>
					<td><a href="deleteBookListTest">delete<c:out value="${i.index }"/></a></td>
				</tr>
			<!--</c:forEach>-->
			</table>
			
			<ul class="footer">
			<c:if test="${pageIndex>1 }">
			<li><a href="PageDivide?pageIndex=1">首页</a></li>
			<li><a href="PageDivide?pageIndex=${pageIndex-1}">上一页</a>&nbsp;&nbsp;</li></c:if>
			<c:if test="${pageIndex<pageCount }">
			<li><a href="PageDivide?pageIndex=${pageIndex+1}">下一页</a>&nbsp;&nbsp;</li>
			<li><a href="PageDivide?pageIndex=${pageCount}">页尾</a>&nbsp;&nbsp;</li>
			</c:if>
				</ul>
		</div>
		
		<!--pagethree-->
		<div id="pagethree">
			
			
			<!-- 使用table来显示数据 -->
			<table>
				<tr>
					<th class="title" colspan="5">订单管理</th>
				</tr>
				<tr>
					<th>订单编号</th>
					<th>蛋糕编号</th>
					<th>数量</th>
					<th>总价</th>
					<th></th>
				</tr>
	   <c:forEach var="order" items="${orderlist}">
				<!-- 将cake对象中的数据显示出来 -->
				<tr>
					<td>${order.oid }</td>
					<td>${order.cid }</td>
					<td>${order.count }</td>
					<td>${order.total }</td>
					<td><a href="deleteBookListTest">delete</a></td>
				</tr>
			<!--</c:forEach>-->
			</table>
			
		<ul class="footer">
			<c:if test="${pageIndex>1 }">
			<li><a href="PageDivide?pageIndex=1">首页</a></li>
			<li><a href="PageDivide?pageIndex=${pageIndex-1}">上一页</a>&nbsp;&nbsp;</li></c:if>
			<c:if test="${pageIndex<pageCount }">
			<li><a href="PageDivide?pageIndex=${pageIndex+1}">下一页</a>&nbsp;&nbsp;</li>
			<li><a href="PageDivide?pageIndex=${pageCount}">页尾</a>&nbsp;&nbsp;</li>
			</c:if>
		</ul>
		</div>
		
	</div>
</body>
</html>

