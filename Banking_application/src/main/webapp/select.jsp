<%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Customer customer = (Customer)session.getAttribute("customer"); %>
	<h1><%= "Hello "+customer.getName() %></h1>
	
	<form action="createaccount" method="post">
	
		<h1>Select your bank account type</h1>
		<input type="radio" name="banktype" value="savings" required="required">Savings <br><br>
		<input type="radio" name="banktype" value="current" required="required">Current <br><br>
		
		<button>Submit</button>
		
	</form>
</body>
</html>