package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Patient {
	
	private Connection connect()
	{
			Connection con = null;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helthcare","root","root");
				
			} catch (ClassNotFoundException e) {
				
				 e.printStackTrace();
				 
			}catch (SQLException e) {	
				
				 e.printStackTrace();
			}
			
		return con;
	}
	
	public String addPatient(String f_name, String l_name, String address, String dob, String phoneNo, String gender, String BloodGroup, String NIC)
	{
			String output = "";
			
			try
			{
				Connection con = connect();
	 
				if (con == null)
				{return "Error while connecting to the database for inserting."; }
	
				// create a prepared statement
				String sql = "INSERT INTO patient(f_name, l_name, address, dob, phoneNo, gender, BloodGroup, NIC) "+ "VALUE(?,?,?,?,?,?,?,?)";
	 
				PreparedStatement preparedStmt = con.prepareStatement(sql);
	 
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, f_name);
				preparedStmt.setString(3, l_name);
				preparedStmt.setString(4, address);
				preparedStmt.setString(5, dob);
				preparedStmt.setInt(6, Integer.parseInt(phoneNo)); 
				preparedStmt.setString(7, gender);
				preparedStmt.setString(8, BloodGroup);
				preparedStmt.setString(9, NIC);
				
				preparedStmt.execute();
				con.close();
				
				String newPatient = ViewPatient(); 
				output = "{\"status\":\"success\", \"data\": \"" +newPatient + "\"}"; 
			}
			 catch (Exception e)
			 {
				 	output = "{\"status\":\"error\", \"data\":\"Error while inserting the Patient.\"}";
				 	System.err.println(e.getMessage());
			 }
			
			 return output;
			 
		}
			
	public String ViewPatient()

	{
	 String output = "";
	 
	 try
	 {
		 Connection con = connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database for reading.";
		 }
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>First Name</th><th>Last Name</th><th>Address</th><th>date of birth</th><th>contact</th><th>Gender</th><th>Blood Group</th><th>NIC</th><th>Update</th><th>Remove</th></tr>";
		 
		 String sql = "select * from patient";
		 Statement stmt = con.createStatement();
	     ResultSet rs = stmt.executeQuery(sql);
	 
	    // iterate through the rows in the result set
	    while (rs.next())
	    {
	    	String id = Integer.toString(rs.getInt("id"));
	    	String f_name = rs.getString("f_name");
	    	String l_name = rs.getString("l_name");
	    	String address = rs.getString("address");
	    	String dob = rs.getString("dob");
	    	String phoneNo = Integer.toString(rs.getInt("phoneNo"));
	    	String gender = rs.getString("gender");
	    	String BloodGroup = rs.getString("BloodGroup");
	    	String NIC = rs.getString("NIC");
	    	
	    	// Add into the html table
	    	output += "<tr><td><input id='hidPatientIDUpdate' name='hidPatientIDUpdate' type='hidden' value='" + id + "'>"+ f_name + "</td>";
	    	output += "<td>" + l_name + "</td>";
	    	output += "<td>" + address + "</td>";
	    	output += "<td>" + dob + "</td>";
	    	output += "<td>" + phoneNo + "</td>";
	    	output += "<td>" + gender + "</td>";
	    	output += "<td>" + BloodGroup + "</td>";
	    	output += "<td>" + NIC + "</td>";
	
	    	// buttons
	    	output +=  "<td><input name='btnUpdate' type='button'value='Update'class='btnUpdate btn btn-secondary'></td>"+"<td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-id='"+ id + "'>" + "</td></tr>"; 
	    			
	    }
	    
	    con.close();
	    // Complete the html table
	    output += "</table>";
	 }
	 catch (Exception e)
	 {
		 output = "Error while reading the Patient.";
		 System.err.println(e.getMessage());
	 }
	return output; 
	}

	public String UpdatePatient(String id,String f_name, String l_name, String address, String dob, String phoneNo, String gender, String BloodGroup, String NIC)
	 {
					String output = "";
			
					try
					{
							Connection con = connect();
			 
							if (con == null)
							{return "Error while connecting to the database for updating."; }
			
							// create a prepared statement
							String sql = "UPDATE  patient SET " + "f_name = ?," + "l_name = ?,"+ "address = ?," + "dob = ?,"+ "phoneNo = ?," + "gender = ?," + "BloodGroup = ?," + "NIC = ?" + "WHERE id = ?";
			
							PreparedStatement preparedStmt = con.prepareStatement(sql);
			 
							// binding values
							preparedStmt.setString(1, f_name);
							preparedStmt.setString(2, l_name);
							preparedStmt.setString(3, address);
							preparedStmt.setString(4, dob);
							preparedStmt.setInt(5, Integer.parseInt (phoneNo)); 
							preparedStmt.setString(6, gender);
							preparedStmt.setString(7, BloodGroup);
							preparedStmt.setString(8, NIC);
							preparedStmt.setInt(9, Integer.parseInt(id));
			 
							// execute the statement
							preparedStmt.execute();
							con.close();
							
							String newPatient = ViewPatient();
							output =  "{\"status\":\"success\", \"data\": \"" +newPatient + "\"}"; 
			 }
			 catch (Exception e)
			 {
				 		output = "{\"status\":\"error\", \"data\":\"Error while updating the Patient.\"}";
				 		System.err.println(e.getMessage());
			 }
					
			 return output;
}

	public String deletePatient(String id)
	{
			String output = "";
	 
			try
			{
					Connection con = connect();
	 
					if (con == null)
					{return "Error while connecting to the database for deleting."; }
	 
					// create a prepared statement
					String sql = "delete from Patient where id=?";
	
					PreparedStatement preparedStmt = con.prepareStatement(sql);
	
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(id));
	 
					// execute the statement
					preparedStmt.execute();
					con.close();
	 
					String newPatient = ViewPatient();
					output =  "{\"status\":\"success\", \"data\": \"" +newPatient + "\"}"; 
	 }
	 catch (Exception e)
	 {
		 		output =  "{\"status\":\"error\", \"data\":\"Error while deleting the Patient.\"}";
		 		System.err.println(e.getMessage());
	 }
	 return output;
	 } 
}
