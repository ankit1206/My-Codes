package com.hrms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrms.bo.LeaveApplicationBO;
import com.hrms.constants.ErrorConstants;
import com.hrms.constants.SuccessConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.LeaveApplicationTO;
import com.hrms.util.PropertyUtil;

/**
 * Servlet implementation class LeaveApplicationController
 */
public class LeaveApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeaveApplicationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final Logger LOG = Logger
			.getLogger("LeaveApplicationController");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("Inside post method of LeaveApplicationController");
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);
		} else {
			LeaveApplicationTO leave = new LeaveApplicationTO();
			leave.setEmployeeId(Integer.parseInt(request
					.getParameter("employeeId")));
			try {
				leave.setFromDate(new SimpleDateFormat("dd/MM/yyyy")
						.parse(request.getParameter("fromDate")));
				leave.setToDate(new SimpleDateFormat("dd/MM/yyyy")
						.parse(request.getParameter("toDate")));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			final LeaveApplicationBO leaveApplicationBO = new LeaveApplicationBO();
			try {
				leave = leaveApplicationBO.validateEmployee(leave);
				String message = "Leave for "
						+ leave.getEmployeeName()
						+ " on "
						+ new SimpleDateFormat("dd/MM/yyyy").format(leave
								.getFromDate());
				if (leave.getResult() == 1) {
					message = message + " is approved with Loss of pay.";

				} else {
					message = message + " without loss of pay";
				}
				request.setAttribute("message", message);
				LOG.info("Exit post method of LeaveApplicationController");
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(SuccessConstants.SUCCESSPAGE);
				dispatcher.forward(request, response);
			} catch (BusinessException e) {
				LOG.error("Exception occured while logging", e.getCause());
				request.setAttribute("message", e.getMessage());
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.LEAVEPAGE);
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
