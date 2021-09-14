<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form - Add a student</title>
</head>
<body>
<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
       	<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
	<h3>Welcome, enter the student data</h3>

	<form:form method="POST" action="${pageContext.request.contextPath}/secretariat/addStudent" modelAttribute="student">
		<table>
			
			<tr>
				<td><form:label path="semester">Semester</form:label></td>
				<td><form:input path="semester" /></td>
			</tr>
			<tr>
				<td><form:label path="average">Average</form:label></td>
				<td><form:input path="average" /></td>
			</tr>
			<tr>
				<td><form:label path="studiesLevel">Studies Level</form:label></td>
				<td> <form:select path="studiesLevel">
				<form:option value="Undergraduate" label="Undergraduate" />
 				<form:option value="Postgraduate" label="Postgraduate" />
 				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="owedCoursesNumber">Number Of Owed Courses</form:label></td>
				<td><form:input path="owedCoursesNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="owedCourses">Owed Courses</form:label></td>
				<td><form:input path="owedCourses" /></td>
			</tr>
			
				<td><input type="submit" value="Submit" /></td>
			
		</table>
	</form:form>

</body>

</html>