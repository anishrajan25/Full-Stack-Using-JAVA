package accounts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBUtil;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String mail = req.getParameter("email");
		
		Connection con = DBUtil.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from userinfo where email=?");
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			if(!rs.next()) throw new Exception();
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String job = rs.getString("job");
			Integer age = rs.getInt("age");
			Double salary = rs.getDouble("salary");
			
			pw.print("<h1>Welcome " + name + "</h1><h3>Gender - " + gender + "</h3><h3>Age - " + age +
					"</h3><h3>Job - " + job + "</h3><h3>Salary - " + salary + "</h3>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.print("Unknown Error Occured");
		}
		
	}
}
