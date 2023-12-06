<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	box-sizing: border-box;
	margin: 0;
}

Nav {
	margin-top: 0px;
	height: 60px;
	width: 100%;
	background-color: black;
}

ul {
	margin-left: 50%;
}

ul li {
	display: inline-block;
	color: white;
	list-style-type: none;
	margin-left: 13px;
	line-height: 60px;
}

ul li a {
	text-decoration: none;
	color: black;
	padding: 10px 10px;
	background-color: white;
	border-radius: 10px;
	font-weight: 700;
}

ul li a:hover {
	text-decoration: underline black;
}

#logout a {
	text-decoration: none;
	color: red;
	padding: 10px 10px;
	background-color: white;
	border-radius: 10px;
	font-weight: 700;
}

#emp {
	height: 10px;
	width: 200px;
	position: absolute;
	top: 0px;
}

h2 {
	color: white;
}
</style>
</head>
<body>
	<Nav>
		<div id="emp">
			<h2>Employee Data</h2>
		</div>
		<ul>
			<li><a href="./home">HOME</a></li>
			<li><a href="./add">ADD</a></li>
			<li><a href="./remove">REMOVE</a></li>
			<li><a href="./search">SEARCH</a></li>
			<li><a href="./update">UPDATE</a></li>
			<li id="logout"><a href="./logout">LOGOUT</a></li>
		</ul>
	</Nav>
</body>
</html>