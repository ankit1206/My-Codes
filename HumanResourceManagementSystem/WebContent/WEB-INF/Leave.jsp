<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

<title>Leave Application</title>
</head>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
</body>
<script type="text/javascript">
	function validate() {
		var empid = document.getElementById("employeeId").value;
		var from = document.getElementById("fromDate").value;
		var to = document.getElementById("toDate").value;
		var flag = true;
		if (empid.length > 1) {
			$("#idError").hide();
		}
		if (from.length > 1) {
			$("#fromError").hide();
		}
		if (to.length > 1) {
			$("#toError").hide();
		}
		if (empid.length < 1) {
			$("#idError").show();
			$("#message").hide();
			document.getElementById("idError").innerHTML = "Employee ID cannot be empty";
			flag = false;
		}
		if (from.length < 1) {
			document.getElementById("fromError").innerHTML = "From Date cannot be empty";
			flag = false;
		}
		if (to.length < 1) {
			document.getElementById("toError").innerHTML = "To Date cannot be empty";
			flag = false;
		}
		return flag;
	}
</script>
<script>
	$(function() {
		$("#datepicker").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					numberOfMonths : 1,
					dateFormat : 'dd/mm/yy',
					minDate : new Date(),
					onClose : function(selectedDate) {
						$("#datepicker1").datepicker("option", "minDate",
								selectedDate);
					}
				});
	});
	$(function() {
		$("#datepicker1").datepicker({
			changeMonth : true,
			changeYear : true,
			numberOfMonths : 1,
			dateFormat : 'dd/mm/yy',
			minDate : "#datepicker"

		});
	});
</script>
<%
	String message = "";
	if (request.getAttribute("message") != null) {
		message = request.getAttribute("message").toString();
	}
%>
<body>

	<form action="LeaveApplicationController" method="post">
		<table align="center" style="font-family: arial;">
			<tr>
				<%
					if (!message.equals("") || message != null) {
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
				<td><font face="Arial" color="red"><span id="idError"></span></font></td>
			</tr>
			<tr>
				<td>From:</td>
				<td><input type="text" id="datepicker" name="fromDate"></td>
				<td><font face="Arial" color="red"><span id="fromError"></span></font></td>
			</tr>
			<tr>
				<td>To:</td>
				<td><input type="text" id="datepicker1" name="toDate"></td>
				<td><font face="Arial" color="red"><span id="toError"></span></font></td>
			</tr>
			<tr>
				<td><input type="submit" value="Apply Leave"
					onclick="return validate()"></td>
			</tr>
		</table>
	</form>
</body>
</html>