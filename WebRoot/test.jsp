<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>My JSP 'index.jsp' starting page</title>
	</head>
	<body>
	
		<a href=".">首页</a><br/>
		<a href="javascript:history.go(-1);">上一页</a><br/>
		
		Strust2添加成功！<br/>
		Strust2与Spring整合成功！<br/>
		Strust2与Spring与Hibernate整合成功！<br/><hr/>
		
		<h5>№1 struts2案例测试</h5>
		<form action="test_0.action" method="get">
			<input type="submit" value="go to test">
		</form>
		
		<h5>№2 ssh案例测试</h5>
		<form action="demo_User_list.action" method="get">
			<input type="submit" value="go to demo_User_list">
		</form>
		
		<h5>№3 ssh案例测试</h5>
		<form action="Customer_listCustomer.action" method="get">
			<input type="submit" value="go to customer.jsp">
		</form>
		
		<h5>itcast test</h5>
		<form action="user_list.action" method="get">
			<input type="submit" value="go to user_list.action">
		</form>
	
	</body>
</html>
