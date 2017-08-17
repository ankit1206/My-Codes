package com.hrms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.hrms.constants.QueryConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.PaySlipTO;
import com.hrms.util.DbUtil;

public class PaySlipDao implements PaySlip {

	private Connection connection;
	 public static final Logger LOG = Logger.getLogger("PaySlipDao");
	@Override
	public PaySlipTO checkUser(PaySlipTO paySlipTO)
			throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside - method checkUser in PaySlipDao class");
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection
					.prepareStatement(QueryConstants.PAYSLIPQUERY);
			statement.setInt(1, paySlipTO.getEmployeeId());
			result = statement.executeQuery();

			if (result.next()) {
				paySlipTO.setEmployeeName(result.getString(1));
				paySlipTO.setBankAccNo(result.getString(2));
				paySlipTO.setPanNo(result.getString(3));
				paySlipTO.setDesignation(result.getString(4));
				paySlipTO.setRank(result.getString(5));
				paySlipTO.setBasicSalary(result.getLong(6));
				paySlipTO.setHra(result.getInt(7));
				paySlipTO.setPf(result.getInt(8));
				paySlipTO.setPayLoss(result.getInt(9));
			}
		} catch (SQLException e) {
			throw new DatabaseOperationException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
				if (result != null) {
					result.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DatabaseOperationException(e);
			}

		}
		LOG.info("Exit - method checkUser in PaySlipDao class");
		return paySlipTO;
	}

}
