<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript" src="js/countries.js"></script>
<%
	
%>
<title>Registration</title>
</head>
<script>
	$(function() {
		$("#dob").datepicker({
			dateFormat : 'dd/mm/yy',
			changeMonth : true,
			changeYear : true,
			maxDate : '-22y',
			onClose : function(selectedDate) {
				$("#doj").datepicker("option", "minDate", selectedDate);
			}
		});
	});
	$(function() {
		$("#doj")
				.datepicker(
						{
							dateFormat : 'dd/mm/yy',
							changeMonth : true,
							changeYear : true
						/* onClose: function (selectedDate){$("#dob").datepicker("option","maxDate",selectedDate);} */});
	});
</script>
<body>

	<div>
		<form action="RegistrationController" method="post" name="regform"
			onsubmit="return validateRegister()">
			<table align="center" style="font-family: arial;">
				<tr>
					<td><span id="message"> <%
 	if (request.getAttribute("message") != null) {

 		out.print("<font color='red'>"
 				+ request.getAttribute("message") + "</font>");
 	}
 %>
					</span></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" id="name"></td>
					<td><font face="Arial" color="Red"><span id="nameError"></span></font></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="radio" value="Male" name="Gender" id="male">Male<input
						type="radio" value="Female" name="Gender" id="female">Female</td>
					<td><font face="Arial" color="Red"><span
							id="GenderError"></span></font></td>
				</tr>
				<tr>
					<td>Date Of Birth:</td>
					<td><input type="text" name="dob" id="dob" readonly></td>
					<td><font face="Arial" color="Red"><span id="dobError"></span></font></td>
				</tr>
				<tr>
					<td>Date Of Joining:</td>
					<td><input type="text" name="doj" id="doj" readonly></td>
					<td><font face="Arial" color="Red"><span id="dojError"></span></font></td>
				</tr>
				<tr>
					<td>Contact No:</td>
					<td><input type="text" name="contactno" id="contactno"></td>
					<td><font face="Arial" color="Red"><span
							id="contactnoError"></span></font></td>
				</tr>
				<tr>
					<td>Bank Account No:</td>
					<td><input type="text" name="bankac" id="bankac"></td>
					<td><font face="Arial" color="Red"><span
							id="bankacError"></span></font></td>
				</tr>
				<tr>
					<td>Pan No:</td>
					<td><input type="text" name="panno" id="panno"></td>
					<td><font face="Arial" color="Red"><span
							id="pannoError"></span></font></td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td><input type="text" name="email" id="email"></td>
					<td><font face="Arial" color="Red"><span
							id="emailError"></span></font></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address" id="address"></td>
					<td><font face="Arial" color="Red"><span
							id="addressError"></span></font></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><select id="country" name="country" id="country"></select></td>
					<td><font face="Arial" color="Red"><span
							id="countryError"></span></font></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><select name="state" id="state" id="state"></select></td>
					<td><font face="Arial" color="Red"><span
							id="stateError"></span></font></td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><select name="designation" id="designation">
							<option value="Select">Select Designation</option>
							<option value="Trainee">Trainee</option>
							<option value="Trainer">Trainer</option>
							<option value="Associate">Associate</option>
							<option value="Module Leader">Module Leader</option>
							<option value="Team Leader">Team Leader</option>
							<option value="Project Leader">Project Leader</option>
							<option value="Developer">Developer</option>
							<option value="Test Engineer">Test Engineer</option>
							<option value="Project Manager">Project Manager</option>
							<option value="Quality Leader">Quality Leader</option>
					</select></td>
					<td><font face="Arial" color="Red"><span
							id="designationError"></span></font></td>
				</tr>
				<tr>
					<td>Domain:</td>
					<td><input type="text" name="domain" id="domain"></td>
					<td><font face="Arial" color="Red"><span
							id="domainError"></span></font></td>
				</tr>
				<tr>
					<td>Basic salary:</td>
					<td><input type="text" name="salary" id="salary"></td>
					<td><font face="Arial" color="Red"><span
							id="salaryError"></span></font></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"></td>
					<td><input type="reset"></td>
				</tr>
			</table>
		</form>
		<script>
			populateCountries("country", "state");
		</script>
	</div>
</body>
</html>