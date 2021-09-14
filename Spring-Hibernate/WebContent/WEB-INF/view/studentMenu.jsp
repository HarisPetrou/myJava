<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/menu.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
<a href="<c:url value="/logout"/>" class="button logout" style="position: absolute; right: 0;">Logout</a>
<div id="wrapper">
                <div id="header">
                        <h2>Select, what you want to do:</h2>
                </div>
        </div>
        <div class="menu-group">
        <a href="<c:url value="/student/mydata"/>" class="button">Show my data</a>
        <a href="<c:url value="/student/showsubjects"/>" class="button">Show available subjects</a>
        <a href="<c:url value="/student/application"/>" class="button">Create a new application</a>
</div>
</body>
</html>