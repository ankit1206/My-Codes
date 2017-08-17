<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>



<script type="text/javascript">
	function validate() {
		var empid = document.getElementById("loginid").value;
		var pass = document.getElementById("password").value;
		var flag = true;
		if (empid.length < 1) {
			document.getElementById("idError").innerHTML = "Login ID cannot be empty";
			flag = false;
		}
		if (empid.length < 1) {
			document.getElementById("passError").innerHTML = "Password cannot be empty";
			flag = false;
		}
		return flag;
	}
</script>
</head>

<%
	String message = "";
	if (request.getAttribute("message") != null) {
		message = "* " + request.getAttribute("message").toString();
	}
	session.invalidate();
%>
<body>
	<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();
		}
	</script>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload=""></body>
<center>
	<form action="LoginController" method="post"
		onsubmit="return validate()">
		<table align="center" style="font-family: arial;">
			<tr>
				<%
					if (!message.equals("")) {
				%>
				<td colspan="3"><font color="red"><%=message%></font></td>
				<%
					}
				%>

			</tr>
			<tr>
				<td>Login ID</td>
				<td><input type="text" id="loginid" name="loginid"></td>
				<td><font face="Arial" color="red"><span id="idError"></span></font></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="password" name="password">
				</td>
				<td><font face="Arial" color="red"><span id="passError"></span></font></td>
			</tr>
			<tr>
				<td><input type="submit" name="Login" value="Login"></td>
				<td><input type="reset" value="Reset" name="Reset"></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>