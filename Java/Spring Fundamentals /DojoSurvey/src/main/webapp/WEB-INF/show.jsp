<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
</head>
<body>
<h3>Submitted Info</h3>
Name: <c:out value="${name}"/><br>
Dojo location: <c:out value="${location}"/><br>
language: <c:out value="${lang}"/><br>
comment: <c:out value="${comment}"/><br>

</body>
</html>