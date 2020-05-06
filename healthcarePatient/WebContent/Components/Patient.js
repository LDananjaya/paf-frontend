$(document).ready(function()
	{
		
		$("#alertSuccess").hide();     
		$("#alertError").hide();  
		
	});

//save----------
$(document).on("click", "#btnSave", function(event)
	{
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();
	
		var status = validatePatientForm();
		
		//if not valid
		if (status != true)
		{
			$("#alertError").text(status);
			$("#alertError").show();
			return;
		}
	
		//if valid
		var type = ($("#hidPatientIDSave").val() == "") ? "POST" : "PUT";
		
		$.ajax(
				{
				 url : "PatientAPI",
				 type : type,
				 data : $("#formPatient").serialize(),
				 dataType : "text",
				 complete : function(response, status)
				 {
					 onPatientSaveComplete(response.responseText, status);
				 }
			});
	
	});


function onPatientSaveComplete(response, status)
{
		if (status == "success")
		{
				var resultSet = JSON.parse(response);
				
				if (resultSet.status.trim() == "success")
				{
					$("#alertSuccess").text("Successfully saved.");
					$("#alertSuccess").show();
					$("#divPatientGrid").html(resultSet.data);
 
				} else if (resultSet.status.trim() == "error")
				{
					$("#alertError").text(resultSet.data);
					$("#alertError").show();
				}
				
		} else if (status == "error"){
			
				$("#alertError").text("Error while saving.");
				$("#alertError").show();
			
		} else{
		
			$("#alertError").text("Unknown error while saving..");
			$("#alertError").show();
			}
				
			$("#hidPatientIDSave").val("");
			$("#formPatient")[0].reset();
}

function validatePatientForm()
{
	if ($("#f_Name").val().trim() == ""){
		return "Insert first Name.";	
	}
	
	// l_name
	if ($("#l_name").val().trim() == ""){
		return "Insert last Name.";	
	}
	
	// address-------------------------------
	if ($("#address").val().trim() == ""){
		return "Insert Address.";
		
	}
	
	// date of birth------------------------
	if ($("#dob").val().trim() == ""){
		
		return "Insert date of birth.";
	}
	
	// phoneNo-------------------------------
	if ($("#phoneNo").val().trim() == ""){
		return "Insert phoneNo.";
		
	}

	// gender-------------------------------
	if ($("#gender").val().trim() == ""){
		return "Insert gender.";
		
	}
	
	// BloodGroup-------------------------------
	if ($("#BloodGroup").val().trim() == ""){
		return "Insert Blood Group.";
		
	}
	
	// NIC-------------------------------
	if ($("#NIC").val().trim() == ""){
		return "Insert NIC.";
		
	}
	
	return true;
}

$(document).on("click", ".btnUpdate", function(event)
		{
			$("#hidPatientIDSave").val($(this).closest("tr").find('#hidPatientIDUpdate').val());
			$("#f_Name").val($(this).closest("tr").find('td:eq(0)').text());
			$("#l_name").val($(this).closest("tr").find('td:eq(1)').text());
			$("#address").val($(this).closest("tr").find('td:eq(2)').text());
			$("#dob").val($(this).closest("tr").find('td:eq(3)').text()); 
			$("#phoneNo").val($(this).closest("tr").find('td:eq(4)').text()); 
			$("#gender").val($(this).closest("tr").find('td:eq(5)').text()); 
			$("#BloodGroup").val($(this).closest("tr").find('td:eq(6)').text()); 
			$("#NIC").val($(this).closest("tr").find('td:eq(7)').text()); 
		});



$(document).on("click", ".btnRemove", function(event)
		{
		 $.ajax(
				 {
					 url : "PatientAPI",
					 type : "DELETE",
					 data : "id=" + $(this).data("id"),
					 dataType : "text",
					 complete : function(response, status)
					 {
						 onPatientDeleteComplete(response.responseText, status);
					 }
				 });
		});
function onPatientDeleteComplete(response, status)
{
		if (status == "success")
		{
			var resultSet = JSON.parse(response);
			
			if (resultSet.status.trim() == "success")
			{
				$("#alertSuccess").text("Successfully deleted.");
				$("#alertSuccess").show();
				$("#divPatientGrid").html(resultSet.data);
				
			} else if (resultSet.status.trim() == "error")
			{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
			}
		} else if (status == "error")
		{
			$("#alertError").text("Error while deleting.");
			$("#alertError").show();
		} else
		{
			$("#alertError").text("Unknown error while deleting..");
			$("#alertError").show();
		}
}




