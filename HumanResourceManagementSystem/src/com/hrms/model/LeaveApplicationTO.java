package com.hrms.model;

import java.util.Date;

public class LeaveApplicationTO {

	private int employeeId;
	private int casualLeave;
	private int leaveTaken;
	private Date fromDate;
	private Date toDate;
	private int lossOfPay;
	private int result;
	private Date DOJ;
	private String employeeName;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCasualLeave() {
		return casualLeave;
	}

	public void setCasualLeave(int casualLeave) {
		this.casualLeave = casualLeave;
	}

	public int getLeaveTaken() {
		return leaveTaken;
	}

	public void setLeaveTaken(int leaveTaken) {
		this.leaveTaken = leaveTaken;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getLossOfPay() {
		return lossOfPay;
	}

	public void setLossOfPay(int lossOfPay) {
		this.lossOfPay = lossOfPay;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}
