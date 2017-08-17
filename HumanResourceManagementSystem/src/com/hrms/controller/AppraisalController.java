package com.hrms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrms.bo.AppraisalBO;
import com.hrms.constants.ErrorConstants;
import com.hrms.constants.SuccessConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.AppraisalTO;
import com.hrms.util.PropertyUtil;

/**
 * Servlet implementation class AppraisalController
 */
public class AppraisalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppraisalController() {
		super();
		// TODO Auto-generated constructor stub
	}

	AppraisalTO appraisal = new AppraisalTO();
	final AppraisalBO logic = new AppraisalBO();
	public static final Logger LOG = Logger.getLogger("AppraisalController");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);
		} else {
			LOG.info("Inside: get Method of AppraisalController");
			final String projectName = request.getParameter("projName");
			final String projectSdate = request.getParameter("projSdate");
			final String testingReport = request.getParameter("testReport");
			final String certId = request.getParameter("certId");
			final String certName = request.getParameter("certName");
			final String certDate = request.getParameter("certDate");
			final int TReport = Integer.parseInt(testingReport);
			appraisal.setProjectName(projectName);
			appraisal.setCertId(certId);
			appraisal.setCertName(certName);
			appraisal.setTestReport(TReport);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = null;
			try {
				startDate = new SimpleDateFormat("dd/MM/yyyy")
						.parse(projectSdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			appraisal.setStartDate(startDate);

			Date certiDate = null;
			try {
				certiDate = format.parse(certDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			appraisal.setCertDate(certiDate);
			try {
				appraisal = logic.calculateAppraisal(appraisal);
				request.setAttribute("message", PropertyUtil
						.getSuccessMessage(SuccessConstants.APPRAISALSUCCESS));
				LOG.info("Exit from Appraisal Controller get method");
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(SuccessConstants.SUCCESSPAGE);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);
		} else {
			LOG.info("Session in post");
			final String userid = request.getParameter("userid");
			int empid = Integer.parseInt(userid);
			appraisal.setEmpId(empid);
			// HttpSession session = request.getSession(true);

			try {
				appraisal = logic.validateUser(appraisal);

				session.setAttribute("UserID", appraisal.getEmpId());
				request.setAttribute("App", appraisal);
				LOG.info("Exit from Appraisal Controller post method");
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(SuccessConstants.APPRAISALSUBMITPAGE);
				dispatcher.forward(request, response);
			} catch (BusinessException e) {
				LOG.error("Exception occured while logging", e.getCause());
				request.setAttribute("message", e.getMessage());
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.APPRAISALPAGE);
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
