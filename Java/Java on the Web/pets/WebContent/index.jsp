<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create a Dog</h1>
<form  action="Dogs" method="GET">
Name:<input type="text" name = "name"><br>
Breed:<input type="text" name = "breed"><br>
Weight:<input type="text" name = "weight"><br>
<input type="submit" name = "submit" value="Create a dog">
</form>

<br>
<hr>
<h1>Create a Cat</h1>
<form  action="Cats" method="GET">
Name:<input type="text" name = "name"><br>
Breed:<input type="text" name = "breed"><br>
Weight:<input type="text" name = "weight"><br>
<input type="submit" name = "submit" value="Create a cat">
</form>

</body>
</html>