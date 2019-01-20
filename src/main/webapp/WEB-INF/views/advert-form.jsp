<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add Advert Form</title>
</head>
<body>

	<h2>Posting a New Advert</h2>

	<form action="add.htm" method="post">

		<table>

			<tr>
				<td>Category:</td>
				<td><select name="categoryTitle">
						<c:forEach var="categ" items="${categories}">
							<option value="${categ.title}">${categ.title}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>Advert Title:</td>
				<td><input type="text" name="title" size="30" /></td>
			</tr>

			<tr>
				<td>Message:</td>
				<td><input type="text" name="message" size="30" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Post Advert" /></td>
			</tr>
		</table>

	</form>

</body>
</html>