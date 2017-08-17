package com.hrms.dao;

import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.PaySlipTO;

public interface PaySlip {

	public PaySlipTO checkUser(PaySlipTO paySlipTO)
			throws ApplicationException, DatabaseOperationException;

}
