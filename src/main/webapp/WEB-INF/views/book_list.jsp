<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
	<h1>Book List</h1>

	<a href="editbook">Add Book</a>
	<br>
	<table border="2" width="70%" cellpadding="2">
		<thead>
			<tr>
				<td>ID</td>
				<td>TITLE</td>
				<td>AUTHOR</td>
				<td>PRICE</td>
				<td>ACTION</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${list}">
				<tr>
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
					<td><a href="editbook/${book.id}">Update</a> <a
						href="deletebook/${book.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>