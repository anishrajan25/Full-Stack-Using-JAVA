package accounts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBUtil;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("signup servlet\n");
		
		Connection con = DBUtil.getDBConnection();
		
		PreparedStatement ps;
		try {
			String mail = req.getParameter("email");
			String name = req.getParameter("userName");
			String gender = req.getParameter("gender");
			Integer age = Integer.parseInt(req.getParameter("age"));
			String job = req.getParameter("job");
			Double salary = Double.parseDouble(req.getParameter("salary"));
			String pass = req.getParameter("userPass");
			System.out.println(mail + name + gender + age  +job + salary + pass);
			ps = con.prepareStatement("insert into userinfo values(?,?,?,?,?,?)");
			ps.setString(1, mail);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setInt(4, age);
			ps.setString(5, job);
			ps.setDouble(6, salary);
			ps.executeUpdate();
			
			ps = con.prepareStatement("insert into logininfo values(?,?)");
			ps.setString(1, mail);
			ps.setString(2, pass);
			ps.executeUpdate();
			
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			pw.print("Sign Up Successfull! Please Login");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			pw.print("Please check your details and try again...<br/>");
			RequestDispatcher rd = req.getRequestDispatcher("signUp.html");
			rd.include(req, res);
		}
	}
}
