package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bankaccounts;

@WebServlet("/changestatus")

public class Change_status extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acn = req.getParameter("acno");
		
		long acon = Long.parseLong(acn);       //parsing
		
		BankDao bankDao = new BankDao();
		
		Bankaccounts bankaccounts = bankDao.find(acon);
		
		if (bankaccounts.isStatus()) {
				bankaccounts.setStatus(false);
		}
		else {
			bankaccounts.setStatus(true);
		}
		bankDao.update(bankaccounts);
		
		resp.getWriter().print("<h1>Account status has been updated successfully</h1>");
		
		List<Bankaccounts> list = bankDao.fetchall();
		
		req.getSession().setAttribute("list", list);
		
		req.getRequestDispatcher("Admin.jsp").include(req,resp);
	}
}
