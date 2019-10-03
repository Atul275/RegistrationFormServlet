package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update User</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		ModelMVC m = DaoMVC.getUserById(id);
		out.print("<form action='UpdateServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+m.getId()+"'/></td></tr>");
		out.print("<tr><td>First Name:</td><td><input type='text' name='firstName' value='"+m.getFirstName()+"'/></td></tr>");
		out.print("<tr><td>Last Name:</td><td><input type='text' name='lastName' value='"+m.getLastName()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+m.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Country:</td><td><input type='text' name='country' value='"+m.getCountry()+"'/></td></tr>");
		out.print("<tr><td>Mobile:</td><td><input type='text' name='mobile' value='"+m.getMobile()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
	}
}