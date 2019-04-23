package com.mysqldemoproject.open.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysqldemoproject.open.model.Employee;

public interface EmployeeService {
			
	public  int employeeAdd(Employee emp);
	public List<Employee> employeeList();
	public Employee getEmployeeDetail(int id);
	public int updateEmployee(Employee emp);
	public int deleteEmployee(int id);
	public int totalEmployee();
	public List<Employee> getEmpl_listPage(int start);
	
}
