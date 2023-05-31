package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setactiveaccounts")

public class Set_active_acc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acn = req.getParameter("acno");
		
		long acno = Long.parseLong(acn);
		
		 req.getSession().setAttribute("acno", acno);
		 
		 req.getRequestDispatcher("Accounthome.jsp").include(req, resp);
	}
}
