<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Information</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css " />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Student Information</h2>
		</div>
	</div>
	<hr>
	<div id="container">
		<div id="content">
			<input type="button" value="Add Student"
				onclick="window.location.href='adduser.jsp'; return false;">
			<br> <br> <br>
			<table>
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${userList}" var="item">
					<c:url var="updateLink" value="/UpdateStudent">
						<c:param name="studentId" value="${item.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/DeleteStudent">
						<c:param name="studentId" value="${item.id}"></c:param>
					</c:url>
					<tr>
						<td>${item.firstName}</td>
						<td>${item.lastName}</td>
						<td>${item.email}</td>
						<td><a href="${updateLink}">Update</a></td>
						<td>
						<td>
							<!-- <td><a href="${deleteLink}">Delete</a></td> --> <a
							href="${deleteLink}"
							onclick="return confirm('Are you sure you want to delete this item?');">Delete</a>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>