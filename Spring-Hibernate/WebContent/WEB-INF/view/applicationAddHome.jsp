<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form - Application</title>
</head>
<body>
<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
       	<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
	<h3>Welcome, application form</h3>

	<form:form method="POST" action="${pageContext.request.contextPath}/student/addApplication" modelAttribute="application">
		<table>
			
			<tr>
				<td><form:label path="thesisName">Thesis Name</form:label></td>
				<td><form:input path="thesisName" /></td>
			</tr>
			<tr>
				<td><form:label path="idProfessor">Professor ID</form:label></td>
				<td><form:input path="idProfessor" /></td>
			</tr>
			<tr>
				<td><form:label path="idStudent">Student ID</form:label></td>
				<td><form:input path="idStudent" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>

</html>