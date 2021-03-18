<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>Hi. Welcome to your personal Area Mr.Admin</h3>
	<h2>Here you can add new journal to our database</h2>
	<form action="JournalAddServlet" method="post">
		<label for="name">Name :</label> <input name="name"> <br>
		<label for="price">Price : </label> <input name="price">
		<br> <input type="submit" value="submit">
	</form>

	<p>
		Return to <a href="index.jsp">homepage</a>
	</p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>