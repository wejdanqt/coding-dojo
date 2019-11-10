<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
<p>License Number: <c:out value="${person.license.number}"/></p>
<p>State: <c:out value="${person.license.state}"/></p> 
<p>Expiration Date: <c:out value="${person.license.expirationDate}"/></p>

