package com.hrms.constants;

public final class SuccessConstants {

	private SuccessConstants() {
		new SuccessConstants();
	}

	/**
	 * The success messages property file name
	 */
	public static final String SUCCESSMESSAGES = "successmessages";

	// Pages on successfully completion
	public static final String SUCCESSPAGE = "/WEB-INF/success.jsp";

	public static final String LOGINSUCCESSPAGE = "/WEB-INF/home.jsp";

	public static final String ADDCONVEYANCE = "/WEB-INF/AddConveyance.jsp";

	public static final String APPRAISALSUBMITPAGE = "/WEB-INF/Appraisal.jsp";

	public static final String REGISTRATIONPAGE = "/WEB-INF/register.jsp";

	public static final String APPRAISALPAGE = "/WEB-INF/Search.jsp";

	public static final String SLIPGENPAGE = "/WEB-INF/paySlipGeneration.jsp";

	public static final String CONVEYANCEPAGE = "/WEB-INF/AdminConveyance.jsp";

	public static final String LEAVEPAGE = "/WEB-INF/Leave.jsp";

	// Message on success page
	public static final String REGISTRATIONSUCCESS = "100";

	public static final String APPRAISALSUCCESS = "101";

	public static final String CONVEYANCESUCCESS = "102";

	// LOG4J_FILE configuration file
	public static final String LOG4J_FILE = "/WEB-INF/log4j.properties";
}
