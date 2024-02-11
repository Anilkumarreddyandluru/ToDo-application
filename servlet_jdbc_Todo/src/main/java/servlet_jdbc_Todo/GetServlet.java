package servlet_jdbc_Todo;


	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/get")

	public class GetServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","root");
				PreparedStatement ps=con.prepareStatement("select email,password from userdata where email=? and password=?");
			    ps.setString(1, email);
			    ps.setString(2, password);
			    ResultSet rs=ps.executeQuery();
			    while(rs.next()) {
					if (email.equals(rs.getString(1))&& password.equals(rs.getString(2))) {
						resp.sendRedirect("mainpage.html");
					}
					else {
						resp.setContentType("text/html");
						PrintWriter pw=resp.getWriter();
						pw.print("incorrect email and password...");
						RequestDispatcher rd=req.getRequestDispatcher("Signin.html");
						rd.include(req, resp);
					}
				}
			    }
			catch (SQLException e) {
				e.printStackTrace();
			}
	        catch (ClassNotFoundException e) {
				e.printStackTrace();
			
		}
			

	}
	}



