package accounts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String mail = req.getParameter("email");
		String pass = req.getParameter("userPass");
		
		Connection con = DBUtil.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select password from logininfo where email=?");
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && rs.getString(1).equals(pass)) {
				RequestDispatcher rd = req.getRequestDispatcher("welcome");
				rd.forward(req, res);
			}
			else throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("Sorry username or password error!");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		
	}
}
