package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public Login()
    {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	RequestDispatcher rd=null;
    	PrintWriter out=response.getWriter();
    	response.setContentType("text/html;charset=UTF-8");
		try
		{
			String userName=request.getParameter("username");
			String password=request.getParameter("pw");			
			try
			{
				if(userName!=null)
				{
					Connection con=DaoMVC.connect();
					String sql="select * from login where username=? AND password=?";
					PreparedStatement pstm=con.prepareStatement(sql);
					pstm.setString(1, userName);
					pstm.setString(2, password);
					ResultSet rs=pstm.executeQuery();
					if(rs.next())
					{
						HttpSession session=request.getSession();
						session.setAttribute("username", userName);
						response.sendRedirect("homepage.html");
						rd.forward(request, response);
						out.println("You are successfully login");
					}
					else
					{
						rd=request.getRequestDispatcher("errorPage.jsp");
						rd.include(request, response);
					}
				}
			}
			catch(Exception ex)
			{
				out.println("Exception: "+ex.getMessage());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}