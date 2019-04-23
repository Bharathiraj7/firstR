<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script src="resources/js/employee.js"></script>
<table width="90%" border="0" align="center"  style="border-collapse:collapse; font-family:arial; background:#dfe9f3; border-collapse:collapse; font-size:12px; margin-top:20px;" id="credit_info">
			
				
			
			<tr style="height:30px; background:#5b758c">
			
				<td colspan="3" style="color:#ffffff">	${edit_det=='No'?'Employee Add':'Employee Edit' }</td>
			</tr>
			
				<tr>
					<td width="30%">Name</td>
					
					<td width="40%"><input type="text" name="emp_name" id="emp_name" value="${employee_detail.empName}" />
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_ename"></span></td>
				</tr>
				<tr>
					<td>Father Name</td>
					<td><input type="text" pa name="emp_fname" id="emp_fname" value="${employee_detail.empFname}" />  
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_efname"></span></td>
		  		</tr>
				<tr>
				
				<tr>
				
				<td>DOB</td>
				<td><input type="text" name="emp_dob" id="emp_dob" value="${employee_detail.empDob}"   />
				</td>
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_edob"></span></td>
				</tr>
				
				<tr>
				
					<td>Designation</td>
					<td><input type="text" name="emp_desig" id="emp_desig"  value="${employee_detail.empDesig}"  />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_edesig"></span></td>
				</tr>
				
				<tr>
				
					<td>Additional Designation</td>
					<td><input type="text" name="emp_addesig" id="emp_addesig"  value="${employee_detail.empAdddesig}"  />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_eadesig"></span></td>
				</tr>
				<tr>
				
					<td>Email</td>
					<td><input type="text" name="emp_email" id="emp_email" value="${employee_detail.empEmail}"   />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_eemail"></span></td>
				</tr>
				
				<tr>
				
					<td>Contact</td>
					<td><input type="text" name="emp_cont" id="emp_cont"  value="${employee_detail.empContact}"  />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_econt"></span></td>
				</tr>
				
				<tr>
				<td>Photo</td>
					<td><input type="file" name="emp_img" id="emp_img"  onchange="dispreview_images(this.value);" style="float:left">
					
					<img src="<c:url value="emp_photo?empImg=${employee_detail.empPhoto }"  />" width="100" height="100"  id="em_img" style="float:left">
					<input type="hidden" name="hid_photval" id="hid_photval" value="${employee_detail.empPhoto }">
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_photo"></span></td>
				</tr>
				
				<tr>
				<td>Status</td>
					<td>
					<select name="emp_status" id="emp_status">
					
					<option value=0>Select Status</option>
					<option value="Y"  selected="${employee_detail.empStatus=='Y'?'selected':'' }">Active</option>
					<option value="N"  selected="${employee_detail.empStatus=='N'?'selected':'' }">InActive</option>
					
					</select>
				
					<input type="hidden" name="hid_eid" id="hid_eid"  value="${employee_detail.empId}">
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_status"></span></td>
				</tr>
				
				<tr>
					<td align="right">
					<c:set var="ss"  scope="page" value="${edit_det}" />
								<c:if test="${ss=='No'}">
									
  								<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px;margin-top:5px;"><span style="cursor:pointer;" onclick="add_employee();">SAVE</span></div>
                                 </c:if>
								<c:if test="${ss=='Yes'}">
								  <div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px;"><span style="cursor:pointer;" onclick="edit_empdetail();">EDIT</span></div>
									
								</c:if>
					
					</td>
				<td align="left">
					
					<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px;"><span style="cursor:pointer;" onclick="dis_controller('employee');">CANCEL</span></div>
					</td>
				</tr>
				 
		  </tr>
				
  </table>
  <div style="margin-left:60px;"> 
  
  Total Count : ${total_emp}
  
  Box Count : ${box_val }

<c:set var="j" value="0"></c:set>

<c:forEach  var="i" begin="1" end="${box_val }">
<div style="width:30px; height:23px; background:#FF0000; float:left; margin-left:5px; text-align:center; padding-top:7px; color:#FFFFFF; font-weight:bold; cursor:pointer" onclick="disEmp_page(<c:out value="${j}"/>);"><c:out value="${i}"/></div>
     <c:set var="j"  scope="page" value="${j=j+10}" />
</c:forEach>

  </div>
  <table width="90%" border="0" style="border-collapse:collapse; background:#dfe9f3; border-collapse:collapse; font-size:13px; margin-top:15px; font-family:Arial;" align="center"  id="stu_info">
  <tr style="background:#5b758c; height:30px;">
				<td colspan="12" style="background:#5b758c; color:#fff; font-weight:bold; padding-left:10px; font-family:Arial;">Employee  Details </td>
			</tr>
  	<tr>
		<th>No</th>
		<th>Photo</th>
		<th>Name</th>
		<th>Father Name</th>
		<th>DOB</th>
		<th>Designation</th>
		<th>Additional Designation</th>
		<th>Email</th>
		<th>Contact</th>
		<th>Edit</th>
		<th>Delete</th>
		
	</tr>
	<c:forEach items="${empview}" var="empMemb" varStatus="status">
  <tr>
  <td>${status.index+1}</td>
  <td align="center"><img src="<c:url value="emp_photo?empImg=${empMemb.empPhoto }"  /> " width="50" height="50"></td>
  <td >${empMemb.empName}</td>
  <td >${empMemb.empFname}</td>
 <td >${empMemb.empDob}</td>
 <td >${empMemb.empDesig}</td>
 <td >${empMemb.empAdddesig}</td>
 <td >${empMemb.empEmail}</td>
 <td >${empMemb.empContact}</td>
 <td align="center"><img src="resources/images/edit_blue.png" onclick="edit_employee(${empMemb.empId});" style="cursor:pointer"></td>
 <td align="center"><img src="resources/images/round_delete.png" onclick="del_employee(${empMemb.empId});" style="cursor:pointer"></td>
  </tr>
  </c:forEach>
  </table>