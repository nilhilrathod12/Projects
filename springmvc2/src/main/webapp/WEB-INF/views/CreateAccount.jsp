<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
fieldset {
	width: 300px;
	margin: 0 auto;
	text-align: center;
	font-style: 70px;
	font-weight: 700;
	margin-top: 40px;
	border-color: black;
	border-radius: 10px;
}

legend {
	background: black;
	color: white;
	font-size: 20px;
	font-weight: 800;
}

input {
	border: none;
	border-bottom: 2px solid black;
	outline: none;
}

#btn {
	padding: 8px 15px;
	margin-top: 10px;
	cursor: pointer;
	background-color: black;
	color: white;
	border-radius: 7px;
}

#tbl {
	margin-top: 20px;
}

#tbl, tr, td, th {
	border: 2px solid white;
	background-color: black;
	color: white;
}
</style>
</head>
<body>
<div align="center">
		<fieldset>
			<legend>Create An Account</legend>
			<form action="./createAccount" method="post">
				<table id="tbl">
					<tr>
						<td>Enter Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Enter Password</td>
						<td ><input type="password" name="password"></td>
					</tr>
					
				</table>
				<input id="btn" type="submit" value="CREATE ADMIN">
			</form>
		</fieldset>
		
	</div>
	
</body>
</html>