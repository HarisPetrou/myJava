<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
<title>List of subjects</title>
<link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
       	<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
        <div id="wrapper">
                <div id="header">
                        <h2>Subjects</h2>
                </div>
        </div>

        <div id="container">
                <div id="content">
                        <table>
                                <tr>
                                        <th>title</th>
                                        <th>prerequisites</th>
                                        <th>Studies_level</th>
                                        <th>number_of_students</th>
                                        <th>supervisor_id</th>
                                </tr>
                                <c:forEach var="tempSubject" items="${subjects}">

                                        <tr>
                                                <td>${tempSubject.title}</td>
                                                <td>${tempSubject.prerequisites}</td>
                                                <td>${tempSubject.studiesLevel}</td>
                                                <td>${tempSubject.numberOfStudents}</td>
                                                <td>${tempSubject.supervisorId}</td>                                           
                                        </tr>
                                </c:forEach>
                        </table>
                </div>
        </div>

</body>
</html>