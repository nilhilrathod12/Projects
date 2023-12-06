<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Create An Account</legend>
			<form action="./createAccount" method="post">
				<table>
					<tr>
						<td>Enter Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Enter Password</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="CREATE ADMIN">
			</form>
		</fieldset>
		
	</div>
</body>
</html>