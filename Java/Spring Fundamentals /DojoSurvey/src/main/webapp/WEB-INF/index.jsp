<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
</head>
<body>
<!-- ... -->
<form method="POST" action="/show">
    <label>Your Name: <input type="text" name="name"></label><br>
    <label>Dojo Location: <select name="location">
    <option value="Riyadh">Riyadh</option>
    <option value="Dubai">Dubai</option>
    <option value="USA">USA</option>
    </select><br>
    </label>
     <label>Favorite Language: <select name="lang">
    <option value="java">JAVA</option>
    <option value="python">Python</option>
    <option value="C#">C#</option>
    </select>
    </label><br>
    <label>Comment(optional):</label><br>
    <textarea name="comment"></textarea><br>
    <button>Submit</button>
</form>
</body>
</html>