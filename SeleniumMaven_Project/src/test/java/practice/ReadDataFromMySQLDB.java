package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class ReadDataFromMySQLDB {
	// For Select Query
	
	
		public static void main(String[] args) throws Throwable {
			
			// Step 1 : register/ load the mySQL DB
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			// step 2 : get connect to DB
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
			
			// step 3 : Creat sql statement
			java.sql.Statement stat =   con.createStatement();
			String query = "select * from students_info;";
			
			// Step 4 : excute statement/query
			ResultSet result = stat.executeQuery(query);
			
			while(result.next()) {
				
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
				}
			
			// step 5 : close the connection
			con.close();
		}
			

}
