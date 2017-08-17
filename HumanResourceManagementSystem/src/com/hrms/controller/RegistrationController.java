package com.hrms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrms.bo.RegistrationBO;
import com.hrms.constants.ErrorConstants;
import com.hrms.constants.SuccessConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.RegistrationTO;
import com.hrms.util.PropertyUtil;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public static final Logger LOG = Logger.getLogger("RegistrationController");

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);
		} else {
			LOG.info("Session Created in post");
			try {
				RegistrationTO employee = new RegistrationTO();
				RegistrationBO register = new RegistrationBO();
				RequestDispatcher dispatch = null;
				final String email = request.getParameter("email");
				register.checkEmail(email);
				employee.setEmployeeName(request.getParameter("name"));
				employee.setGender(request.getParameter("Gender"));
				employee.setEmployeeDOB(register.dateParse(request
						.getParameter("dob")));
				employee.setEmployeeDOJ(register.dateParse(request
						.getParameter("doj")));
				employee.setEmployeeContactNo(Double.parseDouble(request
						.getParameter("contactno")));
				employee.setEmployeeBankAccountNo(request
						.getParameter("bankac"));
				employee.setEmployeePanNo(request.getParameter("panno"));
				employee.setEmployeeEmailId(email);
				employee.setEmployeeAddress(register.appendString(
						request.getParameter("address"),
						request.getParameter("state"),
						request.getParameter("country")));
				employee.setEmployeeDesignation(request
						.getParameter("designation"));
				employee.setEmployeeMaxExperiance(register
						.CalculateAge(employee.getEmployeeDOB()) - 22);
				employee.setEmployeeDomain(request.getParameter("domain"));
				employee.setEmployeeBasicSalary(Float.parseFloat(request
						.getParameter("salary")));
				register.addEmp(employee);
				LOG.info("Employee registered Successfully");
				String message = PropertyUtil
						.getSuccessMessage(SuccessConstants.REGISTRATIONSUCCESS);
				request.setAttribute("message", message);
				dispatch = request
						.getRequestDispatcher(SuccessConstants.SUCCESSPAGE);
				LOG.info("Exit from Registration Controller");
				dispatch.forward(request, response);
			} catch (BusinessException e) {
				LOG.error("Exception occured while logging", e.getCause());
				request.setAttribute("message", e.getMessage());
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.REGISTRATIONPAGE);
				dispatcher.forward(request, response);
			} catch (DatabaseOperationException e) {
				// TODO Auto-generated catch block
				LOG.error("Exception occured while logging", e.getCause());
				request.setAttribute("message",
						PropertyUtil.getErrorMessage(ErrorConstants.FATALERROR));
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.ERRORPAGE);
				dispatcher.forward(request, response);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				LOG.error("Exception occured while logging", e.getCause());
				request.setAttribute("message",
						PropertyUtil.getErrorMessage(ErrorConstants.FATALERROR));
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.ERRORPAGE);
				dispatcher.forward(request, response);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				LOG.error("Exception occured while logging",
						exception.getCause());
				request.setAttribute("message",
						PropertyUtil.getErrorMessage(ErrorConstants.FATALERROR));
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.ERRORPAGE);
				dispatcher.forward(request, response);
			}
		}
	}
}
