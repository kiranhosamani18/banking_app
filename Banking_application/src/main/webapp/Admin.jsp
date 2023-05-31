<%@page import="Dto.Bankaccounts"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List<Bankaccounts> list = (List<Bankaccounts>)request.getSession().getAttribute("list"); %>
	
	<table border="1">
		<tr>
		
		<th>Account number</th>
		<th>Bank type</th>
		<th>Status</th>
		<th>Customer name</th>
		<th>Customer Id</th>
		<th>Change Status</th>
		<% for(Bankaccounts bankaccounts:list) {%>
		
			<tr>
				<th><%= bankaccounts.getAcc_no() %></th>
				<th><%= bankaccounts.getBank_type()%></th>
				<th><%= bankaccounts.isStatus()%></th>
				<th><%= bankaccounts.getCustomer().getName()%></th>
				<th><%= bankaccounts.getCustomer().getCust_id()%></th>
				<th><a href="changestatus?acno=<%=bankaccounts.getAcc_no()%>"><button>Change_status</button></a></th>
			</tr>
				
		<%}%>
		</tr>
	</table>
</body>
</html>