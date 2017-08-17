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
import com.hrms.model.ConveyanceTO;
import com.hrms.util.DbUtil;

public class ConveyanceDao implements Conveyance {
	private Connection connection;

	/**
	 * The Constant LOG.
	 * 
	 * @throws ClassNotFoundException
	 *             ,IOException,SQLException
	 * @throws SQLException
	 * @throws ApplicationException
	 */
	public static final Logger LOG = Logger.getLogger("ConveyanceDao");

	@Override
	public ConveyanceTO validateEmployee(ConveyanceTO conveyance)
			throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		LOG.info("Inside - method validateEmployee in ConveyanceDao class");
		ResultSet result = null;
		PreparedStatement statement = null;
		// CallableStatement callableStatement = null;

		try {
			connection = DbUtil.getConnection();
			int employeeId = conveyance.getEmployeeId();
			statement = connection
					.prepareStatement(QueryConstants.VALIDATEEMPLOYEEQUERY);
			statement.setInt(1, employeeId);
			result = statement.executeQuery();
			while (result.next()) {
				conveyance.setEmpName(result.getString(2));
				conveyance.setFlag(1);// to check if the employee data exists
										// against the given id
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseOperationException(e);
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
				throw new DatabaseOperationException("SQL Exception happened",
						e);

			}

		}
		LOG.info("Exit - method validateEmployee in ConveyanceDao class");
		return conveyance;

	}

	// method for entering conveyance data by employee
	//
	//
	public int setConveyanceDetails(ConveyanceTO conveyance)
			throws DatabaseOperationException, ApplicationException {
		int result = 0;
		PreparedStatement statement = null;
		LOG.info("Inside - method setConveyanceDetails in ConveyanceDao class");
		try {
			connection = DbUtil.getConnection();

			int employeeId = conveyance.getEmployeeId();
			statement = connection
					.prepareStatement(QueryConstants.SETCONVEYANCEQUERY);
			statement.setInt(1, employeeId);
			// point to be noted
			String date1 = new SimpleDateFormat("dd-MMM-YYYY")
					.format(new java.sql.Date(conveyance.getDocumentDate()
							.getTime()));

			statement.setString(2, date1);
			// statement.setString(2, date2);
			statement.setString(3, conveyance.getSource());
			statement.setString(4, conveyance.getDestination());
			statement.setString(5, conveyance.getParticulars());
			statement.setInt(6, conveyance.getNoOfDays());
			statement.setString(7, conveyance.getModeOfTravel());
			statement.setInt(8, conveyance.getDistance());
			statement.setDouble(9, conveyance.getAmount());
			result = statement.executeUpdate();
			LOG.info("Exit - method setConveyanceDetails in ConveyanceDao class");
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
		return result;
	}

}
