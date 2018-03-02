<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>SSH增删改查</title>
  </head>
  
  <body>
    
    <h3><b>№2 SSH-增.删.改.查</b></h3>
    
    <b>查询所有数据:findAll()</b>
    <table border="1px" cellpadding="8px">
    	<tr>
	    	<th width="50">id</th>
	    	<th width="100">userName</th>
	    	<th width="100">loginName</th>
	    	<th width="100">password</th>
	    	<th width="100">photoNum</th>
	    	<th width="150">edit</th>
    	</tr>
    	<s:iterator value="#demo_UserList">
    	<tr>
	    	<td width="50">${id}</td>
	    	<td width="100">${userName}</td>
	    	<td width="100">${loginName}</td>
	    	<td width="100">${password}</td>
	    	<td width="100">${photoNum}</td>
	    	<td width="150">
	    		&nbsp;&nbsp;&nbsp;
				<s:a action="demo_User_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">delete</s:a>
				&nbsp;&nbsp;&nbsp;
				<s:a action="demo_User_update?id=%{id}">update</s:a> 
	    	</td>
    	</tr>
    	</s:iterator>
    </table>
    <b>增加数据:save()</b>
    	<s:form action="demo_User_add.action">
    		userName:<br>
    		<s:textfield name="userName" label="userName"></s:textfield><br>
    		loginName:<br>
    		<s:textfield name="loginName" label=""></s:textfield><br>
    		password:<br>
    		<s:textfield name="password" label=""></s:textfield><br>
    		photoNum:<br>
    		<s:textfield name="photoNum" label=""></s:textfield><br><br>
    		<s:submit value="confirm"/>
    	</s:form>
  </body>
</html>

