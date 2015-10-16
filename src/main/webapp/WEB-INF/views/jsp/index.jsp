<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<form action="./userHome" method="POST">
	 <h2>Hello! On bulletin board!</h2>
	 <p><h2>You can use your email address as login:</h2></p>
	 <input type="text" max="16"  name="email" size="20px"> <br>
	<input type="submit" value="submit">
</form>

</body>
</html>
