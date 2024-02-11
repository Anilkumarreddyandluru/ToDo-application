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
String topic =request.getParameter("topic");
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");
	Statement st=con.createStatement();
	st.executeUpdate("delete from  tasks where topic='"+topic+"'");
	out.println("deleted succesfully");
	response.sendRedirect("viewtask.jsp");
	
	
}
catch(Exception e){
	e.printStackTrace();
}

%>

</body>
</html>