package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Bankaccounts;
import Dto.Customer;

@WebServlet("/fetchactiveaccounts")

public class Fetch_active_acc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = (Customer)req.getSession().getAttribute("customer");
		
		List<Bankaccounts> list = customer.getBankaccounts();
		
		List<Bankaccounts> list2 = new ArrayList<Bankaccounts>();
		
		for(Bankaccounts bankaccounts:list)
		{
			if (bankaccounts.isStatus()) {
				list2.add(bankaccounts);			
				}
		}
		
		req.getSession().setAttribute("list", list2);
		
		req.getRequestDispatcher("Accounts.jsp").include(req, resp);
		
		
	}
}
