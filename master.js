function add_country()
{
	var e_cntry = $("#cntry_name").val().replace(/^\s*|\s*$/g,"");
	var Error_Flag="";
	var Success_flag="";
	(jScript_valid.BoxValid(e_cntry,'err_cntryname','Enter Country Name'))==1? Error_Flag=1:Success_flag=1;
	if(Error_Flag!=1){
		
		$.ajax({ 
			type : "POST",
			dataType: "json",
		    url  : "addCountry",
			data:{cntry_name:e_cntry},
			success: function (json)
				{
					if(json.status=="OK"){
						alert("Country Name Saved Successfully!");
						dis_controller('location');
				}
				else{
					alert("Country Name Not Saved!")
				}
		},
			error : function(e) {
			alert('Error: ' + e);
		}
			
			
	});

		}
	}

//----------------------------Add States Function ---------------------//
function add_states()
{
	var e_cntryval = $("#cnt_val").val().replace(/^\s*|\s*$/g,"");
	var e_states = $("#states_name").val().replace(/^\s*|\s*$/g,"");
	var Error_Flag="";
	var Success_flag="";
	(jScript_valid.dropdownBox(e_cntryval,'err_slctcntr','Select Country'))==1? Error_flag=1:Success_flag=1;
	(jScript_valid.BoxValid(e_states,'err_statname','Enter States Name'))==1? Error_Flag=1:Success_flag=1;
	if(Error_Flag!=1){
		
		$.ajax({ 
			type : "POST",
			dataType: "json",
		    url  : "addStates",
			data:{a_slcntry:e_cntryval,a_state:e_states},
			success: function (json)
				{
					if(json.status=="OK"){
						alert("States Name Saved Successfully!");
						dis_controller('location');
				}
				else{
					alert("States Name Not Saved!");
				}
		},
			error : function(e) {
			alert('Error: ' + e);
		}
			
			
	});

		}
	
	}

//-----------------------------Display the States -----------------------//
function dis_state(str)
{
	$.ajax({ 
		type : "POST",
		dataType: "json",
	    url  : "getStatelists",
		data:{a_cntry:str},
		success: function (json)
			{
				//alert(json.length);
				var options = "<option value='0'>Select States</option>";
				for (var i = 0; i < json.length; i++) {
					options+= '<option value="' + json[i]['state_id'] + '">' + json[i]['status'] + '</option>';
				}
				$("#place_state").html(options);
		},
		error : function(e) {
		alert('Error: ' + e);
	}
		
		
});
}

//----------------------------Add location / Place / City --------------------------------//
function add_place()
{
	var jp_cntry = $("#place_country").val().replace(/^\s*|\s*$/g,"");
	var jp_stat = $("#place_state").val().replace(/^\s*|\s*$/g,"");
	var jp_plname = $("#place_name").val().replace(/^\s*|\s*$/g,"");
	var Error_Flag="";
	var Success_flag="";
	(jScript_valid.dropdownBox(jp_cntry,'err_placecnty','Select Country'))==1? Error_flag=1:Success_flag=1;
	(jScript_valid.dropdownBox(jp_stat,'err_placestate','Select States'))==1? Error_flag=1:Success_flag=1;
	(jScript_valid.BoxValid(jp_plname,'err_placename','Enter Place / City  /Town Name'))==1? Error_Flag=1:Success_flag=1;
	if(Error_Flag!=1){
		
		$.ajax({ 
			type : "POST",
			dataType: "json",
		    url  : "addPlace",
			data:{ap_cntry:jp_cntry,ap_state:jp_stat,ap_place:jp_plname},
			success: function (json)
				{
					if(json.status=="OK"){
						alert("Place  Name Saved Successfully!");
						dis_controller('location');
				}
				else{
					alert("Place  Name Not Saved!");
				}
		},
			error : function(e) {
			alert('Error: ' + e);
		}
			
			
	});

		}
	
	
	}

//--------------------------------Display the Place Details--------------------------------//
function dis_placelist(str)
{
	$.ajax({ 
		type : "POST",
		dataType: "json",
	    url  : "getPlaceLists",
		data:{a_state:str},
		success: function (json)
			{
			str="<table width='98%' border='0' style='border-collapse:collapse; background:#dfe9f3; border-collapse:collapse; font-size:13px; margin-top:15px; font-family:Arial;' align='center'  id='stu_info'>";
			str=str+"<tr style='background:#5b758c; height:30px;'>";
			str=str+"<td colspan='6' style='background:#5b758c; color:#fff; font-weight:bold; padding-left:10px; font-family:Arial;'>Place Name </td>";
			str=str+"</tr>";
			str=str+"<tr><th>No</th><th>Country</th><th>State</th><th>Place</th><th>Edit</th><th>Delete</th></tr>";
			var j=1;
			for(i=0;i<json.length;i++){ 
				str=str+"<tr>";
				str=str+"<td>"+j+"</td>";
				str=str+"<td>"+json[i]['country']+"</td>";
				str=str+"<td>"+json[i]['state']+"</td>";
				str=str+"<td>"+json[i]['place_name']+"</td>";
				str=str+"<td>"+"<img style='padding-left:10px;cursor:pointer' src='resources/images/edit_blue.png' onclick='md_loanMember("+json[i]['place']+");' >"+"</td>";
				str=str+"<td>"+"<img style='padding-left:10px;cursor:pointer' src='resources/images/round_delete.png' onclick='md_loanMember("+json[i]['place']+");' >"+"</td>";
				str=str+"</tr>";
				j+=1;
			}
			str=str+"</table>";
			$('#dis_placedetail').html(str);
		},
		error : function(e) {
		alert('Error: ' + e);
	}
		
		
});
	}