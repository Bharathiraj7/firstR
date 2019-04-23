package com.mysqldemoproject.open.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysqldemoproject.open.DAO.CountryDAO;
import com.mysqldemoproject.open.DAO.PlaceDAO;
import com.mysqldemoproject.open.DAO.StateDAO;
import com.mysqldemoproject.open.model.Collection;
import com.mysqldemoproject.open.model.Country;
import com.mysqldemoproject.open.model.Employee;
import com.mysqldemoproject.open.model.ExcelData;
import com.mysqldemoproject.open.model.Place;
import com.mysqldemoproject.open.model.State;


@Controller
public class MasterController {
	
	@Autowired
	CountryDAO cntdao;
	@Autowired
	StateDAO stdao;
	@Autowired
	PlaceDAO pldao;
	@Autowired
	ServletContext servletContext;
	@Autowired
	SessionFactory sessionFactory;
	
	
	@ResponseBody
    @RequestMapping(value = "/addCountry", method = RequestMethod.POST)
	public String addCountry(@RequestParam String cntry_name, Model model)
	{
		System.out.println("Hava a Nice Day");
		String return_status = "";
		int add_status = 0;
		Country cnt= new Country();
		cnt.setCountryName(cntry_name);
		cnt.setCountryStatus("Y");
	
		try {
			
			add_status = cntdao.countryAdd(cnt);
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
	@ResponseBody
    @RequestMapping(value = "/addStates", method = RequestMethod.POST)
	public String addStates(@RequestParam int  a_slcntry,@RequestParam String a_state, Model model)
	{
		String return_status = "";
		int add_status = 0;
		State st= new State();
		st.setStateName(a_state);
		st.setStateStatus("Y");
		Country cId = cntdao.getCountryDetail(a_slcntry);
		st.setCountry(cId);
	
		try {
			
			add_status = stdao.stateAdd(st);
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
	
	@ResponseBody
	@RequestMapping(value="/getStatelists", method=RequestMethod.POST)
	public String getstatedetails(@RequestParam Integer a_cntry,Model model)
	{
		
		List<State> state_list =stdao.getState_Country(a_cntry);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		Iterator itr = state_list.iterator();
		while(itr.hasNext()){
			State  stlist = (State)itr.next();
			json.put("status", stlist.getStateName());
			json.put("state_id",stlist.getStateId());
			array.add(json);
			}
		
		return array.toString();
		
	}
	@ResponseBody
	@RequestMapping(value="/addPlace", method=RequestMethod.POST)
	public String addPlace(@RequestParam Integer ap_cntry, Integer ap_state,String  ap_place, Model model)
	{
		String return_status = "";
		int add_status = 0;
		Place pl= new Place();
		pl.setPlaceName(ap_place);
		pl.setPlaceStatus("Y");
		State stId =stdao.getStateId(ap_state);
		pl.setState(stId);
	try {
			
			add_status=pldao.addPlace(pl);
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
	@ResponseBody
	@RequestMapping(value="/getPlaceLists", method=RequestMethod.POST)
	public String getlistPlace(@RequestParam Integer a_state, Model model)
	{
		List <Object[]> listview=pldao.getPlaceDetail(a_state);
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		Iterator itr= listview.iterator();
		while(itr.hasNext()){
			Object[] plce_det =(Object[])itr.next();
			json.put("country", plce_det[3]);
			json.put("state", plce_det[2]);
			json.put("place", plce_det[0]);
			json.put("place_name", plce_det[1]);
			array.add(json);
		}
		return array.toString();
	}
	@ResponseBody
	@RequestMapping(value="/excel_cntrl",method=RequestMethod.POST)  
    public String  saveimage(@RequestParam MultipartFile ex_file, Model model) throws  IOException
	{  
    	System.out.println(ex_file.getOriginalFilename());
    		String save_status="";
    		String filename=ex_file.getOriginalFilename();
    		org.hibernate.Session session=sessionFactory.openSession();
    		org.hibernate.Transaction tx=session.beginTransaction();
    		try{
    			
    			byte[] bytes=ex_file.getBytes();
    			
    			String rootPath=servletContext.getRealPath("/");
    			File dir=new File(rootPath+"/resources/");
    			if(!dir.exists())
    	               dir.mkdirs();
    			File serverFile=new File(dir.getAbsolutePath() +File.separator +filename);
    			BufferedOutputStream buffer=new BufferedOutputStream(new FileOutputStream(serverFile));
    			buffer.write(bytes);
    			buffer.close();			
    			FileInputStream file=new FileInputStream(serverFile);			
    			POIFSFileSystem poi=new POIFSFileSystem(file);
    			HSSFWorkbook workbook=new HSSFWorkbook(poi);
    			
    			HSSFSheet sheet=workbook.getSheetAt(0);
    			Row row;	   			
    			
    			for(int i=1;i <=sheet.getLastRowNum();i++)
    			{
    			
    				row=sheet.getRow(i);
    				
    				String e_code = row.getCell(1).toString();    			
    				String e_date=row.getCell(2).toString();
    				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    				LocalDate localdate = LocalDate.parse(e_date,df);
    				Date sqldate = Date.valueOf(localdate);
    				String e_amt=row.getCell(3).toString();
    				BigDecimal bamt=new BigDecimal(e_amt);
    				String e_status=row.getCell(4).toString();    			
    				
    				ExcelData ex_data=new ExcelData();
    				ex_data.setExcelDat_code(e_code);    				
       				ex_data.setExcelDat_date(sqldate);    		
       				ex_data.setExcelDat_amount(bamt);
    				ex_data.setExcelDat_status(e_status);
    				System.out.println(e_code);
    				session.save(ex_data);

    				
    			}
    		
    			tx.commit();
    			
    			save_status="Y";
    			System.out.println("Hi Nanthi");
    		}
	
	catch(Exception e){
tx.rollback();
		save_status="N";
	}
 
    return save_status;
    	
    	
    }

}
