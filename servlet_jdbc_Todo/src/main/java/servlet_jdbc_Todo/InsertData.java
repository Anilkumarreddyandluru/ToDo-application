package servlet_jdbc_Todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class InsertData extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String mobileno=req.getParameter("mobilenum");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
	    String password=req.getParameter("password");
		
   
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");
		PreparedStatement ps=con.prepareStatement("insert into userdata values(?,?,?,?,?,?)");
		
		
		
		ps.setString(1, firstname);
		ps.setString(2, lastname);
		ps.setString(3, mobileno);
		ps.setString(4, gender);
		ps.setString(5, email);
		ps.setString(6, password);
		ps.executeUpdate();
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	resp.sendRedirect("Signin.html");

		
	}

}
