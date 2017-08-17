package com.hrms.bo;

import org.apache.log4j.Logger;

import com.hrms.dao.Conveyance;
import com.hrms.dao.ConveyanceDao;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.ConveyanceTO;

public class ConveyanceBO {
	Conveyance conveyanceDao = new ConveyanceDao();
	public static final Logger LOG = Logger.getLogger("ConveyanceBO");

	// ConveyanceTO
	/*
	 * public ConveyanceTO getConveyanceDetails(ConveyanceTO conveyance) throws
	 * SQLException { ConveyanceTO
	 * retrievedConveyance=conveyanceObj.getConveyanceDetails(conveyance);
	 * return retrievedConveyance; }
	 */
	public int setConveyanceDetails(ConveyanceTO conveyance)
			throws DatabaseOperationException, ApplicationException {
		LOG.info("Inside:setConveyanceDetails Method of ConveyanceBO");
		int noOfDays = conveyance.getNoOfDays();
		int result = 0;
		if (noOfDays > 30) {
			conveyance.setMessage("No Of Days should be less than 30");
			result = 9;
		} else {
			result = conveyanceDao.setConveyanceDetails(conveyance);
		}
		LOG.info("Exit:setConveyanceDetails Method of ConveyanceBO");
		return result;
	}

	public ConveyanceTO validateEmployee(ConveyanceTO conveyance)
			throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside:validateEmployee Method of ConveyanceBO");
		ConveyanceTO retrievedConveyance = conveyanceDao
				.validateEmployee(conveyance);
		LOG.info("Exit:validateEmployee Method of ConveyanceBO");
		return retrievedConveyance;
	}

}
