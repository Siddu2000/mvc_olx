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

import DAO.CustomerDao;
import DTO.Customer;
@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mob");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		Date date=Date.valueOf(dob);
		int age=Period.between(date.toLocalDate(),LocalDate.now()).getYears();
		CustomerDao dao=new  CustomerDao();
		if(age<18){
			resp.getWriter().print("<h1 style='color:red'>Can not create Account,Age Should be Greater than 18</h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);;	
		}
		else{
			if(dao.find(Long.parseLong(mobile)).isEmpty()&&dao.find(email).isEmpty())
					{
				
			Customer customer=new Customer();
			customer.setName(name);
			customer.setEmail(email);
			customer.setMobile(Long.parseLong(mobile));
			customer.setPassword(password);
			customer.setGender(gender);
			customer.setDob(Date.valueOf(dob));
			customer.setAge(age);
		
		dao.save(customer);
		
		Customer customer2=dao.find(email).get(0);
		resp.getWriter().print("<h1 style='color:green'>Account Created succesfully</h1>");
		resp.getWriter().print("<h1 style='color:blue'>Your Customer Id is:"+customer2.getCustid()+"</h1>");
		req.getRequestDispatcher("Home.jsp").include(req, resp);
			
		}
			else{
				resp.getWriter().print("<h1 style='color:red'>Cannot create an account</h1>" );
				req.getRequestDispatcher("Signup.html").include(req, resp);
			}
	} 

}
}