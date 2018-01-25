<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Registration form</title>
</head>
<body>

	<form method="post" action="/student-tracker-jdbc/UpdateStudentFinal">
		<input type="hidden" name="studentId" value="${student.id }"> FirstName:<input
			type="text" name="firstName" value="${student.firstName}" /> <br />
		LastName:<input type="text" name="lastName"
			value="${student.lastName}" /> <br /> Email:<input type="text"
			name="email" value="${student.email}" /> <br /> <input
			type="submit" value="Register" />
	</form>
</body>
</html>