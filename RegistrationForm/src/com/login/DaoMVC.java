package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public static int registerUser(String userName, String password, String firstName, String lastName, String email,
											String country,	String sques, String ans, String mobile) 	{
		String sql2 = "SELECT MAX(ID) AS MAX_ID FROM LOGIN";
		int id = 0;
		try(Connection con = connect();
				Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql2)) {
			if(rs.next())	
			{
				id = rs.getInt("MAX_ID");
			}
			id++;
		}
		catch(SQLException ex)	{ ex.printStackTrace(); }
		int status = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO LOGIN ");
		sql.append("VALUES(");
		sql.append(id+", ");
		sql.append("'"+userName+"',");
		sql.append("'"+password+"', ");
		sql.append("'"+firstName+"', ");
		sql.append("'"+lastName+"', ");
		sql.append("'"+email+"', ");
		sql.append("'"+country+"', ");
		sql.append("'"+sques+"', ");
		sql.append("'"+ans+"', ");
		sql.append("'"+mobile+"')");
	
		try(Connection con = connect();
				Statement stmt = con.createStatement()) {
			status = stmt.executeUpdate(sql.toString());//executeUpdate required sql
	}
	catch(SQLException ex) { ex.printStackTrace();	}
	return status;
	}
	
	public static int update(ModelMVC m)
	{
		int status=0;
		try
		{
			Connection con=connect();
			PreparedStatement ps=con.prepareStatement("update login set firstName=?, lastName=?, email=?, country=?, mobile=? where id=?");
			ps.setString(1, m.getFirstName());
			ps.setString(2, m.getLastName());
			ps.setString(3, m.getEmail());
			ps.setString(4,  m.getCountry());
			ps.setString(5, m.getMobile());
			ps.setInt(6, m.getId());
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex){ex.printStackTrace();}
		return status;
	}
	public static ModelMVC getUserById(int id)
	{
		ModelMVC m=new ModelMVC();
		try{
			Connection con=DaoMVC.connect();
			PreparedStatement ps=con.prepareStatement("select id, firstName, lastName, email, country, mobile from login where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				m.setId(rs.getInt(1));
				m.setFirstName(rs.getString(2));
				m.setLastName(rs.getString(3));
				m.setEmail(rs.getString(4));
				m.setCountry(rs.getString(5));
				m.setMobile(rs.getString(6));
			}
			con.close();
		}
		catch(Exception ex){ex.printStackTrace();}
		return m;
	}
	
	public static List<ModelMVC> getAllUser()
	{
		List<ModelMVC> list=new ArrayList<ModelMVC>();
		try
		{
			Connection con=DaoMVC.connect();
			PreparedStatement ps=con.prepareStatement("select id, firstName, lastName, email, country, mobile from login");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ModelMVC m=new ModelMVC();
				m.setId(rs.getInt(1));
				m.setFirstName(rs.getString(2));
				m.setLastName(rs.getString(3));
				m.setEmail(rs.getString(4));
				m.setCountry(rs.getString(5));
				m.setMobile(rs.getString(6));
				list.add(m);
			}
			con.close();
		}
		catch(Exception e){e.printStackTrace();}
		return list;
	}
	
	public static int delete(int id)
	{
		int status=0;
		try
		{
			Connection con=connect();
			PreparedStatement ps=con.prepareStatement("delete from login where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){e.printStackTrace();}
		return status;
	}
}