package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Selectquery {

	public static void main(String[] args) throws SQLException{

		Connection con=null;
		ResultSet result=null;
		try {
			//register to database
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);

			//get connection for database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/runwaysales", "root", "root");

			//create statement
			Statement state = con.createStatement();
			String query = "select* from products;";

			//execute query
			result = state.executeQuery(query);
			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			}
		}
		catch(Exception e)
		{

		}
		//close the database
		finally
		{
			con.close();
		}
	}
}