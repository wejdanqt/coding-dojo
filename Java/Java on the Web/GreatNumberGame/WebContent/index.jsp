<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Great Number</title>
<style>
body{
  text-align: center;
}
</style>
</head>
<body>
<h1>Welcome to the Great Number Game</h1>
<p>I'm thinking of a number between 1 and 100 </p>
<h3>Take a guess!!</h3>

<form action="GreatNumber" method="get">
<input type="text" name="guess" > <br>

<c:if test="${big == true }">
<div style="background-color:red;   height: 100px;  width: 100px;   display: inline-block;" >
Too Big!!
</div>
</c:if>

<c:if test="${small == true }">
<div style="background-color:red;   height: 100px;  width: 100px;   display: inline-block;" >
Too Small!!
</div>
</c:if>

<c:if test="${right == true }">
<div style="background-color:green;   height: 100px;  width: 100px;   display: inline-block;" >
Thats Right!!
</div>
</c:if>

<br>

<input type="submit" name="submit" >

</form>

</body>
</html>