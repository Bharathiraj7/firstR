function butt_file()
{
	var jemp_img=$("#emp_img").val().replace(/^\s*|\s*$/g,"");
	
	$.ajaxFileUpload({ 
		type : "POST",
		url  : "filemove",
		secureuri:false,
		fileElementId:'emp_img',
		data:{a_empImg:jemp_img},
		success: function (data)
			{
				
			
			
				}
		
});
	
	
	
	
	
	
	}