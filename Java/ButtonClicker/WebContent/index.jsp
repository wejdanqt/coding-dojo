<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="clicker" method="get">
<input type="submit" name="submit" value="Click Me!">
</form>

<p>You have clicked this button <c:out value="${counter}"/>  </p>

</body>
</html>