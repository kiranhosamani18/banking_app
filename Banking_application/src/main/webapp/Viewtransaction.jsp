<%@page import="Dto.Bank_Transaction"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Bankaccounts"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<h1>Transaction history</h1>
	<% Long acno = (Long)request.getSession().getAttribute("acno");
		
		BankDao bankDao = new BankDao();
		
		bankDao.find(acno);
		
		Bankaccounts bankaccounts = bankDao.find(acno);
		
		List<Bank_Transaction> list = bankaccounts.getBank_Transactions();
	
	%>
	
	<table border="1">
		<tr>
			<th>Transaction_id</th>
			<th>Deposit</th>
			<th>Withdraw</th>
			<th>Balance</th>
			<th>Date_time</th>
		</tr>
		
		<% for(Bank_Transaction bank_Transaction : list) {%>
			<tr>
				<th><%= bank_Transaction.getTransaction_id() %></th>
				<th><%= bank_Transaction.getDeposit() %></th>
				<th><%= bank_Transaction.getWithdraw() %></th>
				<th><%= bank_Transaction.getBalance() %></th>
				<th><%= bank_Transaction.getDate_time() %></th>
			</tr>	
			
		<% } %>
	</table>
	
	<br><br>
	<a href="Accounthome.jsp"><button>Back</button></a>
</body>
</html>