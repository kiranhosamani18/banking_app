package Controller;

import java.awt.image.BandCombineOp;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dao.CustomerDao;
import Dto.Bankaccounts;
import Dto.Customer;

@WebServlet("/createaccount")

public class Create_bank_acc extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String banktype = req.getParameter("banktype");
		
		Customer customer = (Customer)req.getSession().getAttribute("customer");   //The return type of get attribute is object
			boolean flag = true;
			
			List<Bankaccounts> list = customer.getBankaccounts();
			                  // savings
			
			for (Bankaccounts bankaccounts : list)
			{
				if (bankaccounts.getBank_type().equals(banktype))
				{
					flag = false;
//					resp.getWriter().print("<h1>Account already exists</h1>");
				}
			}
		Bankaccounts bankaccounts = new Bankaccounts();
		                                // current
		if (flag) {
			bankaccounts.setBank_type(banktype);
		
//		bankaccounts.setAcc_no(acc_no);            it will get generated auto
//		bankaccounts.setAmount(amount);            by default amount will start start from 0 only
//		bankaccounts.setStatus(status);            by default status will be false its not required to set the status
		
		if (banktype.equals("savings")) {
			bankaccounts.setAcc_limit(10000);
		} else {
			bankaccounts.setAcc_limit(5000);
		}
		
		bankaccounts.setCustomer(customer);
		
		BankDao bankDao = new BankDao();
		bankDao.save(bankaccounts);
		
		List<Bankaccounts> list2 = list;          // list = savings---> we have copied that list
		list2.add(bankaccounts);                  // list2 + current = savings + current
		
		customer.setBankaccounts(list2);
		
		CustomerDao customerDao = new CustomerDao();
		customerDao.update(customer);
		
		resp.getWriter().print("<h1>Account has been created successfully waiting for manager approval</h1>");
		req.getRequestDispatcher("AdminLogin.html").include(req, resp);
		}
		
		else {
			resp.getWriter().print("<h1>Account already exists</h1>");
		}
	}
}
