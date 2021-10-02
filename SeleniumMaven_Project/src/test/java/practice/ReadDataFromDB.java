package practice;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class ReadDataFromDB {
	// For Non-Select Query

		public static void main(String[] args) throws Throwable {
			
			// Step 1 : register/ load the mySQL DB
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			// step 2 : get connect to DB
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
			
			// step 3 : Creat sql statement
			java.sql.Statement stat =   con.createStatement();
			String query = "insert into students_info (regno, firstname, middlename, lastname) values('10', 'bujji','ajay', 'AP')";
			//String query1 = "insert into students_info (regno, firstname, middlename, lastname) values('8', 'bujji','ajay', 'AP')";
			
			// Step 4 : excute statement/query
			int result = stat.executeUpdate(query);
			if(result==1)
			{
				System.out.println("user is created");
			}else {
				System.out.println("user is not created");
			}
			// step 5 : close the connection
				con.close();
			
			

	}
	}


