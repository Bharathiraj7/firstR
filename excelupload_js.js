function exelfile_upload()
{
	var jexcel_file=$("#ex_file").val().replace(/^\s*|\s*$/g,"");
	
	$.ajaxFileUpload({ 
		type : "POST",
		url  : "excel_cntrl",
		secureuri:false,
		fileElementId:'ex_file',
		data:{a_excel:jexcel_file},
		success: function (data)
			{
				
				
			
				}
		
});
}

//---------------------------Download Employee Details in Excell---------------------------//
function download_employee()
{
	$.ajax({ 
		type : "POST",
		dataType: "json",
	    url  : "excel_employee",
		data:{aexcel_emp:"OK"},
		success: function (json)
			{
				if(json.status=="OK"){
					alert("Excel File is Ready");
					 window.location = "downloading.html?fileName=" + json.file_name;
			}
			else{
				alert("Excel File is Not Created");
			}
	},
		error : function(e) {
		alert('Error: ' + e);
	}
		
		
});
	
	}

