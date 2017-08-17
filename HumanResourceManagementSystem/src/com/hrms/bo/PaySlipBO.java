package com.hrms.bo;

import org.apache.log4j.Logger;

import com.hrms.constants.ErrorConstants;
import com.hrms.dao.PaySlip;
import com.hrms.dao.PaySlipDao;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.PaySlipTO;
import com.hrms.util.PropertyUtil;

public class PaySlipBO {

	PaySlip paySlipDao = new PaySlipDao();
	public static final Logger LOG = Logger.getLogger("PaySlipBO");
	public PaySlipTO validateEmployee(PaySlipTO paySlipTO)
			throws BusinessException, DatabaseOperationException,
			ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside:validateEmployee Method of PaySlipBO");
		paySlipDao.checkUser(paySlipTO);
		if (paySlipTO.getEmployeeName() == null) {
			throw new BusinessException(
					PropertyUtil
							.getErrorMessage(ErrorConstants.INVALIDEMPID));
		}
		LOG.info("Exit:validateEmployee Method of PaySlipBO");
		return paySlipTO;
	}

}
