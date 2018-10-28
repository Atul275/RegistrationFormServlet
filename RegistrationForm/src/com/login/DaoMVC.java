package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoMVC 
{
	public static Connection connect() 
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return con;
	}
	public static int registerUser(ModelMVC m, String sql)
	{
		int i=0;
		Connection con=connect();
		try
		{
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getFirstName());
			pstmt.setString(4, m.getLastName());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getSques());
			pstmt.setString(7, m.getAns());
			pstmt.setString(8, m.getMobile());
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	}
}