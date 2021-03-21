<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Area</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>Hi. Welcome to your personal Area</h3>

	<form action="ShowSubscribedJournalsServlet" method="get">
		<input type="submit" value="Show">
	</form>

	<a href="index.jsp">Back to homepage</a>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>