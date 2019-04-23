function edit_share(str)
	{
	$.ajax({
		type : "POST",
		url  : "changefieldshrholder",
		data : "ashId="+str,
		success : function(response) {
			// we have the response
		$("#page-wrapper").html(response);
//			start(1);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	
	}

function sharemem_edit()
{
	var u_name = $("#uname").val().replace(/^\s*|\s*$/g,"");
	var u_fname = $("#fname").val().replace(/^\s*|\s*$/g,"");
	var u_age = $("#age").val().replace(/^\s*|\s*$/g,"");
	var u_occup = $("#occup").val().replace(/^\s*|\s*$/g,"");
	var u_cnum = $("#cnnum").val().replace(/^\s*|\s*$/g,"");
	var u_shrid = $("#hid_shrId").val().replace(/^\s*|\s*$/g,"");
	var Error_Flag="";
	var Success_flag="";
	(jScript_valid.BoxValid(u_name,'euname','Enter User Name'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(u_fname,'efname','Enter User Father Nmae'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(u_age,'eage','Enter User Age'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(u_occup,'eoccup','Enter User Occupation'))==1? Error_Flag=1:Success_flag=1;
	(jScript_valid.BoxValid(u_cnum,'ecnum','Enter Contact Number'))==1? Error_Flag=1:Success_flag=1;
	if(Error_Flag!=1){
		
		$.ajax({
			type : "POST",
			url  : "editshareholder",
			data : "auser="+u_name+"&afname="+u_fname+"&aage="+u_age+"&aoccup="+u_occup+"&acont="+u_cnum+"&asId="+u_shrid,
			success : function(response) {
				// we have the response
//				$("#page-wrapper").html(response);
//				start(1);
				if(response!=0)
					{
						alert("Successfully Edited!");
						$.ajax({url:"viewshareholder",success:function(retvalue){
							//alert(retvalue);
							$("#page-wrapper").html(retvalue);}});
					}
							
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
		
	}
}

function del_share(str)
{
	$.ajax({
		type : "POST",
		url  : "deleteShareMem",
		data : "ashdelId="+str,
		success : function(response) {
			// we have the response
			if(response!=0)
			{
				alert("Successfully Deleted!");
				$.ajax({url:"viewshareholder",success:function(retvalue){
					//alert(retvalue);
					$("#page-wrapper").html(retvalue);}});
			}
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}