<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.hrms.model.ConveyanceTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

<title>Conveyance Search</title>
</head>
<script type="text/javascript">
	function validate() {
		var flag = true;

		var empId = document.forms["search"]["employeeId"].value;
		if (empId.length > 1) {
			$("#Iderror").hide();
		}
		if (empId == null || empId.length < 1 || empId.equals("")) {
			$("#Iderror").show();
			$("#message").hide();
			document.getElementById("Iderror").innerHTML = "* EmpId cannot be empty";
			flag = false;
		}
		return flag;
	}
</script>
<%
	String message = "";
	if (((ConveyanceTO) request.getAttribute("conveyanceObj")) != null) {
		message = ((ConveyanceTO) request.getAttribute("conveyanceObj"))
				.getMessage();
	}
%>
<body>
	<form action="ConveyanceController?action=search" method="post"
		name="search">
		<table align="center" style="font-family: arial;">
			<tr>
				<%
					if (!message.equals("")) {
				%>
				<td colspan="3"><span id="message"><font color="red"><%=message%></font>
				</span></td>
				<%
					}
				%>

			</tr>
			<tr>
				<td>Employee Id:</td>
				<td><input type="text" name="employeeId"></td>
				<td><font color="Red"><span id="Iderror"></span></font></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"
					onClick="return validate();"></td>
			</tr>
		</table>
	</form>
</body>
</html>