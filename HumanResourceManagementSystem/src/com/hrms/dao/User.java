package com.hrms.dao;

import com.hrms.exceptions.ApplicationException;
import com.hrms.model.UserTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface Employee.
 */
public interface User {

	/**
	 * Gets the user details.
	 * 
	 * @param user
	 *            the user
	 * @return the user details
	 * @throws ApplicationException
	 *             the application exception
	 */
	public UserTO getUserDetails(final UserTO user) throws ApplicationException;

}
