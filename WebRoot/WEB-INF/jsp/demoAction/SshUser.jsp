<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
 
<body>
<h1>Struts 2 + Spring + Hibernate integration example</h1>

<h2>Add Customer</h2>
	<s:form action="Customer_addCustomer">
		NAME:<br>
	  <s:textfield name="name" label="Name" value="" /><br>
	  	ADDRESS:<br>
	  <s:textarea name="address" label="Address" value="" cols="50" rows="5" /><br>
	  <s:submit />
	</s:form>

<h2>All Customers</h2>

	<s:if test="customerList.size() > 0">
	<table border="1px" cellpadding="8px">
		<tr>
			<th width="100">Customer Id</th>
			<th width="100">Name</th>
			<th width="100">Address</th>
			<th width="100">Created Date</th>
			<th width="100">Edit</th>
		</tr>
		<s:iterator value="customerList" status="userStatus">
			<tr>
				<td width="100" height="30"><s:property value="customerId" /></td>
				<td width="100" height="30"><s:property value="name" /></td>
				<td width="100" height="30"><s:property value="address" /></td>
				<td width="100" height="30"><s:date name="createdDate" format="dd/MM/yyyy" /></td>
				<td width="130" height="30">
					&nbsp;&nbsp;
					<s:a action="Customer_deleteCustomerById?customerId=%{customerId }">delete</s:a>
					&nbsp;&nbsp;&nbsp;
					<s:a action="Customer_updateCustomer?customerId=%{customerId}">update</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
	</s:if>
<br/>
<br/>

</body>
</html>

