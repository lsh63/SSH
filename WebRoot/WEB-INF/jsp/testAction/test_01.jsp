<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'test_01.jsp' starting page</title>
  </head>
  
  <body>
  <h3>№1 struts2案例</h3>
    <a href="test.jsp">返回test.jsp</a>
    
    <form action="testAction_01.action" method="get">
    	<label>input the name:</label>
    	<input type="text" name="name" value="SECRET">
    	<input type="submit" value="confirm">
    </form>

  </body>
</html>
