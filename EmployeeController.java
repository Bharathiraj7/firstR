package com.mysqldemoproject.open.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysqldemoproject.open.model.Employee;
import com.mysqldemoproject.open.service.EmployeeService;

@Controller
public class EmployeeController {

	
	 private static final  String external ="D:/Java Development/Employee_Photo/";

	private static final int BUFFER_SIZE = 0;    

	@Autowired
	EmployeeService empser;
	@Autowired
	ServletContext servletContext;

	@ResponseBody
     @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@RequestParam String empName,
			@RequestParam String empFname, @RequestParam java.sql.Date empDob,
			@RequestParam String empDesig, @RequestParam String empAdddesig,
			@RequestParam String empEmail, @RequestParam String empContact, @RequestParam MultipartFile emp_img,
			@RequestParam String empStatus, Model model) {
		Employee emp = new Employee();
		emp.setEmpName(empName);
		emp.setEmpFname(empFname);
		emp.setEmpDob(empDob);
		emp.setEmpDesig(empDesig);
		emp.setEmpAdddesig(empAdddesig);
		emp.setEmpEmail(empEmail);
		emp.setEmpContact(empContact);
		emp.setEmpStatus(empStatus);
		String file_name=emp_img.getOriginalFilename();
		emp.setEmpPhoto(file_name);
		String destination = "D:/Java Development/Employee_Photo/"+ file_name;
		File empImage = new File(destination);

		
		String return_status = "";
		// String edit_status="no";
		int add_status = 0;
		try {
			emp_img.transferTo(empImage);
			add_status = empser.employeeAdd(emp);
			if (add_status > 0)
				return_status = "OK";
		} catch (DataIntegrityViolationException dive) {
			System.out.println("dive:" + dive.getMessage());
			return_status = "Data Integrity Exception";
		} catch (ConstraintViolationException cve) {
			System.out.println("cve:" + cve.getMessage());
			return_status = "Data already present please check it!";
		} catch (HibernateException he) {
			System.out.println("he:" + he.getMessage());
			return_status = "Fill The form Properly!";
		} catch (Exception e) {
			System.out.println("Eception is:" + e.getMessage());
			return_status = "Sql Exception has been caught";
		}
		JSONObject json = new JSONObject();
		json.put("status", return_status);		
		
		System.out.println("JSON RETURN OBJECT : "+json);
		return json.toString();
	}

	@RequestMapping(value = "/editEmployeePage", method = RequestMethod.POST)
	public ModelAndView getShareValue(@RequestParam Integer aemp_id, Model model) {
		Employee emdet = empser.getEmployeeDetail(aemp_id);
		String edit_status = "Yes";
		List<Employee> listemp = empser.employeeList();
		model.addAttribute("empview", listemp);
		model.addAttribute("edit_det", edit_status);
		model.addAttribute("employee_detail", emdet);
		return new ModelAndView("employee");

	}

	@ResponseBody
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public String updateEmployee(@RequestParam String empName,
			@RequestParam String empFname, @RequestParam java.sql.Date empDob,
			@RequestParam String empDesig, @RequestParam String empAdddesig,
			@RequestParam String empEmail, @RequestParam String empContact,
			@RequestParam String empStatus, @RequestParam Integer empId,
			@RequestParam MultipartFile emp_img, @RequestParam String emphidphoto,
			Model model) {
		Employee emp = new Employee();
		emp.setEmpName(empName);
		emp.setEmpFname(empFname);
		emp.setEmpDob(empDob);
		emp.setEmpDesig(empDesig);
		emp.setEmpAdddesig(empAdddesig);
		emp.setEmpEmail(empEmail);
		emp.setEmpContact(empContact);
		emp.setEmpStatus(empStatus);
		emp.setEmpId(empId);
		String file_name=emp_img.getOriginalFilename();

		String return_status = "";
		int edit_status = 0;
		//System.out.println(file_name);
		try {
			if(file_name!="")
			{
				if(file_name!=emphidphoto)
				{
					//System.out.println("Changed Photo");
					String destination = "D:/Java Development/Employee_Photo/"+ file_name;
					String exist_file="D:/Java Development/Employee_Photo/"+ emphidphoto;
					File empImage = new File(destination);
					emp_img.transferTo(empImage);
					File curimg= new File(exist_file);
					curimg.delete();
					emp.setEmpPhoto(file_name);
				}
				
			}
			else
			{
				//System.out.println("Same Photo");
				emp.setEmpPhoto(emphidphoto);
			}
			edit_status = empser.updateEmployee(emp);
			if (edit_status > 0)
				return_status = "OK";
		} catch (DataIntegrityViolationException dive) {
			System.out.println("dive:" + dive.getMessage());
			return_status = "Data Integrity Exception";
		} catch (ConstraintViolationException cve) {
			System.out.println("cve:" + cve.getMessage());
			return_status = "Data already present please check it!";
		} catch (HibernateException he) {
			System.out.println("he:" + he.getMessage());
			return_status = "Fill The form Properly!";
		} catch (Exception e) {
			System.out.println("Eception is:" + e.getMessage());
			return_status = "Sql Exception has been caught";
		}
		JSONObject json = new JSONObject();
		json.put("status", return_status);		
		
		System.out.println("JSON RETURN OBJECT OF EDIT : "+json);
		return json.toString();

	}

	@ResponseBody
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public int deleteEmployee(@RequestParam Integer aEmpid, Model model) {
		return empser.deleteEmployee(aEmpid);
	}
	
	@ResponseBody
	@RequestMapping(value="/emp_photo")
	public byte[] getEmployeeImage(@RequestParam String empImg) throws IOException 

	{
		
		 Path path = Paths.get(external+empImg);
	        byte[] data = Files.readAllBytes(path); 
	        return data;

	}
	
	@ResponseBody
	@RequestMapping(value="/excel_employee", method=RequestMethod.POST)
	public String download_employee(@RequestParam String aexcel_emp, Model model) throws IOException
	{
		  JSONObject json = new JSONObject();
		List<Employee> listemp = empser.employeeList();
		 String root=servletContext.getRealPath("/")+"resources/";
		 if(listemp.size() > 0)
		 {
			 HSSFWorkbook workbook=new HSSFWorkbook();
			 HSSFSheet spreadsheet = workbook.createSheet("Employee_Detail");
			 Row row=spreadsheet.createRow(0);
			 Cell cell;
			 cell=row.createCell(0);
			 cell.setCellValue("No");
			 cell=row.createCell(1);
			 cell.setCellValue("Name");
			 cell=row.createCell(2);
			 cell.setCellValue("Father");
			 cell=row.createCell(3);
			 cell.setCellValue("DOB");
			 cell=row.createCell(4);
			 cell.setCellValue("Designation");
			 cell=row.createCell(5);
			 cell.setCellValue("Additional Designation");
			 cell=row.createCell(6);
			 cell.setCellValue("Email");
			 cell=row.createCell(7);
			 cell.setCellValue("Contact");
			  int i=1;
	            int line=0; 
	            Iterator itr= listemp.iterator();
	            while(itr.hasNext())
	            {
	            	Employee emp=(Employee) itr.next();
	            	row=spreadsheet.createRow(i);
	            	cell=row.createCell(0);
	            	cell.setCellValue(i);
	            	
	            	cell=row.createCell(1);
	            	cell.setCellValue(emp.getEmpName());
	            	
	            	cell=row.createCell(2);
	            	cell.setCellValue(emp.getEmpFname());
	            	
	            	cell=row.createCell(3);
	            	
	            	java.sql.Date dobdate=(java.sql.Date) emp.getEmpDob();
	            	cell.setCellValue(dobdate.toString());
	            	
	            	
	            	cell=row.createCell(4);
	            	cell.setCellValue(emp.getEmpDesig());
	            	
	            	cell=row.createCell(5);
	            	cell.setCellValue(emp.getEmpAdddesig());
	            	
	            	cell=row.createCell(6);
	            	cell.setCellValue(emp.getEmpEmail());
	            	
	            	cell=row.createCell(7);
	            	cell.setCellValue(emp.getEmpContact());
	            	
	            	 i++;
                     line++;
	            	
	            }
	          
	            if(line==listemp.size()){
                    FileOutputStream out = new FileOutputStream(root+"Employee_Detail"+".xls");
                    workbook.write(out);
                    out.close();
                   System.out.println(root);
            		json.put("status", "OK");
            		json.put("file_name", "Employee_Detail.xls");
            	
            		
            		System.out.println("File of Excel Created : "+json);
            		
                   // return "Data has been exported successfully for "+name+" <br> <a style='color:red;font-weight: bold;' href='downloading.html?fileName="+name+".xls'>&nbsp;Download Excel File";
                }
	            else
	            {
	            	json.put("status", "NO");		
	            }
	           
		 }
		 return json.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/fileDownload", method=RequestMethod.POST)
	public void  filedownload(@RequestParam String a_fname, Model model,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		String root=servletContext.getRealPath("/")+"/resources/";
		System.out.println(root);
		//System.out.println(request.getParameter("fileName"));
        File downloadFile = new File(root+File.separator+a_fname);
		FileInputStream inputStream = null;
		OutputStream outStream = null;
		try {
			inputStream = new FileInputStream(downloadFile);
 			response.setContentLength((int) downloadFile.length());
			response.setContentType(servletContext.getMimeType(root+File.separator+a_fname));			
 
			// response header
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
			response.setHeader(headerKey, headerValue);
 
			// Write response
			outStream = response.getOutputStream();
			IOUtils.copy(inputStream, outStream);
 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream)
					inputStream.close();
				if (null != inputStream)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
 
		}
		//return "OK";
	}
	
	@ResponseBody
	@RequestMapping(value="/mydownload", method=RequestMethod.POST)
	public void downloadExcel(@RequestParam String a_fname, Model model,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		 // get absolute path of the application
		String root=servletContext.getRealPath("/")+"/resources/";
        
        // construct the complete absolute path of the file
      System.out.println("File Seaperatero is : "+File.separator);
        File downloadFile = new File(root+File.separator+a_fname);
        FileInputStream inputStream = new FileInputStream(downloadFile);
        
         
        // get MIME type of the fil
        String mimeType=servletContext.getMimeType(root+File.separator+a_fname);
      
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
 
        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
 
        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);
 
        // get output stream of the response
        OutputStream outStream = response.getOutputStream();
 
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
       System.out.println("Before Byte conversion!");
        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
       /*outStream = response.getOutputStream();
		IOUtils.copy(inputStream, outStream);*/
        System.out.println(" Byte conversion!");
        inputStream.close();
        outStream.close();
	}
	
	@RequestMapping(value = "/downloading", method = RequestMethod.GET)
	public @ResponseBody void downloadFile(@RequestParam String fileName,HttpServletRequest request,HttpServletResponse response) {
		
		String root=servletContext.getRealPath("/")+"/resources/";
		//System.out.println(request.getParameter("fileName"));
        File downloadFile = new File(root+File.separator+fileName);
		FileInputStream inputStream = null;
		OutputStream outStream = null;
		try {
			inputStream = new FileInputStream(downloadFile);
 			response.setContentLength((int) downloadFile.length());
			response.setContentType(servletContext.getMimeType(root+File.separator+fileName));			
 
			// response header
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
			response.setHeader(headerKey, headerValue);
 
			// Write response
			outStream = response.getOutputStream();
			IOUtils.copy(inputStream, outStream);
 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream)
					inputStream.close();
				if (null != inputStream)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
 
		}
 
	}	
	
	
	
}
