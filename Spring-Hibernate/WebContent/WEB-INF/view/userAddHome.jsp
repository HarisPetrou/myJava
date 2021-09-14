<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form - Add a user</title>
</head>
<body> 
		<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
       	<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
   
<div id="wrapper">
                <div id="header">
                        <h2>Welcome, enter the student data</h2>
                </div>
        </div>
		<form:form method="POST" action="${pageContext.request.contextPath}/secretariat/addUser" modelAttribute="user">
		<table>
		
			<tr>
				<td><form:label path="fullName">Full Name</form:label></td>
				<td><form:input path="fullName" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="email">E-mail</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="studentId">Student Id</form:label></td>
				<td><form:input path="studentId" /></td>
			</tr>
			<tr>
				<td><form:label path="professorId">Professor Id</form:label></td>
				<td><form:input path="professorId" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>

</html>