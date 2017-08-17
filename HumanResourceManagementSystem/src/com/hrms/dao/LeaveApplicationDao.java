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
import com.hrms.model.LeaveApplicationTO;
import com.hrms.util.DbUtil;

public class LeaveApplicationDao implements LeaveApplication {

	private Connection connection;
	public static final Logger LOG = Logger.getLogger("LeaveApplicationDao");

	@Override
	public LeaveApplicationTO checkUser(LeaveApplicationTO leave)
			throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside - method checkUser in LeaveApplicationDao class");
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection
					.prepareStatement(QueryConstants.LEAVEAPPQUERY);
			statement.setInt(1, leave.getEmployeeId());
			result = statement.executeQuery();

			if (result.next()) {
				leave.setEmployeeName(result.getString(4));
				leave.setDOJ(result.getDate(3));
				leave.setCasualLeave(result.getInt(1));
				leave.setLeaveTaken(result.getInt(2));
				leave.setResult(1);
			} else {
				leave.setResult(0);
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
		LOG.info("Exit - method checkUser in LeaveApplicationDao class");
		return leave;
	}

	@Override
	public void addLOP(LeaveApplicationTO leave) throws ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside - method addLOP in LeaveApplicationDao class");
		int result;
		PreparedStatement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(QueryConstants.ADDLOPQUERY);
			statement.setInt(1, leave.getLossOfPay());
			statement.setInt(2, leave.getLeaveTaken());
			statement.setInt(3, leave.getEmployeeId());
			result = statement.executeUpdate();
			leave.setResult(result);
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
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DatabaseOperationException(e);
			}

		}
		LOG.info("Exit - method addLOP in LeaveApplicationDao class");
	}
}
