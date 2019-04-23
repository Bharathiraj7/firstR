package com.mysqldemoproject.open.DAO;

import java.util.List;

import com.mysqldemoproject.open.model.Employee;

public interface EmployeeDAO {
	public  int employeeAdd(Employee emp);
	public List<Employee> getEmployeeList();
	public Employee getEmployeefullDetail(int id);
	public int updateEmpDetail(Employee emp);
	public int removeEmployee(int id);
	public int totalEmployee();
	public List<Employee> getEmpl_listPage(int start);
}
