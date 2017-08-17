package com.hrms.constants;

public final class QueryConstants {

	private QueryConstants() {
		new QueryConstants();
	}

	public static final String PAYSLIPQUERY = "Select e.employee_name, e.BankAc_No, e.Pan_No, e.Designation, d.Rank, e.Basic_Salary, p.HRA, p.PF, l.Pay_Loss "
			+ "from employee e "
			+ "join Designation_Rank d "
			+ "on d.designation=e.designation "
			+ "join Pay_Slip p "
			+ "on p.Rank=d.Rank "
			+ "join Leave l "
			+ "on e.employee_id=l.employee_id " + "where employee_id=?";

	public static final String LEAVEAPPQUERY = "Select p.casual_leave, l.leave_taken, e.DOJ, e.employee_name "
			+ "from employee e "
			+ "join Designation_Rank d "
			+ "on d.designation=e.designation "
			+ "join Pay_Slip p "
			+ "on p.Rank=d.Rank "
			+ "join Leave l "
			+ "on e.employee_id=l.employee_id " + "where e.employee_id=?";

	public static final String ADDLOPQUERY = "update Leave set pay_loss=?,leave_taken=? where Employee_Id=?";
	/*
	 * public static final String GETCONVEYANCEQUERY =
	 * "select c.Employee_Id, e.Employee_Name,c.Document_Date, c.Source, c.Destination,c.Particulars ,c.No_Of_Days,c.Mode_Of_Travel,  c.Distance,  c.Amount "
	 * + "from Conveyance c " + "join Employee e " +
	 * "on c.Employee_Id=e.Employee_Id " + "where c.Employee_Id=?";
	 */

	public static final String SETCONVEYANCEQUERY = "insert into conveyance "
			+ "values(conveyance_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";

	public static final String VALIDATEEMPLOYEEQUERY = "select Employee_Id,Employee_name from Employee where Employee_Id=?";

	public static final String EMPLOYEEQUERY = "select Employee_id,Employee_name,Domiam,Designation,Basic_Salary from Employee where Employee_id=?";

	public static final String APPRAISALQUERY = "insert into Appraisal values(?,ProjectId_seq.NEXTVAL,?,?,?,?,?,?,?,?)";

	public static final String BASICQUERY = "update Employee set Basic_Salary=? where Employee_id=?";

	public static final String REGISTRATIONQUERY = "insert into Employee values(EmployeeId_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String CHECKEMAIL = "select Email_ID from Employee where Email_ID= ?";

	public static final String CHECKLOGIN = "select * from login_master where Login_ID=?";
}
