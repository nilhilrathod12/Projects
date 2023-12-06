<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String msg=(String)request.getAttribute("msg") ;%>
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
			<legend>Login Page</legend>
			<form action="./login" method="get">
				<table id="tbl">
					<tr>
						<td>USERNAME :</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>PASSWORD :</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input id="btn" type="submit" value="LOGIN">
			</form>
		</fieldset>
		<h4>Dont Have An Account, <a href="./createAccount">Create Account ?</a></h4>
		<%if(msg != null){  %> <h3><%=msg %></h3> <%} %>
	</div>
</body>
</html>