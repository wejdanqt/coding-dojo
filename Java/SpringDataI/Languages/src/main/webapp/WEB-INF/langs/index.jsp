<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
            <td> Name </td>
            <td> Creator</td>
            <td>Version</td>
            <td>Action</td>
       </tr>

		  <c:forEach items="${langs}" var="lang">
        <tr>
            <td> <a href="/lang/${lang.id}"><c:out value="${lang.name}"/> </a> </td>
            <td> <c:out value="${lang.creator}"/> </td>
            <td> <c:out value="${lang.currentVersion}"/> </td>
            <td>  <a href="delete/${lang.id}">delete</a> <a href="langs/edit/${lang.id }">edit</a> </td>
       </tr>
        </c:forEach>
</table>

<form:form action="/new" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>     
        <form:input path="currentVersion"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>


