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
<p>
<%-- <c:out value="${dog.greeting()}"/> --%>


<p>You created a <c:out value="${dog.getBreed()}"/> </p>

 <c:out value="${dog.showAffection()}"/>



</body>

</html>