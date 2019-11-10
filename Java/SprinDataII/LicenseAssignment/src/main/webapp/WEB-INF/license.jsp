<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>
<h1>New License</h1>
<form:form action="/add/license" method="post" modelAttribute="license">
    <p>
        <form:label path="person">Person</form:label>
        <form:errors path="person"/>
        <form:select path="person"> 
       		 <c:forEach items="${persons}" var="person">
				<option value="${person.id}">${person.firstName} ${person.lastName}</option>
			</c:forEach>
        </form:select>
    </p>
        <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date" path="expirationDate"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>    



</body>
</html>