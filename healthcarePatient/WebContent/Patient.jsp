<%@page import="com.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Care</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Patient.js" ></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
			
				<h1>Patient Management</h1>
						<form id="formPatient" name="formPatient">
			 				
							first name:
							<input id="f_Name" name="f_Name" type="text"
										class="form-control form-control-sm">
							<br> last name:
						    <input id="l_name" name="l_name" type="text"
										class="form-control form-control-sm">
							<br> Address:
						    <input id="address" name="address" type="text"
										class="form-control form-control-sm">
							<br> Date of birth:
						    <input id="dob" name="dob" type="text"
										class="form-control form-control-sm">
							<br> contact:
						    <input id="phoneNo" name="phoneNo" type="text"
										class="form-control form-control-sm">
							<br> Gender:
						    <input id="gender" name="gender" type="text"
										class="form-control form-control-sm">
							<br> Blood Group:
						    <input id="BloodGroup" name="BloodGroup" type="text"
										class="form-control form-control-sm">
							<br> NIC:
						    <input id="NIC" name="NIC" type="text"
										class="form-control form-control-sm">
							<br>
							<input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
							<input type="hidden" id="hidPatientIDSave"name="hidPatientIDSave" value="">
					</form>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>	
				
					<br>
					<div id="divPatientGrid">
					<%
						Patient patientObj = new Patient();
						out.print(patientObj.ViewPatient());
					%>
					</div>
				</div>
			</div>
		</div>				
</body>
</html>