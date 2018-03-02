<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'Demo_User.jsp' starting page</title>
  </head>
  
  <body>
    This is my JSP page. <br>
    <h3>№2 struts2案例 SSH</h3>
    <tr>
    	<td width="100">userName</td>
    	<td width="100">loginName</td>
    	<td width="100">password</td>
    	<td width="100">photoNum</td>
    </tr>
    <tr>
    <s:iterator value="#demo_UserList">
    	<td width="100">${userName}</td>
    	<td width="100">${loginName}</td>
    	<td width="100">${password}</td>
    	<td width="100">${photoNum}</td>
    </s:iterator>
    </tr>
  </body>
</html>
