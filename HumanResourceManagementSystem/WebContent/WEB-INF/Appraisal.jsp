<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.hrms.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

<title>Calculate Appraisal</title>
</head>
<script type="text/javascript">
	
</script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			numberOfMonths : 1,
			dateFormat : 'dd/mm/yy'
		});
	});
	$(function() {
		$("#datepicker1").datepicker({
			changeMonth : true,
			changeYear : true,
			numberOfMonths : 1,
			dateFormat : 'dd/mm/yy'
		});
	});

	$(document).ready(function() {
		$("#dropbox").change(function() {
			if ($(this).val() == "Z051") {
				$("#textbox").show();
				$("#textbox").val("SCJP");
			} else if ($(this).val() == "Z089") {
				$("#textbox").show();
				$("#textbox").val("OCA");
			}
		});
	});
</script>
<body>
	<form name="Appraisal" action="AppraisalController" method="get">
		<table align="center" style="font-family: arial;">
			<tr>
				<td>Employee Id:</td>
				<td><input type="text"
					value="<%=((AppraisalTO) request.getAttribute("App")).getEmpId()%>"
					readonly></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text"
					value="<%=((AppraisalTO) request.getAttribute("App")).getEmpName()%>"
					readonly></td>
			</tr>
			<tr>
				<td>Domain:</td>
				<td><input type="text"
					value="<%=((AppraisalTO) request.getAttribute("App"))
					.getEmpDomain()%>"
					readonly></td>
			</tr>
			<tr>
				<td>Designation:</td>
				<td><input type="text"
					value="<%=((AppraisalTO) request.getAttribute("App"))
					.getEmpDesign()%>"
					readonly></td>
			</tr>
			<tr>
				<td>Project Name:</td>
				<td><input type="text" name="projName"></td>
				<td><font color="Red"><span id="pnameerror"></span></font></td>
			</tr>
			<tr>
				<td>Project Start Date:</td>
				<td><input type="text" id="datepicker" name="projSdate"
					readonly></td>
				<td><font color="Red"><span id="psdateerror"></span></font></td>
			</tr>
			<tr>
				<td>Testing Report:</td>
				<td><input type="text" name="testReport"></td>
				<td><font color="Red"><span id="treporterror"></span></font></td>
			</tr>
			<tr>
				<td>Mark:</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>Assessment Exam:</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>Certification Id:</td>
				<td><select name="certId" id="dropbox"><option
							value="Select">Select</option>
						<option value="Z051">Z051</option>
						<option value="Z089">Z089</option>
				</select></td>
			</tr>
			<tr>
				<td>Certification Name:</td>
				<td><input type="text" id="textbox" name="certName"></td>
				<td><font color="Red"><span id="cnameerror"></span></font></td>
			</tr>
			<tr>
				<td>Certification Date:</td>
				<td><input type="text" id="datepicker1" name="certDate"
					readonly></td>
				<td><font color="Red"><span id="cdateerror"></span></font></td>
			</tr>
			<tr>
				<td><input type="submit" value="Calculate Appraisal"
					onClick="return validateAppraisal()"></td>
				<td><input type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>