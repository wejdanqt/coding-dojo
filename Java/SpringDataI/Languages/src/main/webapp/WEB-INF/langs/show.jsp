<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<p>Name: <c:out value="${langs.name}"/></p>
<p>Creator: <c:out value="${langs.creator}"/></p>
<p>Version: <c:out value="${langs.currentVersion}"/></p>
<a href="langs/edit/${langs.id }">Edit</a>
<form action="" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
