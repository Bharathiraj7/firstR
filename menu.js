function dis_controller(str)
{
	$.ajax({url:str,success:function(retvalue){
		//alert(retvalue);
		$("#page-wrapper").html(retvalue);}});
}