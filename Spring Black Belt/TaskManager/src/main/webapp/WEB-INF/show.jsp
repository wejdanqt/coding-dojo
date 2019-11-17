<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<h1>Task:<c:out value="${task.taskName}"/></h1>
<p>Creator: <c:out value="${task.creator}"/></p>
<p>Assignee: <c:out value="${task.user.getUsername()}"/></p>


  <c:if test="${task.priority == 3}">  
   <p>Priority: <c:out value="High"/></p>
 </c:if> 
   <c:if test="${task.priority == 2}">  
   <p>Priority: <c:out value="Medium"/></p>
 </c:if>  
 
   <c:if test="${task.priority == 1}">  
   <p>Priority: <c:out value="Low"/></p>
 </c:if>  

  
   <c:if  test="${currentUser.username  eq task.creator}"> 
<a href="/task/${task.id}/edit">Edit</a>
<br>
<a href="/task/delete/${task.id}">Delete</a>
 </c:if>  