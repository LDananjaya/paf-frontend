package com.paf.HospitalManagement.HelthCare.Contraller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paf.HospitalManagement.HelthCare.Bean.PatientBean;
import com.paf.HospitalManagement.HelthCare.Model.patientModel;

 
@Path("/Patient")
public class PatientService {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	public String View_Patient() {
		
		patientModel model = new patientModel();
		String status = model.ViewPatient();
		
		
		
		return status;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Add_Patient(String details) {
		
		JsonObject P_details = new JsonParser().parse(details).getAsJsonObject();
		
		
		String f_name = P_details.get("f_name").getAsString();
		String l_name = P_details.get("l_name").getAsString();
		String address = P_details.get("address").getAsString();
		String dob = P_details.get("dob").getAsString();
		int phoneNo = P_details.get("phoneNo").getAsInt();
		String gender = P_details.get("gender").getAsString();
		String BloodGroup = P_details.get("BloodGroup").getAsString();
		String NIC =  P_details.get("NIC").getAsString();
		
		
		PatientBean patient = new PatientBean();
		patient.setF_name(f_name);
		patient.setL_name(l_name);
		patient.setAddress(address);
		patient.setDob(dob);
		patient.setPhoneNo(phoneNo);
		patient.setGender(gender);
		patient.setBloodGroup(BloodGroup);
		patient.setNIC(NIC);
		
		 
		patientModel model = new patientModel();
		String status = model.addPatient(patient);
		
		
		
		return status;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Update_Patient(String details) {
		
		JsonObject P_details = new JsonParser().parse(details).getAsJsonObject();
		
		int id = P_details.get("id").getAsInt();
		String f_name = P_details.get("f_name").getAsString();
		String l_name = P_details.get("l_name").getAsString();
		String address = P_details.get("address").getAsString();
		String dob = P_details.get("dob").getAsString();
		int phoneNo = P_details.get("phoneNo").getAsInt();
		String gender = P_details.get("gender").getAsString();
		String BloodGroup = P_details.get("BloodGroup").getAsString();
		String NIC =  P_details.get("NIC").getAsString();
		
		
		PatientBean patient = new PatientBean();
		
		patient.setId( id);
		patient.setF_name(f_name);
		patient.setL_name(l_name);
		patient.setAddress(address);
		patient.setDob(dob);
		patient.setPhoneNo(phoneNo);
		patient.setGender(gender);
		patient.setBloodGroup(BloodGroup);
		patient.setNIC(NIC);
		
		 
		patientModel model = new patientModel();
		String status = model.UpdatePatient(patient);
		
		
		
		return status;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String Delete_Patient(String id) {
		
		JsonObject P_details = new JsonParser().parse(id).getAsJsonObject();
		
		int id1 = P_details.get("id").getAsInt();
		
		patientModel model = new patientModel();
		String status = model.DeletePatient(id1);
		
		
		
		return status;
	}

 
}

