package com.hrms.dao;

import com.hrms.exceptions.ApplicationException;
import com.hrms.model.LeaveApplicationTO;

public interface LeaveApplication {

	public LeaveApplicationTO checkUser(LeaveApplicationTO leave)
			throws ApplicationException;

	public void addLOP(LeaveApplicationTO leave) throws ApplicationException;

}
