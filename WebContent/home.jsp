<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BullHorn Home Page</title>
</head>
<body>
<img src="http://icons.iconarchive.com/icons/sora-meliae/matrilineare/1024/avatar-default-icon.png" width="100px" alt="default avatar image"/> <br />
Welcome to BullHorn, ${user.getName()}! How are you today?
<br />
<c:forEach var="us" items="${users}">
<tr>
<td>
<c:out value="${us.value.name}" />
</td>
<td>
<c:out value="${us.value.email}" />
</td>
</tr>  
<br />
</c:forEach>
</body>
</html>