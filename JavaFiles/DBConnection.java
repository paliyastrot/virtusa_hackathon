package test;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;


// class used for getting DbConnnection
public class DBConnection {
	private static final String URL="jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME="fest_db";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	private  static PreparedStatement insertUser;
	
	//method
	private static Connection getConnection()
	{
		Connection con=null;
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL+DATABASE_NAME+"?useSSL=false",USERNAME,PASSWORD);
			System.out.println("Hello");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static String insertUser(String email, String name, String college_name, String event_name, String contact_number, int fee, String year, String branch) throws SQLException 
	{
	    try
	    {    
	    		
//	    		System.out.println(event_name);
	    		Random rand = new Random();
	    		Connection connection = getConnection();
	    		insertUser = connection.prepareStatement(
	                "insert into registration_info() values (?,?,?,?,?,?,?,?,?)");
	    		insertUser.setInt(1, rand.nextInt(10000000));
	    		insertUser.setString(2, email);
				 insertUser.setString(3, name);
				 insertUser.setString(4, college_name);
				 insertUser.setString(5 , event_name);
				 insertUser.setString(6, contact_number);
				 insertUser.setInt(7, fee);
				 insertUser.setString(8, year);
				 insertUser.setString(9, branch);
				 
				 int x = insertUser.executeUpdate();
				
//				 System.out.println(x);
				 if(x==1)
				 {
					 return "Done";
				 }
				else 
				{
					return "Error";
				}
		}
	    
	    catch(java.sql.SQLIntegrityConstraintViolationException ex)
	    {
				        ex.printStackTrace();
				        return "Already";
	    }
	}

}
