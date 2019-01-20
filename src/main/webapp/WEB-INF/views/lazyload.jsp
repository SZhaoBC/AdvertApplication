<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>category title</b></td>
			<td>category adverts</td>
		</tr>
		<c:out value="${categories}" />
		<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.title}</td>
				<td>${category.adverts}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>