package com.hrms.dao;

import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.AppraisalTO;

public interface Appraisal {
	public AppraisalTO getUserDetails(final AppraisalTO user)
			throws DatabaseOperationException, ApplicationException /*
																	 * throws
																	 * ApplicationException
																	 */;

	public AppraisalTO putAppraisalDetails(final AppraisalTO user)
			throws DatabaseOperationException, ApplicationException /*
																	 * throws
																	 * ApplicationException
																	 */;

	public AppraisalTO putBasicDetails(final AppraisalTO user)
			throws DatabaseOperationException, ApplicationException;
}
