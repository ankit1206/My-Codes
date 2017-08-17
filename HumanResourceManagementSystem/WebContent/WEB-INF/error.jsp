<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
	<center>
		<table>
			<tr>
				<td><img src="Images/Error.bmp" height="50" width="50" /></td>
				<td><font color="Red" size="5" face="Arial"><%=request.getAttribute("message")%></font>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>