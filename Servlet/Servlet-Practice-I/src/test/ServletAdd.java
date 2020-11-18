package test;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/result")
public class ServletAdd extends HttpServlet {
	 public void init()
	 {
	  
	 }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Integer i = Integer.parseInt(req.getParameter("num1"));
			Integer j = Integer.parseInt(req.getParameter("num2"));
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			pw.print("<h1>You resulting sum is:<h1><h3>" + (i + j) + "</h3>");
		} catch(Exception e) {
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			pw.print("Your input was incorrect");
		}
	}

	 public void destroy()
	 {
	  
	 }

}
