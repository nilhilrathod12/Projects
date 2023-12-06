<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% String msg=(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
			<legend>Login Page</legend>
			<form action="./loginAdmin" method="Post">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="LOGIN">
			</form>

		</fieldset>
		<h4>Dont Have An Account ? <a href="http://localhost:14125/springmvc/createAccount">Create Acccount</a></h4>
		<% if(msg != null){ %>
		<h3><%=msg %></h3>
		<%} %>
	</div>

</body>
</html>