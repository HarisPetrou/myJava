<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/menu.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Secretariat</title>
</head>
<body>
<a href="<c:url value="/logout"/>" class="button logout" style="position: absolute; right: 0;">Logout</a>
<div id="wrapper">
                <div id="header">
                        <h2>Select, what you want to do:</h2>
                </div>
        </div>
        <div class="menu-group">
        <a href="<c:url value="/secretariat/add"/>" class="button">Add a new user</a>
        <a href="<c:url value="/secretariat/delete"/>" class="button">Delete a user</a>
        <a href="<c:url value="/secretariat/activate"/>" class="button">Activate a student</a>
        <a href="<c:url value="/secretariat/application"/>" class="button">Delete a student's application</a>
</div>
</body>
</html>