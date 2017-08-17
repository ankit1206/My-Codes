package com.hrms.dao;

import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.RegistrationTO;

public interface Registration {
	public int addEmp(RegistrationTO employee)
			throws DatabaseOperationException, ApplicationException;
}
