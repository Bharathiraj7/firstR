<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script src="resources/js/sharelist.js"></script>
<h4 align="center" style="color:#ff0000; font-family:arial;"> Share Holder List details</h4>



<table width="80%" border="0" style="border-collapse:collapse; background:#dfe9f3; border-collapse:collapse; font-size:13px; margin-top:15px; font-family:Arial;" align="center"  id="stu_info">
  <tr style="background:#5b758c; height:30px;">
				<td colspan="12" style="background:#5b758c; color:#fff; font-weight:bold; padding-left:10px; font-family:Arial;">Share Holder Member Details </td>
			</tr>
  	<tr>
		<th>No</th>
		<th>Name</th>
		<th>Father Name</th>
		<th>Age</th>
		<th>Occupation</th>
		<th>Contact</th>
		<th>Edit</th>
		<th>Delete</th>
		
	</tr>
	<c:forEach items="${shareMemberList}" var="sharMemb" varStatus="status">
  <tr>
  <td>${status.index+1}</td>
  <td >${sharMemb.memInfo_fname}</td>
  <td >${sharMemb.memInfo_fathname}</td>
 <td >${sharMemb.memInfo_age}</td>
 <td >${sharMemb.memInfo_occup}</td>
 <td >${sharMemb.memInfo_contno}</td>
 <td align="center"><img src="resources/images/edit_blue.png" onclick="edit_share(${sharMemb.memInfo_id});" style="cursor:pointer"></td>
 <td align="center"><img src="resources/images/round_delete.png" onclick="del_share(${sharMemb.memInfo_id});" style="cursor:pointer"></td>
  </tr>
  </c:forEach>
  </table>






