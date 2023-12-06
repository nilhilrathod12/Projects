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
			<legend>Search Student</legend>
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Lower Range</td>
						<td><input type="text" name="lowerMarks"></td>
					</tr>
					<tr>
						<td>Upper Range</td>
						<td><input type="text" name="upperMarks"></td>
					</tr>
				</table>
				<input type="submit" value="Search">
			</form>
		</fieldset>
	</div>
</body>
</html>