package com.hrms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrms.bo.LoginBO;
import com.hrms.constants.ErrorConstants;
import com.hrms.constants.SuccessConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.UserTO;
import com.hrms.util.PropertyUtil;

/**
 * Servlet implementation class LoginServlet This Servlet acts as the controller
 * for the login process.This is called when the user submits the login.jsp
 * page.
 */
public class LoginController extends HttpServlet {
	/**
	 * serialVersionUID value for the serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Logger for logging the errors and info
	 */

	// Logger object used for logging the errors and info
	public static final Logger LOG = Logger.getLogger("LoginController");

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		UserTO user = new UserTO();
		final String userid = request.getParameter("loginid");// Username
																// entered
		// by the user in the login page
		final String passWord = request.getParameter("password");// Password
																	// entered
		// by the user in the login page
		user.setUserid(userid);
		user.setPassword(passWord);
		LOG.info("Login servlet invoked UserName:" + userid);
		/*
		 * LOG.info("Login servlet invoked UserName:" + userid + "Password:" +
		 * passWord);
		 */
		HttpSession session = request.getSession(true);

		final LoginBO logic = new LoginBO();// Creates an Object of LoginBO
		try {
			user = logic.validateUser(user);// Calls the validateUser method of
											// the

			session.setAttribute("UserID", user.getUserid());

			RequestDispatcher dispatcher = request
					.getRequestDispatcher(SuccessConstants.LOGINSUCCESSPAGE);
			dispatcher.forward(request, response); // forwards the request to
			// implementation.jsp since the user has successfully logged in

		} catch (BusinessException businessException) {
			/*
			 * LOG.error("Exception occured while logging",
			 * businessException.getCause());
			 */
			LOG.error("Exception occured while logging",
					businessException.getCause());
			request.setAttribute("message", businessException.getMessage());// Sets
																			// the
																			// message
			// as attribute to the request
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.LOGINPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (DatabaseOperationException databaseOperationException) {// Handles
																			// the
																			// LoginExceptions
																			// and
																			// log
																			// the
			// errors into the Log
			request.setAttribute("message",
					PropertyUtil.getErrorMessage(ErrorConstants.FATALERROR));
			/*
			 * LOG.error("Exception occured when processing validate user:" +
			 * databaseOperationException.getCause());
			 */
			LOG.error("Exception occured when processing validate user:"
					+ databaseOperationException.getCause());
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		} catch (ApplicationException applicationException) {
			// TODO Auto-generated catch block
			request.setAttribute("message", "Fatal Error");
			/*
			 * LOG.error("Exception occured when processing validate user:" +
			 * applicationException.getCause());
			 */
			LOG.error("Exception occured when processing validate user:"
					+ applicationException.getCause());
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			request.setAttribute("message", "Fatal Error");
			/*
			 * LOG.error("Exception occured when processing validate user:" +
			 * exception.getCause());
			 */
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			LOG.error("Exception occured when processing validate user:"
					+ exception.getCause());
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = req.getRequestDispatcher("login.jsp");

			dispatcher.forward(req, resp);
		}
	}

}
