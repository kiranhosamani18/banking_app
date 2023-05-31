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
	<% List<Bankaccounts> list = (List<Bankaccounts>)request.getSession().getAttribute("list");
		if(list.isEmpty()){%>
		
		<h1>No active accounts found</h1>
		<%}else{%>
			<%for(Bankaccounts bankaccounts:list) {%>
			
			<h1>Select account</h1>
			
			<a href="setactiveaccounts?acno=<%=bankaccounts.getAcc_no()%>"><button><%= bankaccounts.getAcc_no() %></button></a>
		<% }%>
	<%}%>
</body>
</html>