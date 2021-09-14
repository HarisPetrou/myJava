<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
<title>List of Applications</title>
<link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
       	<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
        <div id="wrapper">
                <div id="header">
                        <h2>Applications</h2>
                </div>
        </div>

        <div id="container">
                <div id="content">
                        <table>
                                <tr>
                                		<th>id</th>
                                		<th>thesis_name</th>
                                		<th>application_date</th>
                                        <th>id_professor</th>
                                        <th>id_student</th>
                                        
                                </tr>
                                <c:forEach var="tempApplication" items="${applications}">

                                        <tr>
                                        		<td>${tempApplication.id}</td>
                                        		<td>${tempApplication.thesisName}</td>
                                        		<td>${tempApplication.applicationDate}</td>
                                                <td>${tempApplication.idProfessor}</td>
                                                <td>${tempApplication.idStudent}</td>                                        
                                        </tr>
                                </c:forEach>
                        </table>
                </div>
        </div>

</body>
</html>