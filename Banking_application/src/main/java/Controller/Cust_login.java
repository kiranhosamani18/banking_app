package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Customer;

@WebServlet("/login")

public class Cust_login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("cust_id");       //
		int custid = Integer.parseInt(id);
		
		String password = req.getParameter("pwd");
		
		CustomerDao customerDao = new CustomerDao();
		
		Customer customer = customerDao.login(custid);
		
		
		if (customer==null) 
		{
				resp.getWriter().print("<h1>Entered invalid customer id</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
		} 
		else {
				if (customer.getPassword().equals(password))
				{
						resp.getWriter().print("<h1>Login Successfully</h1>");
						req.getSession().setAttribute("customer", customer);
						req.getRequestDispatcher("customerhome.html").include(req, resp);
				}
				else{
			resp.getWriter().print("<h1>Entered wrong password</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);   
				}
		}
	}
}
