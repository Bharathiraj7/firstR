package com.mysqldemoproject.open.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee {

	/**
	 * The persistent class for the member_info database table.
	 * 
	 */
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;

	@Column(name="emp_adddesig")
	private String empAdddesig;

	@Column(name="emp_contact")
	private String empContact;

	@Column(name="emp_desig")
	private String empDesig;

	@Temporal(TemporalType.DATE)
	@Column(name="emp_dob")
	private Date empDob;

	@Column(name="emp_email")
	private String empEmail;

	@Column(name="emp_fname")
	private String empFname;

	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_photo")
	private String empPhoto;

	public String getEmpPhoto() {
		return empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	@Column(name="emp_status")
	private String empStatus;

	public Employee() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpAdddesig() {
		return this.empAdddesig;
	}

	public void setEmpAdddesig(String empAdddesig) {
		this.empAdddesig = empAdddesig;
	}

	public String getEmpContact() {
		return this.empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public String getEmpDesig() {
		return this.empDesig;
	}

	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}

	public Date getEmpDob() {
		return this.empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpFname() {
		return this.empFname;
	}

	public void setEmpFname(String empFname) {
		this.empFname = empFname;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpStatus() {
		return this.empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}


	
	
}
