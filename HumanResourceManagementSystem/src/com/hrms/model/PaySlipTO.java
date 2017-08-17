package com.hrms.model;

public class PaySlipTO {

	private int employeeId;
	private String employeeName;
	private String bankAccNo;
	private String panNo;
	private String designation;
	private String rank;
	private long basicSalary;
	private int hra;
	private int pf;
	private int payLoss;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public long getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(long basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getPf() {
		return pf;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public int getPayLoss() {
		return payLoss;
	}

	public void setPayLoss(int payLoss) {
		this.payLoss = payLoss;
	}

}
