<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%out.println("Login Successful! \n" +" Welcome :"+ "<h3>" + session.getAttribute("name") + "!" + "</h3>"); %></br>
	<button onclick="window.location.href='login.html';">Logout</button>
	<button onclick="window.location.href='Registration.html';">Registration</button>
	<% session.invalidate();%>
	
</body>
</html>