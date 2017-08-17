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

import com.hrms.bo.ConveyanceBO;
import com.hrms.constants.ErrorConstants;
import com.hrms.constants.SuccessConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.ConveyanceTO;
import com.hrms.util.PropertyUtil;

/**
 * Servlet implementation class ConveyanceController
 */
public class ConveyanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConveyanceBO conveyanceBOobj = new ConveyanceBO();
	ConveyanceTO conveyance = new ConveyanceTO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConveyanceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final Logger LOG = Logger.getLogger("ConveyanceController");

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
		LOG.info("Inside post method of ConveyenceController");
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);
		} else {
			String action = request.getParameter("action");
			if ("search".equals(action)) {
				LOG.info("action = search");
				conveyance.setEmployeeId(Integer.parseInt(request
						.getParameter("employeeId")));
				ConveyanceTO conveyanceObj;
				conveyance.setFlag(0);

				try {
					RequestDispatcher rd = null;
					conveyanceObj = conveyanceBOobj
							.validateEmployee(conveyance);
					if (conveyanceObj.getFlag() == 1) {
						request.setAttribute("conveyanceObj", conveyanceObj);
						rd = request
								.getRequestDispatcher(SuccessConstants.ADDCONVEYANCE);

					} else {
						LOG.info("Employee not found");
						conveyanceObj.setMessage("Employee doesn't exist");
						request.setAttribute("conveyanceObj", conveyanceObj);
						rd = request
								.getRequestDispatcher(ErrorConstants.CONVEYANCEPAGE);
					}
					request.setAttribute("conveyanceObj", conveyanceObj);
					rd.forward(request, response);
				} catch (DatabaseOperationException e) {
					// TODO Auto-generated catch block
					LOG.error("Exception occured while logging", e.getCause());
					request.setAttribute("message", PropertyUtil
							.getErrorMessage(ErrorConstants.FATALERROR));

					final RequestDispatcher rd = request
							.getRequestDispatcher(ErrorConstants.ERRORPAGE);
					rd.forward(request, response);
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					LOG.error("Exception occured while logging", e.getCause());
					request.setAttribute("message", PropertyUtil
							.getErrorMessage(ErrorConstants.FATALERROR));

					final RequestDispatcher rd = request
							.getRequestDispatcher(ErrorConstants.ERRORPAGE);
					rd.forward(request, response);
				}

			} else {
				LOG.info("action = ADD");
				RequestDispatcher rd = null;
				conveyance.setEmployeeId(Integer.parseInt(request
						.getParameter("employeeId")));
				String docDate = request.getParameter("documentDate");
				//
				//
				// check for different method of date conversion
				Date date1 = null;
				try {
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(docDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				conveyance.setDocumentDate(date1);
				conveyance.setSource(request.getParameter("source"));
				conveyance.setDestination(request.getParameter("destination"));
				conveyance.setParticulars(request.getParameter("particulars"));
				conveyance.setNoOfDays(Integer.parseInt(request
						.getParameter("noOfDays")));
				conveyance
						.setModeOfTravel(request.getParameter("modeOfTravel"));
				conveyance.setDistance(Integer.parseInt(request
						.getParameter("distance")));
				conveyance.setAmount(Integer.parseInt(request
						.getParameter("amount")));

				int result;
				try {
					result = conveyanceBOobj.setConveyanceDetails(conveyance);
					// request.setAttribute("conveyanceObj", conveyanceObj);
					if (result == 9) {
						rd = request
								.getRequestDispatcher(ErrorConstants.ADDCONVEYANCE);
					} else {
						request.setAttribute(
								"message",
								PropertyUtil
										.getSuccessMessage(SuccessConstants.CONVEYANCESUCCESS));
						rd = request
								.getRequestDispatcher(SuccessConstants.SUCCESSPAGE);
					}
				} catch (DatabaseOperationException e) {
					// TODO Auto-generated catch block
					LOG.error("Exception occured while logging", e.getCause());
					request.setAttribute("message", PropertyUtil
							.getErrorMessage(ErrorConstants.FATALERROR));

					final RequestDispatcher rd1 = request
							.getRequestDispatcher(ErrorConstants.ERRORPAGE);
					rd1.forward(request, response);
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					LOG.error("Exception occured while logging", e.getCause());
					request.setAttribute("message", PropertyUtil
							.getErrorMessage(ErrorConstants.FATALERROR));

					final RequestDispatcher rd1 = request
							.getRequestDispatcher(ErrorConstants.ERRORPAGE);
					rd1.forward(request, response);
				}
				// request.setAttribute("conveyanceObj", conveyanceObj);
				LOG.info("EXIT:from ConveyanceController ");
				rd.forward(request, response);
			}

		}
	}
}
