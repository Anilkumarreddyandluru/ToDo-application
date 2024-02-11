<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String title=request.getParameter("title");
String topic=request.getParameter("topic");
String status=request.getParameter("status");
String date=request.getParameter("date");
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");
	PreparedStatement ps=con.prepareStatement("update  tasks set status=? where topic=?");
	
	ps.setString(1, status);
	ps.setString(2, topic);
	ps.executeUpdate();
	
	response.sendRedirect("viewtask.jsp");
	
}
catch(Exception e){
	e.printStackTrace();
}

%>
<h1>updated success</h1>
</body>
</html>