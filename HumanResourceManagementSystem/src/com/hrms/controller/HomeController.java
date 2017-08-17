package com.hrms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.constants.SuccessConstants;

/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
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
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {
			String page = request.getParameter("page");
			RequestDispatcher dispatch = null;
			if ("register".equals(page)) {
				dispatch = request
						.getRequestDispatcher(SuccessConstants.REGISTRATIONPAGE);
			}
			if ("appraisal".equals(page)) {
				dispatch = request
						.getRequestDispatcher(SuccessConstants.APPRAISALPAGE);
			}
			if ("paySlip".equals(page)) {
				dispatch = request
						.getRequestDispatcher(SuccessConstants.SLIPGENPAGE);
			}
			if ("conveyance".equals(page)) {
				dispatch = request
						.getRequestDispatcher(SuccessConstants.CONVEYANCEPAGE);
			}
			if ("leave".equals(page)) {
				dispatch = request
						.getRequestDispatcher(SuccessConstants.LEAVEPAGE);
			}
			dispatch.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
