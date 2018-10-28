package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public Registration() 
    {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{//1.retrieve all parameters from JSP page
		String userName=request.getParameter("username");
		String password=request.getParameter("pw");
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String email=request.getParameter("email");
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
		m.setSques(sques);
		m.setAns(ans);
		m.setMobile(mobile);
		//3.call a method in Dao class to insert data in table
		String sql="insert into login values(?,?,?,?,?,?,?,?)";
		int i=DaoMVC.registerUser(m,sql);
		response.sendRedirect("register.jsp");		
	}
}