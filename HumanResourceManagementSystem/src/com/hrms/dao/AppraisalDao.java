package com.hrms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.hrms.constants.QueryConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.AppraisalTO;
import com.hrms.util.DbUtil;

public class AppraisalDao implements Appraisal {
	private Connection connection;

	public static final Logger LOG = Logger.getLogger("AppraisalDao");

	public AppraisalTO getUserDetails(AppraisalTO user)
			throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside - method getUserDetails in AppraisalDao class");
		ResultSet result = null;
		PreparedStatement statement = null;

		try {
			connection = DbUtil.getConnection();
			int userId = 0;
			String empName = null;
			String empDomain = null;
			String empDesign = null;
			int Basic = 0;

			statement = connection
					.prepareStatement(QueryConstants.EMPLOYEEQUERY);
			if (user != null) {
				statement.setInt(1, user.getEmpId());
			}

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				userId = rs.getInt(1);
				empName = rs.getString(2);
				empDomain = rs.getString(3);
				empDesign = rs.getString(4);
				Basic = rs.getInt(5);
				user.setEmpId(userId);
				user.setEmpName(empName);
				user.setEmpDomain(empDomain);
				user.setEmpDesign(empDesign);
				user.setBasic(Basic);
				user.setResult(1);
			} else {
				user.setResult(0);
			}
			LOG.info("Exit - method getUserDetails in AppraisalDao class");
			// }
		} catch (SQLException e) {
			throw new DatabaseOperationException("An Error has occured", e);
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
				throw new DatabaseOperationException("SQL Exception happened",
						e);

			}

		}

		return user;
	}

	public AppraisalTO putAppraisalDetails(final AppraisalTO user)
			throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside - method putAppraisalDetails in AppraisalDao class");
		int result = 0;
		PreparedStatement statement = null;

		try {
			connection = DbUtil.getConnection();
			statement = connection
					.prepareStatement(QueryConstants.APPRAISALQUERY);
			int employeeId = user.getEmpId();
			statement.setInt(1, employeeId);
			String date2 = new SimpleDateFormat("dd-MMM-yyyy").format(user
					.getStartDate());
			statement.setString(2, user.getProjectName());
			statement.setString(3, date2);
			statement.setInt(4, user.getTestReport());
			statement.setString(5, "3");
			statement.setString(6, "3");
			statement.setString(7, user.getCertId());
			String date3 = new SimpleDateFormat("dd-MMM-yyyy").format(user
					.getCertDate());
			statement.setString(8, date3);
			statement.setString(9, user.getCertName());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseOperationException("An Error has occured", e);
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
				throw new DatabaseOperationException("SQL Exception happened",
						e);

			}

		}
		LOG.info("Exit - method putAppraisalDetails in AppraisalDao class");
		return user;
	}

	public AppraisalTO putBasicDetails(final AppraisalTO user)
			throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside - method putBasicDetails in AppraisalDao class");
		int result = 0;
		PreparedStatement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(QueryConstants.BASICQUERY);
			int employeeId = user.getEmpId();
			statement.setInt(2, employeeId);
			statement.setInt(1, user.getBasic());
			result = statement.executeUpdate();
			LOG.info("Exit - method putBasicDetails in AppraisalDao class");
		} catch (SQLException e) {
			throw new DatabaseOperationException("An Error has occured", e);
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
				throw new DatabaseOperationException("SQL Exception happened",
						e);

			}

		}
		return user;
	}
}
