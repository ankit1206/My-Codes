package com.hrms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrms.bo.PaySlipBO;
import com.hrms.constants.ErrorConstants;
import com.hrms.constants.SuccessConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.PaySlipTO;
import com.hrms.util.PropertyUtil;

/**
 * Servlet implementation class PaySlipController
 */
public class PaySlipController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaySlipController() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	public static final Logger LOG = Logger.getLogger("PaySlipController");

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("Inside post method of PaySlipController");
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);
		} else {
			PaySlipTO paySlipTO = new PaySlipTO();
			paySlipTO.setEmployeeId(Integer.parseInt(request
					.getParameter("employeeId")));
			final PaySlipBO paySlipBO = new PaySlipBO();
			try {
				paySlipTO = paySlipBO.validateEmployee(paySlipTO);
				long basicSalary = paySlipTO.getBasicSalary();
				Double netAmount = (double) (basicSalary + paySlipTO.getHra()
						* basicSalary / 100 - paySlipTO.getPf() * basicSalary
						/ 100 - paySlipTO.getPayLoss() * basicSalary / 31);
				String file = "payslip_" + paySlipTO.getEmployeeId() + ".txt";
				PrintWriter writer = new PrintWriter("D:\\PaySlip\\" + file);
				writer.println("PAY SLIP FOR THE MONTH ____________");
				writer.println("Employee Id: " + paySlipTO.getEmployeeId());
				writer.println("Employee Name: " + paySlipTO.getEmployeeName());
				writer.println("Bank A/C No: " + paySlipTO.getBankAccNo());
				writer.println("PAN No: " + paySlipTO.getPanNo());
				writer.println("Designation: " + paySlipTO.getDesignation());
				writer.println("Rank: " + paySlipTO.getRank());
				writer.println("Basic Salary: " + paySlipTO.getBasicSalary());
				writer.println("HRA: " + paySlipTO.getHra());
				writer.println("PF:" + paySlipTO.getPf());
				writer.println("Number Of LOP Leaves: "
						+ paySlipTO.getPayLoss());
				writer.println("Net Amount: " + netAmount);
				request.setAttribute("paySlipTO", paySlipTO);
				request.setAttribute("netAmount", netAmount);
				String message = "Payslip for the employee "
						+ paySlipTO.getEmployeeName()
						+ " has been generated.\n"
						+ "Payslip will be available in the file " + file;
				request.setAttribute("message", message);
				LOG.info("Exit: from PaySlipController");
				RequestDispatcher dispatch = request
						.getRequestDispatcher(SuccessConstants.SUCCESSPAGE);
				dispatch.forward(request, response);
				writer.close();
			} catch (BusinessException businessException) {
				// TODO Auto-generated catch block
				LOG.error("Exception occured while logging",
						businessException.getCause());
				request.setAttribute("message", businessException.getMessage());// Sets
																				// the
																				// message
				// as attribute to the request
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.SLIPGENPAGE);
				dispatcher.forward(request, response);// forwards the request to
				// error.jsp in case of login failure or any exception
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
				request.setAttribute("message",
						PropertyUtil.getErrorMessage(ErrorConstants.FATALERROR));
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.ERRORPAGE);
				dispatcher.forward(request, response);
			}
		}
	}
}
