<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
response.sendRedirect(request.getContextPath() + "/home_index.action");
%>
<!-- 
request.getContextPath()得到的是项目的名字,如果项目为根目录,则得到一个"",即空的字条串；
request.getScheme()返回的协议名称,默认是http；
request.getServerName()返回的是你浏览器中显示的主机名；
getServerPort()获取服务器端口号；
 -->
 
 <!-- 
 重定向（sendRedirect）的工作原理：
 客户发送一个请求到服务器，服务器匹配servlet，这都和请求转发一样，
 servlet处理完之后调用了sendRedirect()这个方法，这个方法是response的方法，
 所以，当这个servlet处理完之后，看到response.senRedirect()方法，
 立即向客户端返回这个响应，响应行告诉客户端你必须要再发送一个请求，去访问request.getContextPath() + "/home_index.action" 
 -->