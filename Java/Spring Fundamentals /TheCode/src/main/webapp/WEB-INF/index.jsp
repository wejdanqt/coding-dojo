<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
</head>
<body>
<form method="POST" action="/check" >
<h4>What is the code?</h4>
<div style="color:red;">
 <c:out value="${error}"/>
 </div>
<input type="password" name="code"><br>
 <button>Try Code</button>
</form>

</body>
</html>