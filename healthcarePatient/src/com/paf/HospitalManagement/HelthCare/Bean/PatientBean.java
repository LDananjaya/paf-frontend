package com.paf.HospitalManagement.HelthCare.Bean;

public class PatientBean {

	int id;
	String f_name;
	String l_name;
	String address;
	String dob;
	int phoneNo;
	String gender;
	String BloodGroup;
	String NIC;
	
	
	
	public PatientBean() {
		 
	}



	public PatientBean(int id, String f_name, String l_name, String address, String dob, int phoneNo, String gender,
			String bloodGroup, String nIC) {
		 
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.address = address;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.gender = gender;
		BloodGroup = bloodGroup;
		NIC = nIC;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getF_name() {
		return f_name;
	}



	public void setF_name(String f_name) {
		this.f_name = f_name;
	}



	public String getL_name() {
		return l_name;
	}



	public void setL_name(String l_name) {
		this.l_name = l_name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public int getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getBloodGroup() {
		return BloodGroup;
	}



	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}



	public String getNIC() {
		return NIC;
	}



	public void setNIC(String nIC) {
		NIC = nIC;
	}
	
	
	
	
}

