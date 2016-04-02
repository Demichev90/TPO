<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add 2 numbers</title>
</head>
<body>
	<h1 style="">Addator Get</h1>
	<form action="MyServlet" method = "GET">
		<label>First number: </label> <input type="text" name="n1" /> <br />
		<label>Second number : </label> <input type="text" name="n2" /> <br />
		<input type="submit" value="Add" />
	</form>

	<h1 style="">Addator Post</h1>
	<form action="MyServlet" method = "POST">
		<label>First number: </label> <input type="text" name="n3" /> <br />
		<label>Second number : </label> <input type="text" name="n4" /> <br />
		<input type="submit" value="Add" />
	</form>
</body>
</html>