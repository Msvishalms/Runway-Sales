package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselectquery {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		//register the database
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);

			//get connection for database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/runwaysales","root","root"); //take url of mysql from website

			//create statement
			Statement state = con.createStatement();
			String query = "insert into products values('p3','door',100000);";

			//update query
			result = state.executeUpdate(query);
		}
		catch (Exception e) {

		}
		finally {
			if(result>0)
			{
				System.out.println("data successfully updated");
			}
			else
			{
				System.err.println("data not inserted");
			}
			con.close();
		}
	}
}
