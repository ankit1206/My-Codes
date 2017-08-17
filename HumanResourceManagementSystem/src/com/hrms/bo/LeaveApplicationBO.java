package com.hrms.bo;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.hrms.constants.ErrorConstants;
import com.hrms.dao.LeaveApplication;
import com.hrms.dao.LeaveApplicationDao;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.LeaveApplicationTO;
import com.hrms.util.PropertyUtil;

public class LeaveApplicationBO {

	LeaveApplication leaveDao = new LeaveApplicationDao();
	public static final Logger LOG = Logger.getLogger("LeaveApplicationBO");

	public LeaveApplicationTO validateEmployee(LeaveApplicationTO leave)
			throws DatabaseOperationException, ApplicationException,
			BusinessException {
		// TODO Auto-generated method stub
		LOG.info("Inside:validateEmployee Method of LeaveApplicationBO");
		int response;
		leaveDao.checkUser(leave);
		if (leave.getResult() == 0) {
			String message = PropertyUtil
					.getErrorMessage(ErrorConstants.INVALIDEMPID);
			throw new BusinessException(message);
		}
		Date DOJ = leave.getDOJ();
		Date currDate = new Date();
		Date fromDate = leave.getFromDate();
		Date toDate = leave.getToDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(DOJ);
		/* cal.add(Calendar.DAY_OF_YEAR, amount) */
		long dojSec = cal.getTimeInMillis();
		cal.setTime(currDate);
		long currSec = cal.getTimeInMillis();
		int time = (int) ((currSec - dojSec) / (1000 * 60 * 60 * 24 * 365));
		cal.setTime(fromDate);
		long fromSec = cal.getTimeInMillis();
		cal.setTime(toDate);
		long toSec = cal.getTimeInMillis();
		int daysLeave = (int) ((toSec - fromSec) / (1000 * 60 * 60 * 24));
		int takenLeave = leave.getLeaveTaken();
		int lossOfPay;
		if (time > 2) {
			lossOfPay = -(leave.getCasualLeave() + 3 - daysLeave - takenLeave);
		} else {
			lossOfPay = -(leave.getCasualLeave() - daysLeave - takenLeave);
		}
		leave.setLeaveTaken(takenLeave + daysLeave);
		if (lossOfPay > 0) {
			response = 1;
			leave.setLossOfPay(lossOfPay);
			leaveDao.addLOP(leave);
		} else {
			response = 0;
			leave.setLossOfPay(0);
			leaveDao.addLOP(leave);
		}
		if (leave.getResult() < 1) {
			String message = "Leave not added successfully.. Please try again";
			throw new BusinessException(message);
		}
		LOG.info("Exit:validateEmployee Method of LeaveApplicationBO");
		leave.setResult(response);
		return leave;
	}

}
