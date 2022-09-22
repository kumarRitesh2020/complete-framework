package org_salesandinventory_genericutility;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;
public class DataBaseUtility
{
	java.sql.Connection connection;
 public java.sql.Connection  getconnection (String url, String username, String password){
	 Driver dbdriver=null;
try {
	dbdriver  = new Driver();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    try {
		DriverManager.registerDriver(dbdriver);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
   try {
	  connection= DriverManager.getConnection(url,username,password);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  return connection;
 }
public void getDatafromdb(String query,String columnname) 
{
	Statement statement=null;
   try {
	statement = connection.createStatement();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   ResultSet result=null;
		 try {
		result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	List<String> arr = new ArrayList<String>();
	try {
		arr.add(result.getString(columnname));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();		
	}
 }
}

   