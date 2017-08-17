package com.hrms.model;

import java.util.Date;

public class AppraisalTO {
	private int empId;
	private int projectId;
	private String projectName;
	private Date startDate;
	private int testReport;
	private String certId;
	private String certName;
	private Date certDate;
	private String empName;
	private String empDomain;
	private String empDesign;
	private int basic;
	private int result;

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDomain() {
		return empDomain;
	}

	public void setEmpDomain(String empDomain) {
		this.empDomain = empDomain;
	}

	public String getEmpDesign() {
		return empDesign;
	}

	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getTestReport() {
		return testReport;
	}

	public void setTestReport(int testReport) {
		this.testReport = testReport;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public Date getCertDate() {
		return certDate;
	}

	public void setCertDate(Date certDate) {
		this.certDate = certDate;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
