package com.hrms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hrms.constants.QueryConstants;
import com.hrms.exceptions.ApplicationException;
import com.hrms.exceptions.DatabaseOperationException;
import com.hrms.model.RegistrationTO;
import com.hrms.util.DbUtil;

public class RegistrationDao implements Registration {

	private Connection connection;
	PreparedStatement prepareStatement = null;
	int updateRecords = 0;
	public static final Logger LOG = Logger.getLogger("RegistrationDAO");

	public int addEmp(RegistrationTO employee)
			throws DatabaseOperationException, ApplicationException {
		LOG.info("Method addEmp  Invoked in RegisterDAO");
		try {
			connection = DbUtil.getConnection();
			prepareStatement = connection
					.prepareStatement(QueryConstants.REGISTRATIONQUERY);

			prepareStatement.setString(1, employee.getEmployeeName());
			prepareStatement.setString(2, employee.getGender());
			prepareStatement.setDate(3, employee.getEmployeeDOB());
			prepareStatement.setDate(4, employee.getEmployeeDOJ());
			prepareStatement.setDouble(5, employee.getEmployeeContactNo());
			prepareStatement.setString(6, employee.getEmployeeBankAccountNo());
			prepareStatement.setString(7, employee.getEmployeePanNo());
			prepareStatement.setString(8, employee.getEmployeeEmailId());
			prepareStatement.setString(9, employee.getEmployeeAddress());
			prepareStatement.setString(10, employee.getEmployeeDesignation());
			prepareStatement.setString(11, employee.getEmployeeDomain());
			prepareStatement.setInt(12, employee.getEmployeeMaxExperiance());
			prepareStatement.setFloat(13, employee.getEmployeeBasicSalary());
			updateRecords = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error("Exception occured when processing:" + e.getCause());
			throw new DatabaseOperationException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOG.error("Exception occured when processing:" + e.getCause());
			throw new ApplicationException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("Exception occured when processing:" + e.getCause());
			throw new ApplicationException(e);
		} finally {

			try {
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DatabaseOperationException(e);
			}
		}
		return updateRecords;
	}

	public boolean checkEmail(String email) throws DatabaseOperationException,
			ApplicationException {
		boolean check = false;
		LOG.info("Method checkMail Invoked in RegisterDAO");
		List<String> list = new ArrayList<String>();
		try {
			connection = DbUtil.getConnection();
			prepareStatement = connection
					.prepareStatement(QueryConstants.CHECKEMAIL);
			prepareStatement.setString(1, email);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("Email_ID"));
			}
			if (list.size() > 0) {
				check = false;
			} else {
				check = true;
			}
		} catch (SQLException e) {
			LOG.error("Exception occured when processing:" + e.getCause());
			throw new DatabaseOperationException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOG.error("Exception occured when processing:" + e.getCause());
			throw new ApplicationException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("Exception occured when processing:" + e.getCause());
			throw new ApplicationException(e);
		} finally {

			try {
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DatabaseOperationException(e);
			}
		}

		return check;
	}

}
