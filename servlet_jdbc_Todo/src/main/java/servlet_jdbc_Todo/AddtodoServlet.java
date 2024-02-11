package servlet_jdbc_Todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addnewtodo")

public class AddtodoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title=req.getParameter("title");
		String topic=req.getParameter("topic");
		String status=req.getParameter("status");
		String date=req.getParameter("date");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into tasks values(?,?,?,?)");
			ps.setString(1, title);
			ps.setString(2, topic);
			ps.setString(3, status);
			ps.setString(4, date);
			ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		resp.sendRedirect("viewtask.jsp");
		
	}
	

}
