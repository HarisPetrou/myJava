<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
<title>My data</title>
<link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
 		<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
       	<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
        <div id="wrapper">
                <div id="header">
                        <h2>My data</h2>
                </div>
        </div>

        <div id="container">
                <div id="content">
           
                        <table>
                                <tr>
                                        
                                        <th>Student_id</th>
                                        <th>Semester</th>
                                        <th>Average</th>
                                        <th>Studies_level</th>
                                        <th>Number_Of_Owed_Courses</th>
                                        <th>Owed_Courses</th>
                                                                           
                                </tr>
                                <c:forEach var="tempData" items="${mydata}">
                                        <tr>
                                                
                                                <td>${tempData.studentId}</td>
                                                <td>${tempData.semester}</td>
                                                <td>${tempData.average}</td>
                                                <td>${tempData.studiesLevel}</td>
                                                <td>${tempData.owedCoursesNumber}</td>
                                                <td>${tempData.owedCourses}</td>
                                                                                        
                                        </tr>
                                </c:forEach>                                  
                        </table>
                         <table>
                                <tr>                                        
                                        
                                        <th>full_name</th>
                                        <th>username</th>
                                        
                                        <th>email</th>
                                        <th>student_id</th>
                                        <th>professor_id</th>
                                        <th>enabled</th>                                        
                                </tr>
                                <c:forEach var="tempUserData" items="${myuserdata}">
                                        <tr>
                                                
                                                <td>${tempUserData.fullName}</td>
                                                <td>${tempUserData.username}</td>
                                                
                                                <td>${tempUserData.email}</td>
                                                <td>${tempUserData.studentId}</td>
                                                <td>${tempUserData.professorId}</td>
                                                <td>${tempUserData.enabled}</td>                                               
                                        </tr>
                                </c:forEach>
                                
                                
                        </table> 
                </div>
        </div>
</body>
</html>