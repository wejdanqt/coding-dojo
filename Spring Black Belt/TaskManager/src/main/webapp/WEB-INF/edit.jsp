<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<h1>Edit</h1>


<form:form action="/task/edit/${task.id}" method="post" modelAttribute="task">
    <input type="hidden" name="_method" value="put">
    
      <p>
        <form:label path="user">Assignee</form:label>
        <form:errors path="user"/>
        <form:select path="user"> 
       		 <c:forEach items="${users}" var="user">
				<option value="${user.id}">${user.username}</option>
			</c:forEach>
        </form:select>
    </p>
   <p>
        <form:label path="taskName">Task</form:label>
        <form:errors path="taskName"/>
        <form:input path="taskName"/>
    </p>
        <p>
        <form:label path="priority">Priority</form:label>
        <form:errors path="priority"/>
        <form:select path="priority"> 
				<option value="3">High</option>
				<option value="2">Medium</option>
				<option value="1">Low</option>
        </form:select>
    </p>   
    
    <form:input type="hidden" path="creator" value="${currentUser.username}"/> 
    <input type="submit" value="Submit"/>
</form:form>
