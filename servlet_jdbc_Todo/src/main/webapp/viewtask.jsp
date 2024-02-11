<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

table {
    border-collapse: collapse; 
    width: 50%;
    border: 2px solid #000;
    border-radius: 3px; 
    background-color: blue;
}

th, td {
    border: 1px solid #ccc; 
    padding: 10px; 
    text-align: center;
    background-color: green;
    border-radius: 10px;
    
}
td{
font-size: 18px;
font-weight: bold;
}

th {
    background-color: violet; 
    font-weight: bold;
    color: rgb(26, 2, 33);
}
td:hover{
background-color: maroon;
color: white;

}
h1{
text-align: center;
color: red;
font-size: 30px;
margin-top: 50px;
}
body{
background-color: rgb(57, 7, 69);

}
a{
text-decoration: none;
}
a:hover{
color: white;
}
.footer{
    background-color:rgb(128, 0, 0) ;
    text-align: center;
    padding: 10px;
    line-height: 30px;
    color:white;
    font-weight: bold;
    font-size: 20px;
    margin-top: 350px;
  }




</style>
</head>
<body>

<h1>TASKS</h1>
<table cellpadding=2px cellspacing=5px  rules="all" align="center">
<tr>
    <th>TITLE</th>
    <th>TOPIC</th>
    <th>STATUS</th>
    <th>DATE</th>
     <th colspan=2>ACTION</th>
    
      
    
</tr>




<%   
Connection con=null;
Statement st=null;
ResultSet rs=null;

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");
	 st=con.createStatement();
	 rs=st.executeQuery("select * from tasks");
		while(rs.next()){
			%>
			<tr>
			<td><%= rs.getString(1) %></td>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %></td>
			<% String topic=rs.getString("topic");%>
			<td><a href="./taskupdate.html"> update</a></td>
			<td><a href="./deletetask.jsp?topic=<%=topic%>">delete </a></td>
			
			
			
			
			
			</tr>
			
			 <%
			
		}
}
catch(Exception e){
	e.printStackTrace();
}
%>
</table>
<div class="footer">
        <p>&copy;All rights reserved - 2023/Anil Reddy</p>
      </div>


</body>
</html>