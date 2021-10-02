package com.crm.autodesk.GenericUtils;
/* this class contains generic method to read the data from database 
@author Shubham
* 
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con = null;
	Driver driverRef;
	
	public void connectToDB() throws Throwable {
		DriverManager.registerDriver(driverRef);
		
		DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		}
	/*
	 * DB connection is closed
	 * @throw throwable
	 * 
	 * 
	 * 
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
	
	public String getDataFromDB(String query, int columnindex) throws Throwable {
		String value = null;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			value = result.getString(columnindex);
		}
		return value;
		
	}
}
