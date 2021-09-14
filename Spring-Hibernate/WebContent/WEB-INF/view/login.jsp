<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>Login Page</title>
	<h3>Login</h3>
	
<div class="form-group">

	<form:form action="${pageContext.request.contextPath}/authUser" method="POST">
	
	
			<label class="form-label">User Name</label> 
			<input type="text" name="username"/>
		
			<label class="form-label">Password</label> 
			<input type="password" name="password"/>
			<button class="btn" type="submit">Login</button>
			</div>
	</form:form>
	
</div>