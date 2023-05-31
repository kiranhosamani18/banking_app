package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Customer;

@WebServlet("/sign")                                                                              //Second    mapping

public class Cust_signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			CustomerDao customerDao = new CustomerDao();       
		
		 String name = req.getParameter("name");      
		 
		 String mob = req.getParameter("mobile");
		 long mobile = Long.parseLong(mob);
		 
		 String email = req.getParameter("email");
		 
		 String password = req.getParameter("password");
		 
		 String gender = req.getParameter("gender");
		 
		 String dob = req.getParameter("dob");
		 
		 
		 /*resp.getWriter().print("<h1>"+name+"</h1>"
		 +"<h1>"+name+"</h1>"
		 +"<h1>"+mob+"</h1>"
		 +"<h1>"+email+"</h1>"
		 +"<h1>"+password+"</h1>"
		 +"<h1>"+gender+"</h1>"
		 +"<h1>"+dob+"</h1>");*/ 
		 
		 Date date = Date.valueOf(dob);  //converted to date datatype                
		 
		 Period period = Period.between(date.toLocalDate(), LocalDate.now());
		 
		 int age = period.getYears();
		 
		 if (age<18)
		 {
			 resp.getWriter().print("<h1> you have to be 18 to create account </h1>");
			 req.getRequestDispatcher("Signup.html").include(req, resp);
		 }
		 else{
			 if(customerDao.check(mobile).isEmpty()&&customerDao.check(email).isEmpty())
			 {
				 Customer customer = new Customer();
				 customer.setDate(date);
				 customer.setEmail(email);
				 customer.setGender(gender);
				 customer.setMobile(mobile);
				 customer.setName(name);
				 customer.setPassword(password);
				 
				 customerDao.save(customer);
				 
				 resp.getWriter().print("<h1>Account has been created successfully</h1>");
				 req.getRequestDispatcher("Login.html").include(req, resp);
				 
				 Customer customer2 = customerDao.check(email).get(0);
				 
				 int id = customer2.getCust_id();
				 
				 if (customer2.getGender().equals("male")) {
					resp.getWriter().print("<h1>hello sir</h1>");
				}
				 else {
					 resp.getWriter().print("<h1>hello madam</h1>");
				}
				 resp.getWriter().print("<h1>your customer id is "+id+"</h1>");
			 }
			 else {
				resp.getWriter().print("<h1>Account already exists</h1>");
//				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		 }
		 
	}
}
