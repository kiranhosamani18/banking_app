package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Bankaccounts;

@WebServlet("/adminlogin")

public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		
		String password = req.getParameter("password");
		
		if (email.equals("admin")&&(password.equals("admin"))) {
			resp.getWriter().print("<h1>Admin logged in successfully</h1>");
			
			CustomerDao customerDao = new CustomerDao();
			List<Bankaccounts> list = customerDao.fetchall();
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("Admin.jsp").include(req, resp);
		} 
		else {
			resp.getWriter().print("Entered invalid credentials");
			req.getRequestDispatcher("AdminLogin.html").include(req,resp);
		}
	}
}
