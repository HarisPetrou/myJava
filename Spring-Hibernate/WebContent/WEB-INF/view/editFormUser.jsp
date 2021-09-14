
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form - edit a user</title>
</head>
<body>
	<h3>Edit form</h3>

	<form:form method="POST" action="${pageContext.request.contextPath}/secretariat/editUser" modelAttribute="user">
		<table>
		
			
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>

</html>