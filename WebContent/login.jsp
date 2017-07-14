<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="style.jsp" />

<title>BullHorn - Login</title>
</head>
<body>
	<h1>Welcome to BullHorn!</h1>
	<c:if test="${failure == 1 }">
${message}
</c:if>
	<form action="LoginServlet" method="post">
		User Email: <input type="email" name="username" id="username" /><br />
		Password: <input type="password" name="pass" id="pass" /><br /> <input
			type="submit" value="Login" />
	</form>
</body>
</html>