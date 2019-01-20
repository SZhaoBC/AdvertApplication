<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Add User Form</title>
</head>
<body>

	<h2>Add a New User</h2>

	<form action="addUser.htm" method="post">

		<table>

			<tr>
				<td>Advert:</td>
				<td><select name="advertTitle">
						<c:forEach var="adv" items="${adverts}">
							<option value="${adv.title}">${adv.title}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>User Name:</td>
				<td><input type="text" name="userName" size="30" /></td>
			</tr>

			<tr>
				<td>User Password:</td>
				<td><input type="text" name="password" size="30" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Post Advert" /></td>
			</tr>
		</table>

	</form>

</body>
</html>