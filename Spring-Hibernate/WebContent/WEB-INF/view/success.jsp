<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="<c:url value="/resources/buttons.css" />" rel="stylesheet">
</head>
<body class="w3-container w3-auto">
<a href="<c:url value="/logout"/>"class="button logout" style="position: absolute; right: 0;">Logout</a>
<a href="<c:url value="/"/>"class="button menu" style="position: absolute; right: 100px;">Menu</a>
<h2>Your action was:</h2>


<div class="w3-panel w3-pale-green w3-border">
  <h3>Successful!</h3>
</div>

</body>
</html>