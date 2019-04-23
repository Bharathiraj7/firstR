package com.mysqldemoproject.open.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldemoproject.open.DAO.EmployeeDAO;
import com.mysqldemoproject.open.model.Employee;
import com.mysqldemoproject.open.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
				@Autowired
				EmployeeDAO empdao;
				@Override
				public  int employeeAdd(Employee emp)
				{
					return empdao.employeeAdd(emp);
				}
				@Override
				public List<Employee> employeeList()
				{
					return empdao.getEmployeeList();
				}
				@Override
				public Employee getEmployeeDetail(int id)
				{
					return empdao.getEmployeefullDetail(id);
				}
				@Override
				public int updateEmployee(Employee emp)
				{
					return empdao.updateEmpDetail(emp);
				}
				@Override
				public int deleteEmployee(int id)
				{
					return empdao.removeEmployee(id);
				}
				@Override
				public int totalEmployee()
				{
					return empdao.totalEmployee();
				}
				@Override
				public List<Employee>getEmpl_listPage(int start)
				{
					return empdao.getEmpl_listPage(start);
				}
}
