<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="com.hrms.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<title>Add Conveyance</title>
</head>

<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : 'dd/mm/yy',
			minDate : 0
		});
	});
</script>

<body>
	<form name="Conveyance" action="ConveyanceController?action=add"
		method="post">

		<table align="center" style="font-family: arial;">
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="employeeId"
					value=<%=((ConveyanceTO) request.getAttribute("conveyanceObj"))
					.getEmployeeId()%>
					readonly></td>
				<td>Employee Name</td>
				<td><input type="text" name="employeeName"
					value=<%=((ConveyanceTO) request.getAttribute("conveyanceObj"))
					.getEmpName()%>
					readonly></td>
			</tr>
			<tr>
				<td>Document Date</td>
				<td><input type="text" name="documentDate" id="datepicker"
					readonly></td>
				<td><font color="Red"><span id="docDateerror"></span></font></td>
			</tr>
			<tr>
				<td>From</td>
				<td>To</td>
				<td>Particulars</td>
				<td>Number Of Days</td>
				<td>Mode Of Travel</td>
				<td>Distance(km)</td>
				<td>Amount</td>
			</tr>
			<tr>
				<td><input type="text" name="source"><br> <font
					color="Red"><span id="fromerror"></span></font></td>
				<td><input type="text" name="destination"><br> <font
					color="Red"><span id="toerror"></span></font></td>
				<td><input type="text" name="particulars"><br> <font
					color="Red"><span id="parterror"></span></font></td>
				<td><input type="text" name="noOfDays"><br> <font
					color="Red"><span id="noderror"></span></font></td>
				<td><select name="modeOfTravel" style="width: 140px;">
						<option value="select">Select</option>
						<option value="Car">Car</option>
						<option value="Bus">Bus</option>
						<option value="Auto">Auto</option>
				</select><br> <font color="Red"> <span id="moterror"></span></font></td>
				<td><input type="text" name="distance"><br> <font
					color="Red"><span id="distanceerror"></span></font></td>
				<td><input type="text" name="amount"> <br> <font
					color="Red"><span id="amounterror"></span></font></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Add Conveyance"
					onClick="return validateConveyance();"></td>
				<td><input type="reset" name="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>