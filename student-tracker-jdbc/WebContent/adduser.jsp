<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Registration form</title>
</head>
<body>

	<h1>Student Registration</h1>
	<form method="post" action="/student-tracker-jdbc/Registration">
		<table>
			<tr>
				<td>FirstName:<input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>LastName:<input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Email:<input type="text" name="email"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>