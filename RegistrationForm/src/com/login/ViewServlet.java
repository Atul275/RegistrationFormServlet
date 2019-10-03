package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h2><a href='login.jsp'>Go To Home Page</a></h2>");
		out.println("<center><h1>All Users Registration List</h1></center>");
		List<ModelMVC> list=DaoMVC.getAllUser();
		out.print("<center><table border='1' width='75%;'");
		out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Country</th><th>Mobile</th><th colspan=\"2\">Action</th></tr>");
		
		for(ModelMVC m:list)
		{
			out.print("<tr><td>"+m.getId()+"</td><td>"+m.getFirstName()+"</td><td>"+m.getLastName()+"</td><td>"+m.getEmail()+"</td><td>"+m.getCountry()+"</td><td>"+m.getMobile()+"</td><td><a href='UpdateServlet?id="+m.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+m.getId()+"'>Delete</a></td></tr>");
		}
		out.print("</table></center>");
		out.close();
	}
}