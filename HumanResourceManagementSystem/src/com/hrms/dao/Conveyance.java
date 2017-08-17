package com.hrms.dao;

import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.ConveyanceTO;

public interface Conveyance {
	// public ConveyanceTO getConveyanceDetails(ConveyanceTO conveyance) throws
	// SQLException;
	public int setConveyanceDetails(ConveyanceTO conveyance)
			throws DatabaseOperationException, ApplicationException;

	public ConveyanceTO validateEmployee(ConveyanceTO conveyance)
			throws DatabaseOperationException, ApplicationException;
}
