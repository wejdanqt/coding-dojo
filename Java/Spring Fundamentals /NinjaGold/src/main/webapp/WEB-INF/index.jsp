<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
            .box{
                display: inline-block;
                vertical-align: top;
                border: 1px solid black;
                height: 180px;
                width: 180px;
                text-align: center;
      
            
            }
            .button{
                margin-top: 40px;
            }
            
            .boxes{
                text-align: center;
            } 

            textarea{
                resize: none;
                height: 150px;
                width: 1200px;
       
            }
        </style>
<title>Ninja Gold</title>


</head>
  <body>
            <label>Your Gold:</label>
            <input type="text" name ='score' value= <c:out value="${gold}"/>> 
    
        <div class="boxes">
               
        <div class=box>
        <form action="/process_money" method="post">
            <h2>Farm</h2>
            <p>(earns 10 -20 golds)</p>
            <input type="hidden" name="building" />
            <input class="button"  type="submit" name="submit" value="farm"/>
          </form>
        </div>

        <div class=box>
          <form action="/process_money" method="post">
            <h2>Cave</h2>
            <p>(earns 5 -10 golds)</p>
            <input type="hidden" name="building" />
            <input  class="button" type="submit" name="submit" value="cave"/>
          </form>
          </div>

          <div class=box>
          <form action="/process_money" method="post">
            <h2>House</h2>
            <p>(earns 2 -5 golds)</p>
            <input type="hidden" name="building" />
            <input class="button"  type="submit" name="submit" value="house"/>
          </form>
          </div>

          <div class= box>
          <form action="/process_money" method="post">
            <h2>Casino</h2>
            <p>(earns/takes 0 -50 golds)</p>
            <input type="hidden" name="building"/>
            <input class="button" type="submit" name="submit" value="casino"/>
          </form>
        </div>
    </div>
    <h2>Activites:</h2> <br>
    
    
 
    <textarea>
    
  <c:forEach var="act" items="${act}">
    <c:out value="${act}"/>
</c:forEach>
    
    
    </textarea>
    </body>
</html>