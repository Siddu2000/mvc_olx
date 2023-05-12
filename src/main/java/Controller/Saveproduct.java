package Controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.CustomerDao;
import DTO.Product;
@WebServlet("/saveproduct")
@MultipartConfig
public class Saveproduct extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 Product product=new Product();
	 product.setName("pname");
	 product.setDescription("pdescription");
	 product.setPrice(Double.parseDouble(req.getParameter("pprice")));
	 
	 
	 byte[] pic=null;
	 Part filepart=req.getPart("pimage");
	 if(filepart!=null){
		 InputStream inputstream=filepart.getInputStream();
		 pic =new byte [inputstream.available()];
		 inputstream.read(pic);
	 }
    product.setImage(pic);	
    CustomerDao customerDao=new CustomerDao();
    customerDao.save(product);
    
    resp.getWriter().print("<h1 style='color:)red'>Product is added</h1>");
    req.getRequestDispatcher("Home.jsp").include(req, resp);
	}
	

}
