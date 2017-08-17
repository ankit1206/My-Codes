package com.hrms.bo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.hrms.constants.ErrorConstants;
import com.hrms.dao.RegistrationDao;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.BusinessException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.RegistrationTO;
import com.hrms.util.PropertyUtil;

public class RegistrationBO {

	RegistrationDao register = new RegistrationDao();
	public static final Logger LOG = Logger.getLogger("RegistrationBO");

	public void addEmp(RegistrationTO employee)
			throws DatabaseOperationException, ApplicationException,
			BusinessException {
		LOG.info("Method addEmp  Invoked in RegisterBO");
		int result = register.addEmp(employee);
		if (result < 1) {
			String message = PropertyUtil
					.getErrorMessage(ErrorConstants.REGISTRATIONFAIL);
			throw new BusinessException(message);
		}
	}

	public String appendString(String address, String state, String country) {
		LOG.info("Method appendString  Invoked in RegisterBO");
		StringBuffer stbuf = new StringBuffer(address);
		stbuf.append("," + state + "," + country);
		return stbuf.toString();
	}

	public Date dateParse(String date) {
		LOG.info("Method DateParse Invoked in RegisterBO");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date sql = new Date(parsed.getTime());
		return sql;
	}

	public int CalculateAge(java.sql.Date DOB) {
		LOG.info("Method CalculateAge  Invoked in RegisterBO");
		Calendar cal = new GregorianCalendar();
		cal.setTime(DOB);

		Calendar current = new GregorianCalendar();

		int age = current.get(Calendar.YEAR) - cal.get(Calendar.YEAR);

		boolean isMonthGreater = cal.get(Calendar.MONTH) >= current
				.get(Calendar.MONTH);

		boolean isMonthSameButDayGreater = cal.get(Calendar.MONTH) == current
				.get(Calendar.MONTH)
				&& cal.get(Calendar.DAY_OF_MONTH) > current
						.get(Calendar.DAY_OF_MONTH);

		if (isMonthGreater || isMonthSameButDayGreater) {
			age = age - 1;
		}

		return age;

	}

	public void checkEmail(String email) throws DatabaseOperationException,
			ApplicationException, BusinessException {
		LOG.info("Method checkMail  Invoked in RegisterBO");
		boolean check = register.checkEmail(email);
		if (!check) {
			String message = PropertyUtil
					.getErrorMessage(ErrorConstants.INVALIDEMAIL);
			throw new BusinessException(message);
		}
	}
}
