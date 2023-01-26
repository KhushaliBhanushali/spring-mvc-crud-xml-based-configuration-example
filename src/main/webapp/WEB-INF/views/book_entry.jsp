<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Entry</title>
</head>
<body>
<h1>Book Entry</h1>
	<form:form method="post" action="insert">
	<table>
		<tr>
			<td>Title:</td>
			<td><form:input path="title"/></td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><form:input path="author"/></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input path="price"/> </td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit"></td>
		</tr>
	</table>
	</form:form>
</body>
</html>