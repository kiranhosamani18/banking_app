package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bank_Transaction;
import Dto.Bankaccounts;

@WebServlet("/Withdraw")

public class Withdraw extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String amt = req.getParameter("amount");
		
		Double amount = Double.parseDouble(amt);  //ref. var and var
		
		 Long acno = (Long)req.getSession().getAttribute("acno");
		 
		 BankDao bankDao = new BankDao();
		 
		 Bankaccounts bankaccounts = bankDao.find(acno);
		 
		 if (amount>bankaccounts.getAmount()) {
			resp.getWriter().print("<h1>Insuffiecient balance</h1>");
		}
		 else {
			if (amount>bankaccounts.getAcc_limit()) 
			{
				resp.getWriter().print("<h1>The amount you have entered is more than your accout limit : Your account limit is : "+bankaccounts.getAcc_limit()+"</h1>");
			}
			else
			{
				bankaccounts.setAmount(bankaccounts.getAmount()-amount);  //5000+5000=10000
				 
				 //bankDao.update(bankaccounts);
				 
				 resp.getWriter().print("<h1>Amount has been withdrawn Successfully</h1>");
				 req.getRequestDispatcher("Accounthome.jsp").include(req, resp);
				 
				 
				 Bank_Transaction bank_Transaction = new Bank_Transaction();
				 
				 bank_Transaction.setTransaction_id(0);
				 bank_Transaction.setDeposit(0);
				 bank_Transaction.setWithdraw(amount);
				 bank_Transaction.setBalance(bankaccounts.getAmount());
				 bank_Transaction.setDate_time(LocalDateTime.now());
				 
				 List<Bank_Transaction> list = bankaccounts.getBank_Transactions();
				 
				 list.add(bank_Transaction);
				 bankDao.update(bankaccounts);
			}
		}
		 
		/* bankaccounts.setAmount(bankaccounts.getAmount()-amount);  //5000+5000=10000
		 
		 bankDao.update(bankaccounts);
		 
		 resp.getWriter().print("<h1>Amount has been withdrawn Successfully</h1>");*/
	}
}
