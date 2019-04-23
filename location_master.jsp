<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<link href="resources/css/location_css.css" rel="stylesheet" />
<script src="resources/js/master.js"></script>
<div id="panel1">
			<table width="98%" border="0" align="center"  style="border-collapse:collapse; font-family:arial; background:#dfe9f3; border-collapse:collapse; font-size:12px; margin-top:20px;" id="credit_info">
			
				
			
			<tr style="height:30px; background:#5b758c">
			
				<td colspan="3" style="color:#ffffff">	${edit_det=='No'?'Add Country':' Edit Country' }</td>
			</tr>
			
				<tr>
					<td width="30%">Country</td>
					
					<td width="40%"><input type="text" name="cntry_name" id="cntry_name" value="${employee_detail.empName}" />
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_cntryname"></span></td>
				</tr>
			<tr>
					<td align="center" colspan="3">
						<c:set var="ss"  scope="page" value="${edit_det}" />
								<c:if test="${ss=='No'}">
									
									<button name="county_addbut" id="county_addbut" onclick="add_country();" >ADD</button>
									<button name="county_addbut" id="county_addbut" >RESET</button>
  								
                                 </c:if>
								<c:if test="${ss=='Yes'}">
								  <div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px; float:left;"><span style="cursor:pointer;" onclick="edit_empdetail();">EDIT</span></div>
									<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px;"><span style="cursor:pointer;" onclick="dis_controller('employee');">CANCEL</span></div>
								</c:if>
					</td>
				</tr>
			</table>
			
			
			<table width="98%" border="0" style="border-collapse:collapse; background:#dfe9f3; border-collapse:collapse; font-size:13px; margin-top:15px; font-family:Arial;" align="center"  id="stu_info">
  <tr style="background:#5b758c; height:30px;">
				<td colspan="12" style="background:#5b758c; color:#fff; font-weight:bold; padding-left:10px; font-family:Arial;">Employee  Details </td>
			</tr>
  	<tr>
		<th>No</th>
		<th>Name</th>
		<th>Edit</th>
		<th>Delete</th>
		
	</tr>
	<c:forEach items="${cntlist}" var="countylist" varStatus="status">
  <tr>
  <td>${status.index+1}</td>
 <td >${countylist.countryName}</td>
 <td align="center"><img src="resources/images/edit_blue.png" onclick="edit_employee(${countylist.countryId});" style="cursor:pointer"></td>
 <td align="center"><img src="resources/images/round_delete.png" onclick="del_employee(${countylist.countryId});" style="cursor:pointer"></td>
  </tr>
  </c:forEach>
  </table>
			
			
			


</div>
<div id="panel2">

	<table width="98%" border="0" align="center"  style="border-collapse:collapse; font-family:arial; background:#dfe9f3; border-collapse:collapse; font-size:12px; margin-top:20px;" id="credit_info">
			
				
			
			<tr style="height:30px; background:#5b758c">
			
				<td colspan="3" style="color:#ffffff">	${edit_det=='No'?'Add States':' Edit States' }</td>
			</tr>
			
				<tr>
					<td width="30%">Country</td>
					
					<td width="40%">
					<select name="cnt_val" id="cnt_val" style="width:170px;">
					<option value="0">Select Country</option>
					
					<c:forEach items="${cntlist}" var="cntry_list" varStatus="status">
					<option value="${cntry_list.countryId}">${cntry_list.countryName}</option>
					</c:forEach>
					
					</select>
					
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_slctcntr"></span></td>
				</tr>
				
				<tr>
				
				<td width="30%">States</td>
					
					<td width="40%"><input type="text" name="states_name" id="states_name" value="${employee_detail.empName}" /></td>
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_statname"></span></td>
				</tr>
			<tr>
					<td align="center" colspan="3">
						<c:set var="ss"  scope="page" value="${edit_det}" />
								<c:if test="${ss=='No'}">
									
									<button name="county_addbut" id="county_addbut" onclick="add_states();" >ADD</button>
									<button name="county_addbut" id="county_addbut" >RESET</button>
  								
                                 </c:if>
								<c:if test="${ss=='Yes'}">
								  <div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px; float:left;"><span style="cursor:pointer;" onclick="edit_empdetail();">EDIT</span></div>
									<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px;"><span style="cursor:pointer;" onclick="dis_controller('employee');">CANCEL</span></div>
								</c:if>
					</td>
				</tr>
			</table>


					<table width="98%" border="0" style="border-collapse:collapse; background:#dfe9f3; border-collapse:collapse; font-size:13px; margin-top:15px; font-family:Arial;" align="center"  id="stu_info">
  <tr style="background:#5b758c; height:30px;">
				<td colspan="12" style="background:#5b758c; color:#fff; font-weight:bold; padding-left:10px; font-family:Arial;">Employee  Details </td>
			</tr>
  	<tr>
		<th>No</th>
		<th>Country</th>
		<th>State</th>
		<th>Edit</th>
		<th>Delete</th>
		
	</tr>
	<c:forEach items="${statlist}" var="statelist" varStatus="status">
  <tr>
  <td>${status.index+1}</td>
 <td >${statelist.country.countryName}</td>
 <td >${statelist.stateName}</td>
 <td align="center"><img src="resources/images/edit_blue.png" onclick="edit_employee(${statelist.stateId});" style="cursor:pointer"></td>
 <td align="center"><img src="resources/images/round_delete.png" onclick="del_employee(${statelist.stateId});" style="cursor:pointer"></td>
  </tr>
  </c:forEach>
  </table>
</div>
<div id="panel3">

			<table width="98%" border="0" align="center"  style="border-collapse:collapse; font-family:arial; background:#dfe9f3; border-collapse:collapse; font-size:12px; margin-top:20px;" id="credit_info">
			
				
			
			<tr style="height:30px; background:#5b758c">
			
				<td colspan="3" style="color:#ffffff">	${edit_det=='No'?'Add Place(City)':' Edit Place(City)' }</td>
			</tr>
			
				<tr>
					<td width="30%">Country</td>
					
					<td width="40%">
					<select name="place_country" id="place_country" style="width:170px;" onchange="dis_state(this.value);">
					<option value="0">Select Country</option>
					
					<c:forEach items="${cntlist}" var="cntry_list" varStatus="status">
					<option value="${cntry_list.countryId}">${cntry_list.countryName}</option>
					</c:forEach>
					
					</select>
					
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_placecnty"></span></td>
				</tr>
				
				<tr>
				
				<td width="30%">States</td>
					
					<td width="40%">
					<select name="place_state" id="place_state" style="width:170px;" onchange="dis_placelist(this.value);">
					<option value="0">Select States</option>
					</select>
						
					
					</td>
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_placestate"></span></td>
				</tr>
				
				<tr>
				
				<td width="30%">Place / City / Location</td>
					
					<td width="40%"><input type="text" name="place_name" id="place_name" value="${employee_detail.empName}" /></td>
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_placename"></span></td>
				</tr>
			<tr>
					<td align="center" colspan="3">
						<c:set var="ss"  scope="page" value="${edit_det}" />
								<c:if test="${ss=='No'}">
									
									<button name="county_addbut" id="county_addbut" onclick="add_place();" >ADD</button>
									<button name="county_addbut" id="county_addbut" >RESET</button>
  								
                                 </c:if>
								<c:if test="${ss=='Yes'}">
								  <div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px; float:left;"><span style="cursor:pointer;" onclick="edit_empdetail();">EDIT</span></div>
									<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px;"><span style="cursor:pointer;" onclick="dis_controller('employee');">CANCEL</span></div>
								</c:if>
					</td>
				</tr>
			</table>
<div id="dis_placedetail">
<table width="98%" border="0" style="border-collapse:collapse; background:#dfe9f3; border-collapse:collapse; font-size:13px; margin-top:15px; font-family:Arial;" align="center"  id="stu_info">
  <tr style="background:#5b758c; height:30px;">
				<td colspan="12" style="background:#5b758c; color:#fff; font-weight:bold; padding-left:10px; font-family:Arial;">Place Name </td>
			</tr>
  	<tr>
		<th>No</th>
		<th>Place Name</th>
		<th>Edit</th>
		<th>Delete</th>
		
	</tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	
	</tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	
	</tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	
	</tr>
	
	</table>
</div>
</div>