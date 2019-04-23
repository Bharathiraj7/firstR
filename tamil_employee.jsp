<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<table width="90%" border="0" align="center"  style="border-collapse:collapse; font-family:arial; background:#dfe9f3; border-collapse:collapse; font-size:12px; margin-top:20px;" id="credit_info">
			
				
			
			<tr style="height:30px; background:#5b758c">
			
				<td colspan="3" style="color:#ffffff">	புதிய தொழிலாளர் சேர்க்கை</td>
			</tr>
			
				<tr>
					<td width="30%"> பெயர்</td>
					
					<td width="40%"><input type="text" name="emp_name" id="emp_name" />
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_ename"></span></td>
				</tr>
				<tr>
					<td> தகப்பனார் பெயர்</td>
					<td><input type="text" pa name="emp_fname" id="emp_fname" />  
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_efname"></span></td>
		  		</tr>
				<tr>
				
				<tr>
				
				<td> பிறந்த தேதி</td>
				<td><input type="text" name="emp_dob" id="emp_dob"    />
				</td>
					<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_edob"></span></td>
				</tr>
				
				<tr>
				
					<td> பொறுப்பு</td>
					<td><input type="text" name="emp_desig" id="emp_desig"    />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_edesig"></span></td>
				</tr>
				
				<tr>
				
					<td>கூடுதல் பொறுப்பு</td>
					<td><input type="text" name="emp_addesig" id="emp_addesig"   />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_eadesig"></span></td>
				</tr>
				<tr>
				
					<td>மின் முகவர்</td>
					<td><input type="text" name="emp_email" id="emp_email"   />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_eemail"></span></td>
				</tr>
				
				<tr>
				
					<td> கைப்பேசி</td>
					<td><input type="text" name="emp_cont" id="emp_cont"    />
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_econt"></span></td>
				</tr>
				
				<tr>
				<td>புகைப்படம்</td>
					<td><input type="file" name="emp_img" id="emp_img"  onchange="dispreview_images(this.value);" style="float:left">
					
					
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_photo"></span></td>
				</tr>
				
				<tr>
				<td> நிலவரம்</td>
					<td>
					<select name="emp_status" id="emp_status">
					
					<option value=0>நிலவர விபரம்</option>
					<option value="Y" > நிலவரம் உண்டு</option>
					<option value="N" >நிலவரம் இல்லை</option>
					
					</select>
				
					<input type="hidden" name="hid_eid" id="hid_eid" >
					</td>
				<td width="30%"><span style="color:#ff0000; font-style:italic" id="err_status"></span></td>
				</tr>
				
				<tr>
					<td align="right">
					
									
  								<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px;margin-top:5px;"><span style="cursor:pointer;" onclick="add_employee();">SAVE</span></div>
                          
								
					
					</td>
				<td align="left">
					
					<div style="width:100px; height:23px; background:url(resources/button/crystel_2575.png) no-repeat; text-align:center; font-weight:bold; font-family:Arial, Helvetica, sans-serif; font-size:12px; padding-top:7px; margin-top:5px;"><span style="cursor:pointer;" onclick="dis_controller('employee');">CANCEL</span></div>
					</td>
				</tr>
				 
		  </tr>
				
  </table>

