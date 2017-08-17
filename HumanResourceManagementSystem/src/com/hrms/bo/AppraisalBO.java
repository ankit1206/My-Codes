package com.hrms.bo;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.hrms.constants.ErrorConstants;
import com.hrms.dao.Appraisal;
import com.hrms.dao.AppraisalDao;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.AppraisalTO;
import com.hrms.util.PropertyUtil;

public class AppraisalBO {
	Appraisal userDao = new AppraisalDao();
	int basic;

	public static final Logger LOG = Logger.getLogger("AppraisalBO");

	public AppraisalTO validateUser(AppraisalTO userTO)
			throws DatabaseOperationException, ApplicationException,
			BusinessException {
		LOG.info("Inside:validateUser of AppraisalBO");
		userTO = userDao.getUserDetails(userTO);
		if (userTO.getResult() == 0) {
			String message = PropertyUtil
					.getErrorMessage(ErrorConstants.INVALIDEMPID);
			throw new BusinessException(message);
		}
		basic = userTO.getBasic();
		return userTO;
	}

	public AppraisalTO calculateAppraisal(AppraisalTO userTO)
			throws DatabaseOperationException, ApplicationException {
		String status = "";
		String status1 = "";
		Date currDate = new Date();
		Date startDate = userTO.getStartDate();
		Date certDate = userTO.getCertDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currDate);
		int currMonth = calendar.get(Calendar.MONTH);
		int currYear = calendar.get(Calendar.YEAR);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(startDate);
		int startMonth = calendar1.get(Calendar.MONTH);
		int startYear = calendar1.get(Calendar.YEAR);
		if (Math.abs(((currYear - startYear) * 12) + (currMonth - startMonth)) >= 3) {
			status = "c";
		} else {
			status = "p";
		}
		userTO = userDao.putAppraisalDetails(userTO);
		int test = userTO.getTestReport();

		calendar1.setTime(certDate);
		int certMonth = calendar1.get(Calendar.MONTH);
		int certYear = calendar1.get(Calendar.YEAR);
		if (Math.abs(((currYear - certYear) * 12) + (currMonth - certMonth)) <= 6) {
			status1 = "c";
		} else {
			status1 = "p";
		}

		if ((test >= 80 && test < 100) && "c".equals(status)
				&& "c".equals(status1)) {
			basic = basic + (int) ((double) basic * 0.5);
		} else if ((test >= 60 && test < 80) && "c".equals(status)
				&& "c".equals(status1)) {
			basic = basic + (int) ((double) basic * 0.25);
		}
		userTO.setBasic(basic);
		userDao.putBasicDetails(userTO);
		LOG.info("Exit:validateUser of AppraisalBO");
		return userTO;

	}
}
