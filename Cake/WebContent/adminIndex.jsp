<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminIndex</title>
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
			background:#faa
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
</style>

</head>
<body background=#aaf>
<center>
<ul class="nav">
				<li><a href="admincake/listAdminCake?acpageIndex=1">蛋糕管理</a></li>
				<li><a href="user/list?aupageIndex=1">用户管理</a></li>
				<li><a href="adminorder/listAdminOrder?aopageIndex=1">订单管理</a></li>
				<li><a href="${ctx}/adminLogin.jsp">退出登录</a></li>
			</ul>
			<div>
			<br><br><br><br>
			<img alt="" src="${ctx }/static/images/g2.jpg">
			</div>
</center>
</body>
</html>