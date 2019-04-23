
package com.mysqldemoproject.open;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysqldemoproject.open.DAO.CountryDAO;
import com.mysqldemoproject.open.DAO.StateDAO;
import com.mysqldemoproject.open.model.Country;
import com.mysqldemoproject.open.model.State;
import com.mysqldemoproject.open.model.Employee;
import com.mysqldemoproject.open.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	EmployeeService empser;
	@Autowired
	CountryDAO cntdao;
	@Autowired
	StateDAO stdao;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
//		System.out.println("working");
		return "home";
	}
	@RequestMapping(value = "/addshare", method = RequestMethod.GET)
	public String addsharedetail( Model model) {
//		System.out.println("working");
		return "addshare";
	}
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee( Model model) {
		String edit_status="No";
		List<Employee> listemp = empser.employeeList();
		int t_emp=empser.totalEmployee();
		int box=(int) Math.ceil((double) t_emp/10);
		
		model.addAttribute("empview", listemp);
		model.addAttribute("edit_det", edit_status);
		model.addAttribute("total_emp", t_emp);
		model.addAttribute("box_val", box);
		return new ModelAndView("employee");
	}
	@RequestMapping(value="/location",method=RequestMethod.GET)
	public ModelAndView filepage(Model model)
	{
		String edit_status="No";
		List <Country> listcntry=cntdao.getCountryList();
		List<State> liststate=stdao.getStateDetails();
		model.addAttribute("cntlist", listcntry);
		model.addAttribute("statlist", liststate);
		model.addAttribute("edit_det", edit_status);
		return new ModelAndView("location_master");
	}
	@RequestMapping(value="/filemove",method=RequestMethod.POST)  
    public ModelAndView saveimage(@RequestParam MultipartFile emp_img, Model model) throws IllegalStateException, IOException
	{  
    	System.out.println(emp_img.getOriginalFilename());
    		String destination = "D:/Java Development/JavaProjects/MysqlDemoProject/src/main/webapp/resources/upload_file/"+ emp_img.getOriginalFilename();
    		File file1 = new File(destination);
    		emp_img.transferTo(file1);
//    return new ModelAndView("success","filesuccess","File successfully saved!");
    	return new ModelAndView("filePage");
    	
    	
    }
	@RequestMapping(value="/excel", method=RequestMethod.GET)
	public String ExcelUpload(Model model)
	{
		return "excel_upload";
	}
	@RequestMapping(value="/excel_download", method=RequestMethod.GET)
	public String Exceldownload(Model model)
	{
		return "excel_download";
	}
	
	@RequestMapping(value = "/employee_pagination", method = RequestMethod.POST)
	public ModelAndView employee_page(@RequestParam Integer astart, Model model) {
		
		System.out.println("Hello working page!");
		
		String edit_status="No";
		List<Employee> listemp = empser.getEmpl_listPage(astart);
		int t_emp=empser.totalEmployee();
		int box=(int) Math.ceil((double) t_emp/10);
		
		model.addAttribute("empview", listemp);
		model.addAttribute("edit_det", edit_status);
		model.addAttribute("total_emp", t_emp);
		model.addAttribute("box_val", box);
		return new ModelAndView("employee");
	}
	

	@RequestMapping(value = "/tamil_employeeadd", method = RequestMethod.GET)
	public String addtamilemployee( Model model) {
//		System.out.println("working");
		return "tamil_employee";
	}
	
	
	
	
}
