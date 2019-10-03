package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet2 extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String mobile = request.getParameter("mobile");
		ModelMVC m = new ModelMVC();
		m.setId(id);
		m.setFirstName(firstName);
		m.setLastName(lastName);
		m.setEmail(email);
		m.setCountry(country);
		m.setMobile(mobile);
		int status = DaoMVC.update(m);
		if(status>0)
		{
			response.sendRedirect("ViewServlet");
		}
		else
		{
			out.println("Sorry! unable to update record");
		}
		out.close();
	}
}