package org.altairretro.practice;



import java.sql.SQLException;
import java.util.List;

import genericUtility.DataBaseUtility;
import genericUtility.IConstantPath;


public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		DataBaseUtility dataBaseUtility=new DataBaseUtility();
		dataBaseUtility.openDBConnection(IConstantPath.DB_URL,"root","root");
		List<String>data=dataBaseUtility.getDataFromDatabase("select* from altairetro","customer_name");
		System.out.println(data);
		dataBaseUtility.closeDB();
		
		
		
		/*
		 * Driver dbdriver= new Driver(); DriverManager.registerDriver(dbdriver);
		 * Connection connection=
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root")
		 * ; try { Statement statement=connection.createStatement();
		 * 
		 * 
		 * ResultSet result=statement.executeQuery("select * from ALTAIRetro;");
		 * while(result.next()) { System.out.println(result.getString("customer_name"));
		 * }
		 * 
		 * } finally { connection.close();
		 * System.out.println("connection closed successfully");
		 * 
		 * }
		 */
	}

}
