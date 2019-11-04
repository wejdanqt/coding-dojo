<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
<title>Insert title here</title>
</head>
<body>

<% 

int width = 2 ;
int height = 2 ;

if(request.getParameter("width") != null){

 width = Integer.parseInt(request.getParameter("width")); 
} 


if(request.getParameter("height") != null){
     height = Integer.parseInt(request.getParameter("height")); 
}
%>


	<% for(int j = 0 ; j < height/2 ; j++){ %>
<table>
	<tr>
	<% for(int i = 0 ; i < width/2 ; i++){ %>
		<td  id = td1>
		
		 </td>
		 <td id = td2 >
		 
		 </td>
		 <%} %>
		 
	</tr>
	<tr>
		<% for(int i = 0 ; i < width/2 ; i++){ %>
	 <td    id = td2>
		 
		 </td>

		<td id = td1>
		
		 </td>
		  <%} %>
		

		 
	</tr>

		
</table>
 <%} %>


</body>
</html>