package com.hrms.model;

import java.sql.Date;

public class RegistrationTO {

	private String employeeName;
	private String gender;
	private Date employeeDOB;
	private Date employeeDOJ;
	private Double employeeContactNo;
	private String employeeBankAccountNo;
	private String employeePanNo;
	private String employeeEmailId;
	private String employeeAddress;
	private String employeeDesignation;
	private String employeeDomain;
	private int employeeMaxExperiance;
	private float employeeBasicSalary;

	public RegistrationTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(Date employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

	public Date getEmployeeDOJ() {
		return employeeDOJ;
	}

	public void setEmployeeDOJ(Date employeeDOJ) {
		this.employeeDOJ = employeeDOJ;
	}

	public Double getEmployeeContactNo() {
		return employeeContactNo;
	}

	public void setEmployeeContactNo(Double employeeContactNo) {
		this.employeeContactNo = employeeContactNo;
	}

	public String getEmployeeBankAccountNo() {
		return employeeBankAccountNo;
	}

	public void setEmployeeBankAccountNo(String employeeBankAccountNo) {
		this.employeeBankAccountNo = employeeBankAccountNo;
	}

	public String getEmployeePanNo() {
		return employeePanNo;
	}

	public void setEmployeePanNo(String employeePanNo) {
		this.employeePanNo = employeePanNo;
	}

	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeDomain() {
		return employeeDomain;
	}

	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}

	public int getEmployeeMaxExperiance() {
		return employeeMaxExperiance;
	}

	public void setEmployeeMaxExperiance(int employeeMaxExperiance) {
		this.employeeMaxExperiance = employeeMaxExperiance;
	}

	public float getEmployeeBasicSalary() {
		return employeeBasicSalary;
	}

	public void setEmployeeBasicSalary(float employeeBasicSalary) {
		this.employeeBasicSalary = employeeBasicSalary;
	}

}
