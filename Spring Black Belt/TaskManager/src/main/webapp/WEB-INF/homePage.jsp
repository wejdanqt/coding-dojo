<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
  border-collapse: collapse;
}

table, td, th {
  border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>

    <h1>Welcome <c:out value="${currentUser.username}"></c:out></h1>
    
<a href="/tasks/Asc" >Asc</a> <a href="/tasks/Dsc" >Dec</a>
    <br><br>
    
    <table>
  <tr>
    <th>Task</th>
    <th>Creator</th>
    <th>Assignee</th>
    <th>Priority</th>
 
  </tr>
 
<c:forEach items="${tasks}" var="task">
  <tr>
    <td>  <a href="/task/${task.id}">${task.taskName}</a></td>
    <td>${task.creator}</td>
    <td>${task.user.getUsername()}</td>
     
     <c:if test="${task.priority == 3}">  
   <td>High</td>
        </c:if>  
       
     <c:if test="${task.priority == 2}">  
   <td>Medium</td>
        </c:if>  
        
          
     <c:if test="${task.priority == 1}">  
   <td>Low</td>
        </c:if>  
     
  </tr>
    </c:forEach>

</table>

<br>

<a href="/tasks/new" ><button>Create Task</button></a>

<br><br><br>

 <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
</body>
</html>