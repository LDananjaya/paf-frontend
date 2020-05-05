
package com.paf.HospitalManagement.HelthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.paf.HospitalManagement.HelthCare.Bean.PatientBean;
import com.paf.HospitalManagement.HelthCare.Util.HelthCareDB;

public class patientModel {

	HelthCareDB db = new HelthCareDB();
	Connection con = db.getCon();

	public String ViewPatient() {
		
		String a = null;
		
		try {
			String sql = "SELECT * FROM patient";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
	         
					a = "<table>"
	     				+ "<tr>"
	     				+ "<th>id<td>"	     				
	     				+ "<th>l_name<td>"
	     				+ "<th>f_name<td>"
	     				+ "<th>address<td>"
	     				+ "<th>dob<td>"
	     				+ "<th>phoneNo<td>"
	     				+ "<th>gender<td>"
	     				+ "<th>BloodGroup<td>"
	     				+ "<th>NIC<td>"
	     				+ "</tr>";
			
	         while (rs.next()) {
             
	        	   a +=  "<tr>"
	     				+ "<td>"+rs.getInt("id")+"<td>"
	     				+ "<td>"+rs.getString("f_name")+"<td>"
	     				+ "<td>"+rs.getString("l_name")+"<td>"
	     				+ "<td>"+rs.getString("address")+"<td>"
	     				+ "<td>"+rs.getString("dob")+"<td>"
	     				+ "<td>"+rs.getString("phoneNo")+"<td>"
	     				+ "<td>"+rs.getString("gender")+"<td>"
	     				+ "<td>"+rs.getString("BloodGroup")+"<td>"
	     				+ "<td>"+rs.getString("NIC")+"<td>"	     				 
	     				+ "</tr>";
	     				 
	        	 
	        	 
	         }
	         
	         a += "</table>";
	         
	         
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
              
		
		return a;

	}

	public String addPatient(PatientBean pbean) {

		String e1 = null;

		try {

			System.out.println(pbean.getF_name());

			String sql = "INSERT INTO patient(f_name, l_name, address,dob,phoneNo,gender,BloodGroup,NIC) "
					+ "VALUE(?,?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, pbean.getF_name());
			ps.setString(2, pbean.getL_name());
			ps.setString(3, pbean.getAddress());
			ps.setString(4, pbean.getDob());
			ps.setInt(5, pbean.getPhoneNo());
			ps.setString(6, pbean.getGender());
			ps.setString(7, pbean.getBloodGroup());
			ps.setString(8, pbean.getNIC());

			ps.executeUpdate();

			e1 = "patien details inserted";

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return e1;

	}

	public String UpdatePatient(PatientBean pbean) {

		String e = null;
		
		
		try {
			
			String sql = "UPDATE  patient SET " 
						+ "f_name = ?," 
						+ "l_name = ?,"
						+ "address = ?," 
						+ "dob = ?,"
						+ "phoneNo = ?," 
						+ "gender = ?," 
						+ "BloodGroup = ?," 
						+ "NIC = ?" 
						+ "WHERE id = ?";


			PreparedStatement ps;
			ps = con.prepareStatement(sql);

			ps.setString(1, pbean.getF_name());
			ps.setString(2, pbean.getL_name());
			ps.setString(3, pbean.getAddress());
			ps.setString(4, pbean.getDob());
			ps.setInt(5, pbean.getPhoneNo());
			ps.setString(6, pbean.getGender());
			ps.setString(7, pbean.getBloodGroup());
			ps.setString(8, pbean.getNIC());
			ps.setInt(9, pbean.getId());
			
			System.out.println(ps);
			
			ps.executeUpdate();
			
			e = "patien details Updated";
			
			
		} catch (SQLException e1) {


			e1.printStackTrace();
		}

		

		return e;

	}

	public String DeletePatient(int id) {
		
		String status = null; 	
		
		try {
			String sql = "DELETE  FROM patient  "
						+ "WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeLargeUpdate();
			status = "patient "+id+" deleted ";
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		 
		
		return status;

	}

}
