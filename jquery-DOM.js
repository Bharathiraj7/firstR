function Class_Validation(){
//--------------------------------------Email Validation-------------------------------------------------
	this.email = function(str1,str2,str3){
		var Email_Regex = /^[a-z0-9._-]+@[a-z]+.[a-z.]{2,5}$/i;//Example:example@gmail.com
		if(!Email_Regex.test(str1)) {$("#"+str2).html(str3);return 1;}else {$("#"+str2).html("");return 0;}
	}
//---------------------------------------Url validation--------------------------------------------------
	this.url = function(url){
		var url_Regex=/^[http://]+[www]?.[0-9a-z_.]+.[a-z.]{2,5}$/i; //Example:http:www.example.com
		if(!url_Regex.test(url)) {return "<span style='color:#FF0000; font-size:12px;'>Please Enter Valid url</span>";}else {return "";}
	}
//---------------------------------------Pincode validation----------------------------------------------	
	this.pincode = function(pin){
		var pincode_Regex=/^[0-9]{6}$/i; //Example: 600001
		if(!pincode_Regex.test(pin)) {return "<span style='color:#FF0000; font-size:12px;'>Please Enter Valid Pin Code</span>";}else {return "";}
	}
//---------------------------------------Name Validation-------------------------------------------------	
	this.name = function(name){
		var name_Regex=/^[a-zA-Z() ]+$/; //Example: Rahul Dravid
		if(!name_Regex.test(name)) {return "<span style='color:#FF0000; font-size:12px;'>Please enter correct value</span>";}else {return "";}
	}
//---------------------------------------Landline Validation---------------------------------------------	
	this.landline = function(landline){
		var landline_regex = /^[0-9]{0,5}[-][0-9]{0,15}$/; //Example:044-89562354
		if(!landline_regex.test(landline)) {return "<span style='color:#FF0000; font-size:12px;'>Please enter correct value</span>";}else {return "";}
	}
//---------------------------------------Mobile Number Validation----------------------------------------
	this.mobile = function(str1,str2){		
		//var mobile_regex = /^(\+91?)([0-9]{11})$/i; //Example:+919688236895
		var mobile_regex = /^([+0-9]{1,3})?([0-9]{10,11})$/i; //Example:+919688236895
		
		if(!mobile_regex.test(str1)){$("#"+str2).html("Mobile Number Required");return 1;}else {$("#"+str2).html("");return 0;}
	}
//---------------------------------------User Name Min 8 Chars and alpha numeric characters--------------	
	this.username = function(username){
		var UserName_regex = /^[a-z0-9]{8,}/i; 
		if(!UserName_regex.test(username)) {return "<span style='color:#FF0000; font-size:12px;'>Please enter correct value</span>";}else {return "";}	
	}
//---------------------------------------Date Validation--------------------------------------------------		
	this.date = function(date){
		var date_regex = /^[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}$/i; //Example: 04-12-2014
		if(!date_regex.test(date)) {return "<span style='color:#FF0000; font-size:12px;'>Please enter correct value</span>";}else {return "";}	
	}
//---------------------------------IP address Validation--------------------------------------------
	this.IPaddress = function(ip){
	var ip_regex = /^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})$/i;//Example:192.198.1.23
		if(!ip_regex.test(ip)) {return "<span style='color:#FF0000; font-size:12px;'>Please enter correct IP address</span>";}else {return "";}	
	}
//---------------------------------Empty string Validation--------------------------------------------
	this.TextValid = function(str1,str2,str3){
		//alert(str1);
		var empty_regex = /^\s*\S+.*/;//Empty Value
		if(!empty_regex.test(str1)) {$("#"+str2).html(str3);return 1;}else {$("#"+str2).html("");return 0;}
	}
//---------------------------------Password Validation--------------------------------------------
	this.password = function(pass){
		var password_regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/;//should contain at least one digit, one lower case, one upper case, 8 from the mentioned characters.
		if(!password_regex.test(pass)) {return "<span style='color:#FF0000; font-size:12px;'>Please enter correct value</span>";}else {return "";}	
	}
//--------------------------------Drop Down List Box Validation-------------------------------------//
	this.dropdownBox=function(str1,str2,str3)
	{
		if(str1=="" || str1==null || str1=="0" || str1==0 || str1=="00")
		{
			
			$("#"+str2).html(str3);return 1;
		}
		else
		{
			
			$("#"+str2).html("");return 0;
		}
	}
	
	
	
	//---------------Empty string Validation with Component Border Highlights--------------------------------------------
	this.BoxValid = function(str1,str2,str3){
		
		var empty_regex = /^\s*\S+.*/;//Empty Value
		if(!empty_regex.test(str1)) {$("#"+str2).html(str3);return 1;}else {$("#"+str2).html('');return 0;}
	}
	
	this.boxEmail = function(str1,str2,str3){
		var Email_Regex = /^[a-z0-9._-]+@[a-z]+.[a-z.]{2,5}$/i;//Example:example@gmail.com
		if(!Email_Regex.test(str1)) {$("#"+str2).css('border','#ff0000 1px solid',str3);return 1;}else {$("#"+str2).css('border','#a9a9a9 1px solid');return 0;}
	}
	
	this.boxdropdownBox=function(str1,str2,str3){
		if(str1=="" || str1==null || str1=="0" || str1==0)
		{
			$("#"+str2).css('border','#ff0000 1px solid',str3);return 1;
		}
		else
		{
			$("#"+str2).css('border','#a9a9a9 1px solid');return 0;
		}
	}
	
	this.landlinebox = function(landline){
		var landline_regex = /^[0-9]{0,5}[-][0-9]{0,15}$/; //Example:044-89562354
		if(!landline_regex.test(landline)) {return "<span style='color:#FF0000; font-size:12px;'>Please enter correct value</span>";}else {return "";}
	}
	
		//-----------------------------------Numberic Number only Allowed-----------------------------------------			
	this.Numeric_only = function(myfield, e, dec){
		var key;
		var keychar;
		 
		if (window.event)
		   key = window.event.keyCode;
		else if (e)
		   key = e.which;
		else
		
		   return true;
		keychar = String.fromCharCode(key);
		 
		// control keys
		if ((key==null) || (key==0) || (key==8) || 
			(key==9) || (key==13) || (key==27) )
		   return true;
		 
		// numbers
		else if ((("0123456789").indexOf(keychar) > -1))
		   return true;
		 else
		   return false;
	}	
	//-------------------------------------------------Only Text----------------------------------------------
	this.Alpha_only = function(myfield, e, dec){
		var key;
		var keychar;
		if (window.event)
		   key = window.event.keyCode;
		else if (e)
		   key = e.which;
		else
		   return true;
		keychar = String.fromCharCode(key);
		 
		// control keys
		if ((key==null) || (key==0) || (key==8) || 
			(key==9) || (key==13) || (key==27) || (key==32) ||(key >= 65 && key <= 90) || (key >= 97 && key <= 122))
		   return true;
		  else
		   return false;
	}
	
	//-------------------------------------------------Only Text & Dot----------------------------------------------
	this.AlphaDot_only = function(myfield, e, dec){
		var key;
		var keychar;
		if (window.event)
		   key = window.event.keyCode;
		else if (e)
		   key = e.which;
		else
		   return true;
		keychar = String.fromCharCode(key);
		 
		// control keys
		if ((key==null) || (key==0) || (key==8) || (key==46) ||
			(key==9) || (key==13) || (key==27) || (key==32) ||(key >= 65 && key <= 90) || (key >= 97 && key <= 122))
		   return true;
		  else
		   return false;
	}
	
	
    this.IntText=function(str1,str2,str3)
    {
        if(str1=="" || str1==null || str1=="0" || str1==0)
        {
            $("#"+str2).html(str3);return 1;
        }
        else
        {
            $("#"+str2).html("");return 0;
        }
    }
	
//-------------------------------------------------Only Text and Numeric--------------------------------------------//
this.Alpha_Numeric = function(myfield, e, dec) 
{
var key;
var keychar;
 
if (window.event){
   key = window.event.keyCode;}
else if (e)
   key = e.which;
else
   return true;
keychar = String.fromCharCode(key);
 
// control keys
if ((key==null) || (key==0) || (key==8) || 
    (key==9) || (key==13) || (key==27) || (key==32) ||(key >= 65 && key <= 90) || (key >= 97 && key <= 122))
   return true;
  // numbers
else if ((("0123456789").indexOf(keychar) > -1))
   return true;
 else
   return false;
   
}

//-------------------------------------------------Only Text and Numeric--------------------------------------------//
this.Avoid_Quote = function(myfield, e, dec) 
{
var key;
var keychar;
 
if (window.event){
   key = window.event.keyCode;}
else if (e)
   key = e.which;
else
   return true;
   

// control keys
if ((key==null) || (key==34) || (key==39) )
   return false;
  // numbers
 else
   return true;
   
}

//-------------------------------------------------Only Text & & only--------------------------------------------//
this.AlphaDot = function(myfield, e, dec) 
{
var key;
var keychar;
 
if (window.event)
   key = window.event.keyCode;
else if (e)
   key = e.which;
else
   return true;
keychar = String.fromCharCode(key);
 
// control keys
if ((key==null) || (key==0) || (key==8) || 
    (key==9) || (key==13) || (key==27) || (key==32) || (key==46) ||(key >= 65 && key <= 90) || (key >= 97 && key <= 122))
   return true;
  else
   return false;
   
}


}
jScript_valid= new Class_Validation();










