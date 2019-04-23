function add_employee()
	{
		var e_name = $("#emp_name").val().replace(/^\s*|\s*$/g,"");
		var e_fname = $("#emp_fname").val().replace(/^\s*|\s*$/g,"");
		var e_date = $("#emp_dob").val().replace(/^\s*|\s*$/g,"");
		var e_desig = $("#emp_desig").val().replace(/^\s*|\s*$/g,"");
		var e_addsig = $("#emp_addesig").val().replace(/^\s*|\s*$/g,"");
		var e_email = $("#emp_email").val().replace(/^\s*|\s*$/g,"");
		var e_cont = $("#emp_cont").val().replace(/^\s*|\s*$/g,"");
		var e_status = $("#emp_status").val().replace(/^\s*|\s*$/g,"");
		var jemp_img =$("#emp_img").val().replace(/^\s*|\s*$/g,"");
		var Error_Flag="";
		var Success_flag="";
		(jScript_valid.BoxValid(e_name,'err_ename','Enter Employee Name'))==1? Error_Flag=1:Success_flag=1;
		(jScript_valid.BoxValid(e_fname,'err_efname','Enter Employee Father Nmae'))==1? Error_Flag=1:Success_flag=1;
		(jScript_valid.BoxValid(e_date,'err_edob','Enter Employee Date'))==1? Error_Flag=1:Success_flag=1;
		(jScript_valid.BoxValid(e_desig,'err_edesig','Enter Employee Designation'))==1? Error_Flag=1:Success_flag=1;
		(jScript_valid.BoxValid(e_addsig,'err_eadesig','Enter Employee additional Designation'))==1? Error_Flag=1:Success_flag=1;
		(jScript_valid.BoxValid(e_email,'err_eemail','Enter Employee Email'))==1? Error_Flag=1:Success_flag=1;
		(jScript_valid.BoxValid(e_cont,'err_econt','Enter Employee Contact Number'))==1? Error_Flag=1:Success_flag=1;
		(jScript_valid.dropdownBox(e_status,'err_status','Select Employee Status Type'))==1? Error_flag=1:Success_flag=1;
		if(Error_Flag!=1){
			
			$.ajaxFileUpload({ 
				type : "POST",
				dataType: "json",
			    url  : "addEmployee",
				secureuri:false,
				fileElementId:'emp_img',
				//data : "empName="+e_name+"&empFname="+e_fname+"&empDob="+e_date+"&empDesig="+e_desig+"&empAdddesig="+e_addsig+"&empEmail="+e_email+"&empContact="+e_cont+"&empStatus="+e_status+"&a_empImg="+jemp_img,
				data:{a_empImg:jemp_img,empName:e_name,empFname:e_fname,empDob:e_date,empDesig:e_desig,empAdddesig:e_addsig,empEmail:e_email,empContact:e_cont,empStatus:e_status},
				success: function (json)
					{
						if(json.status=="OK"){
							alert("Employee Data Saved Successfully!");
						   dis_controller("employee");
					}
					else{
						alert("Employee Detail Not Saved!")
					}
			},
				error : function(e) {
				alert('Error: ' + e);
			}
				
				
		});
			
	}
		
	}

//--------------------------------- Edit Employee  Page---------------------------------//
function edit_employee(str)
{
	$.ajax({
		type : "POST",
		url : "editEmployeePage",
		data :{aemp_id:str} ,
		success : function(response) {
		
			$("#page-wrapper").html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	}

// ------------------------------- Edit Employee Details ---------------------------------//
function edit_empdetail()
{
	var e_name = $("#emp_name").val().replace(/^\s*|\s*$/g,"");
	var e_fname = $("#emp_fname").val().replace(/^\s*|\s*$/g,"");
	var e_date = $("#emp_dob").val().replace(/^\s*|\s*$/g,"");
	var e_desig = $("#emp_desig").val().replace(/^\s*|\s*$/g,"");
	var e_addsig = $("#emp_addesig").val().replace(/^\s*|\s*$/g,"");
	var e_email = $("#emp_email").val().replace(/^\s*|\s*$/g,"");
	var e_cont = $("#emp_cont").val().replace(/^\s*|\s*$/g,"");
	var e_status = $("#emp_status").val().replace(/^\s*|\s*$/g,"");
	var e_empId=$("#hid_eid").val().replace(/^\s*|\s*$/g,"");
	var jemp_img =$("#emp_img").val().replace(/^\s*|\s*$/g,"");
	var jemp_hidphoto =$("#hid_photval").val().replace(/^\s*|\s*$/g,"");
	var Error_Flag="";
	var Success_flag="";
	(jScript_valid.BoxValid(e_name,'err_ename','Enter Employee Name'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(e_fname,'err_efname','Enter Employee Father Nmae'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(e_date,'err_edob','Enter Employee Date'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(e_desig,'err_edesig','Enter Employee Designation'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(e_addsig,'err_eadesig','Enter Employee additional Designation'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(e_email,'err_eemail','Enter Employee Email'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(e_cont,'err_econt','Enter Employee Contact Number'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.dropdownBox(e_status,'err_status','Select Employee Status Type'))==1? Error_flag=1:Success_flag=1;
	if(Error_Flag!=1){
		
		$.ajaxFileUpload({ 
			type : "POST",
			dataType: "json",
		    url  : "editEmployee",
			secureuri:false,
			fileElementId:'emp_img',
			//data : "empName="+e_name+"&empFname="+e_fname+"&empDob="+e_date+"&empDesig="+e_desig+"&empAdddesig="+e_addsig+"&empEmail="+e_email+"&empContact="+e_cont+"&empStatus="+e_status+"&a_empImg="+jemp_img,
			data:{a_empImg:jemp_img,empName:e_name,empFname:e_fname,empDob:e_date,empDesig:e_desig,empAdddesig:e_addsig,empEmail:e_email,empContact:e_cont,empStatus:e_status,emphidphoto:jemp_hidphoto,empId:e_empId},
			success: function (json)
				{
					if(json.status=="OK"){
						alert("Employee Data Edited Successfully!");
					   dis_controller("employee");
				}
				else{
					alert("Employee Detail Not Saved!")
				}
		},
			error : function(e) {
			alert('Error: ' + e);
		}
			
			
	});
							
	}
	}

//---------------------------Delete the Employee Detail ----------------------------//
function del_employee(str)
{

	  	
	$.ajax({
	type : "POST",
	url : "deleteEmployee",
	data : {aEmpid:str} ,
	success : function(response) {
		if(response > 0){
			alert("Deleted !");
			dis_controller("employee");
		}
	
	},
	error : function(e) {
		alert('Error: ' + e);
	}
});
	    

}	

//---------------------------Preview of Employee Photo ----------------------//
function dispreview_images()
{
	  reader.onload = function (e) {
	        // get loaded data and render thumbnail.
	        document.getElementById("em_img").src = e.target.result;
	    };

	    // read the image file as a data URL.
	    reader.readAsDataURL(this.files[0]);
	
	}

//-----------------------Pagination ---------------------//

function disEmp_page(str1)
{
	//alert("Start:"+str1+"\n"+"End :"+str2);
	$.ajax({
		type : "POST",
		url : "employee_pagination",
		data : {astart:str1} ,
		success : function(response) {
			
			$("#page-wrapper").html(response);
		
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	}



	

