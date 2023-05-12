<%@page import="DTO.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Welcome to Buy and Sell</h1>
<%
 Customer customer=(Customer) session.getAttribute("customer");
 if(customer==null){
 %><br><br>
<a href="Login.html "><button>Login</button></a><br><br>
 <a href="Signup.html"><button>Signup</button></a><br><br>
 <%}
 %>
<a href=""><button>Buy</button></a><br><br>
<a href="sell"><button>Sell</button></a><br><br>



 <a href="logout"> <button>Logout</button></a>


</body>
</html>