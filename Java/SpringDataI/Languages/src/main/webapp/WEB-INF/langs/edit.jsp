<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<h1>Edit Language</h1>


<form:form action="/edit/edit/${lang.id }" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
      <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name" value="${lang.name }" />
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator" value="${lang.creator }" />
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>     
        <form:input path="currentVersion" value="${lang.currentVersion }"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form>