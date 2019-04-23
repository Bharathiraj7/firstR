<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<table width="50%" border="0" align="center"  style="border-collapse:collapse; font-family:arial; background:#dfe9f3; border-collapse:collapse; font-size:12px; margin-top:20px;" id="credit_info">
			
				
			
			<tr style="height:30px; background:#5b758c">
			
				<td colspan="3" style="color:#ffffff">Edit Share Holder Customer Details</td>
			</tr>
			
				<tr>
					<td width="30%">Name</td>
					<td width="40%"><input type="text" name="uname" id="uname"  value="${shareDet.memInfo_fname}"/>
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="euname"></span></td>
				</tr>
				<tr>
					<td>Father Name</td>
					<td><input type="text" name="fname" id="fname"  value="${shareDet.memInfo_fathname}"/>  
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="efname" ></span></td>
		  		</tr>
				<tr>
				
				<tr>
				
					<td>Age</td>
					<td><input type="text" name="age" id="age"  value="${shareDet.memInfo_age}" />
					</td>
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="eage" ></span></td>
				</tr>
				
				<tr>
				
					<td>Occupation</td>
					<td><input type="text" name="occup" id="occup"  value="${shareDet.memInfo_occup}"  />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="eoccup" ></span></td>
				</tr>
				
				<tr>
				
					<td>Contact Number</td>
					<td><input type="text" name="cnnum" id="cnnum"  value="${shareDet.memInfo_contno}" />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="ecnum"></span></td>
				</tr>
				
				
				<tr>
					<td align="right">
					<input type="hidden" name="hid_shrId" id="hid_shrId"  value="${shareDet.memInfo_id}">
					<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-left:40%; margin-top:5px;"><span style="cursor:pointer;" onclick="sharemem_edit();">EDIT</span></div>
					</td>
					
					<td align="left">
					<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-left:40%; margin-top:5px;"><span style="cursor:pointer;" onclick="dis_controller('viewshareholder');">LIST</span></div>
					</td>
				
				</tr>
				 
		  </tr>
				
  </table>