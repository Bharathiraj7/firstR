package com.mysqldemoproject.open.DAOImpl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysqldemoproject.open.DAO.EmployeeDAO;
import com.mysqldemoproject.open.model.Employee;
import com.mysqldemoproject.open.model.ShareDetail;
import com.mysqldemoproject.open.service.EmployeeService;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

		@Autowired
		SessionFactory sessionfactory;
		@Override
		@Transactional
		public int employeeAdd(Employee emp)
		{
			org.hibernate.Session asess= sessionfactory.getCurrentSession();
			asess.save(emp);
			Serializable ids = asess.getIdentifier(emp);
		    return (Integer) ids;
		}
		@Override @Transactional
		public List<Employee> getEmployeeList()
		{
			org.hibernate.Session ohs= sessionfactory.getCurrentSession();
			List<Employee> emplist = ohs.createQuery("from Employee ").setFirstResult(0).setMaxResults(10).list();
			return emplist;
		}
		@Override @Transactional
		public int totalEmployee()
		{
			org.hibernate.Session ohs= sessionfactory.getCurrentSession();
			Long  total_emp=(Long) ohs.createQuery("select count(*) from Employee ").uniqueResult();
			return total_emp.intValue();
		}
		@Transactional @Override
		public Employee getEmployeefullDetail(int id)
		{
			org.hibernate.Session session = sessionfactory.getCurrentSession();
			Employee getEmploye = (Employee) session.get(Employee.class, id);
			return getEmploye;
		}
		@Override @Transactional
		public int updateEmpDetail(Employee emp)
		{
			org.hibernate.Session upemp= sessionfactory.getCurrentSession();
			upemp.update(emp);
			Serializable ids = upemp.getIdentifier(emp);
			 return (Integer) ids;
		}
		@Override @Transactional
		public int removeEmployee(int id)
		{
			org.hibernate.Session delemp= sessionfactory.getCurrentSession();
			Employee emp=(Employee) delemp.get(Employee.class, id);
			delemp.delete(emp);
			Serializable ids = delemp.getIdentifier(emp);
			return (Integer) ids;
		}
		@Override @Transactional
		public List<Employee> getEmpl_listPage(int start)
		{
			
			org.hibernate.Session ohs= sessionfactory.getCurrentSession();
			List<Employee> emplist = ohs.createQuery("from Employee ").setFirstResult(start).setMaxResults(10).list();
			return emplist;
		}
		
	
}
