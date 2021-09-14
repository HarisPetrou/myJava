<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
       	<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
	<h2>Submitted User Information</h2>
	<table>
		
		<tr>
			<td>Id: </td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>Full Name: </td>
			<td>${fullName}</td>
		</tr>
		<tr>
			<td>Username: </td>
			<td>${username}</td>
		</tr>
		<tr>
			<td>Password: </td>
			<td>${password}</td>
		</tr>
		<tr>
			<td>E-mail: </td>
			<td>${email}</td>
		</tr>		
		<tr>
			<td>Professor Id: </td>
			<td>${professorId}</td>
		</tr>
		<tr>
			<td>Enabled: </td>
			<td>${enabled}</td>
		</tr>
	</table>
</body>
</html>