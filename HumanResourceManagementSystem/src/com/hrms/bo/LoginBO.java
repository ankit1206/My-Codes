package com.hrms.bo;

import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;

/*import org.apache.log4j.Logger;*/

import com.hrms.constants.ErrorConstants;
import com.hrms.dao.User;
import com.hrms.dao.UserDao;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.UserTO;
import com.hrms.util.PropertyUtil;

/**
 * The LoginBO class contains the logic for validating the user's login
 * 
 * @author t-Renjith
 */
public class LoginBO {
	/**
	 * The log object used for logging the error and info
	 */
	User userDao = new UserDao();
	public static final Logger LOG = Logger.getLogger("LoginBO");

	/*
	 * public static final Logger LOG = Logger.getLogger("LoginBO");
	 */
	/**
	 * @param user
	 *            -The UserVO object which contains the user details
	 * @return true if no exception is thrown
	 * @throws ApplicationException
	 * @throws LoginBusinessException
	 *             -Thrown when the login fails
	 * @throws LoginException
	 *             -Thrown in case of any fatal exception occurring in the
	 *             system
	 */
	public UserTO validateUser(UserTO userTO) throws BusinessException,
			DatabaseOperationException, ApplicationException {

		String message = null;// Variable used for storing the messages.
		LOG.info("Method Validate User Invoked" + userTO);
		userDao.getUserDetails(userTO);

		if (userTO.getResult() == 0) {
			message = PropertyUtil
					.getErrorMessage(ErrorConstants.INVALIDUSERNAME);
			// LOG.debug("Message" + message);
			throw new BusinessException(message);
		} else if (userTO.getResult() == 1) {
			message = PropertyUtil
					.getErrorMessage(ErrorConstants.INVALIDPASSWORD);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
		LOG.info("Validate User: Response true");
		return userTO;
	}
}
