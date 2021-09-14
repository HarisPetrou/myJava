<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form - Add a subject</title>
</head>
<body>
<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
       	<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
	<h3>Welcome, enter the subject data</h3>

	<form:form method="POST" action="${pageContext.request.contextPath}/professor/addSubject" modelAttribute="subject">
		<table>
			<tr>	
				<td><form:label path="title">Title</form:label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><form:label path="prerequisites">Prerequisites</form:label></td>
				<td><form:input path="prerequisites" /></td>
			</tr>
			<tr>
				<td><form:label path="studiesLevel">Studies Level</form:label></td>
				<td> <form:select path="studiesLevel">
				<form:option value="Undergraduate" label="Undergraduate" />
 				<form:option value="Postgraduate" label="Postgraduate" />
 				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="numberOfStudents">Number Of Students</form:label></td>
				<td><form:input path="numberOfStudents" /></td>
			</tr>
			<tr>
				<td><form:label path="supervisorId">Supervisor Id</form:label></td>
				<td><form:input path="supervisorId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>

</html>