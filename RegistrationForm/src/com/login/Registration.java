package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet
{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{//1.retrieve all parameters from JSP page
	   PrintWriter out = response.getWriter();
		String userName=request.getParameter("username");
		String password=request.getParameter("pw");
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String email=request.getParameter("email");
		String country = request.getParameter("country");
		String sques=request.getParameter("sques");
		String ans=request.getParameter("ans");
		String mobile=request.getParameter("mobile");
		
	//2.set all the values in model class
		ModelMVC m=new ModelMVC();
		m.setUserName(userName);
		m.setPassword(password);
		m.setFirstName(firstName);
		m.setLastName(lastName);
		m.setEmail(email);
		m.setCountry(country);
		m.setSques(sques);
		m.setAns(ans);
		m.setMobile(mobile);
		
	//3.call a method in Dao class to insert data in table
		int i=DaoMVC.registerUser(userName, password, firstName, lastName, email, country, sques, ans, mobile);
		if(i >0)
		{
			response.sendRedirect("register.jsp");
		}	
		else
		{
			out.println("Sorry! unable to save record");
		}
	}
}