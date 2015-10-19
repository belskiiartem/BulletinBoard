<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	 <h2>In this form you can create new advertisement:</h2>
<form action="" method="POST">

Choice category:
<select name="categoryId">
	<c:forEach var="category" items="${categoryList}" varStatus="loop">
  		<option value="${category.id}"><c:out value="${category.categoryTitle}"/></option>
	</c:forEach>
</select>
<p>Put advertisement title
<p><input type="text" max="16"  name="title" size="50px">
<p>Put advertisement body:
<p><textarea name="body" ROWS="5" cols="50"></textarea>
 <p><input type="submit" value="Create!">
</body>
</html>
