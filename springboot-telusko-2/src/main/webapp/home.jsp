<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Add Alien</h3>
<form action="addAlien">
<input type="text" name="aid"><br>
<input type="text" name="name"><br>
<input type="text" name="tech"><br>
<input type="submit"><br>
</form>

<h3>Get Alien By ID</h3>
<form action="getAlien">
<input type="text" name="aid"><br>
<input type="submit"><br>
</form>

<h3>Get Aliens By Tech</h3>
<form action="getAliensByTech">
<input type="text" name="tech"><br>
<input type="submit"><br>
</form>


<h3>Get Aliens Greater than ID</h3>
<form action="getAliensGreaterThan">
<input type="text" name="aid"><br>
<input type="submit"><br>
</form>


<h3>Get Aliens Tech Sorted</h3>
<form action="getAliensTechSorted">
<input type="text" name="tech"><br>
<input type="submit"><br>
</form>
</body>
</html>