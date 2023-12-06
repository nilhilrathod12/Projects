<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Add Student</legend>
			<form action="./add" method="post">
				<table>
					<tr>
						<td>Enter Name:</td>
						<td><input type="text" name="name">
					</tr>
					<tr>
						<td>Enter marks:</td>
						<td><input type="text" name="marks">
					</tr>
				</table>
				<input type="submit" value="Add">
			</form>
		</fieldset>
	</div>

</body>
</html>