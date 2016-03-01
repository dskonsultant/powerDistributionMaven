<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add User</title>
	</head>
	<body>
		<form:form id="userForm" method="post" action="addUser" modelAttribute="userBean">

			<form:label path="username">Enter your user-name</form:label>
			<form:input id="username" name="username" path="username" /><br>
			<form:label path="username">Please enter Age</form:label>
			<form:input id="age" name="age" path="age" /><br>
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>