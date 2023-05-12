package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CustomerDao;
import DTO.Customer;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int custid=Integer.parseInt(req.getParameter("cid"));
		String password=req.getParameter("password");
		
		CustomerDao dao=new CustomerDao();
		
	Customer customer=dao.find(custid);
	
	if(customer==null){
		resp.getWriter().print("<h1 style='color:red'>Incorrect Customer Id</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
	else{
		req.getSession().setAttribute("customer", customer);
		if(customer.getPassword().equals(password)){
			resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
			req.getRequestDispatcher("Home.jsp").include(req, resp);
		}
		else{
			resp.getWriter().print("<h1 style='color:red'>Incorrect password</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
	}

}
