<%@page import="com.jspiders.springmvc2.pojo.EmployeePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%List<EmployeePOJO> employees=(List<EmployeePOJO>)request.getAttribute("employees");
String msg=(String)request.getAttribute("msg");%>

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
	<jsp:include page="NavBar.jsp"></jsp:include>
	<div align="center">
		<fieldset>
			<legend>Remove Employee Data</legend>
			<form action="./remove" method="post">
				<table>
					<tr>
						<td>Enter Id :</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" id="btn" value="REMOVE">
			</form>
		</fieldset>
		<%if(msg != null){ %>
		<h3><%=msg %></h3>
		<%} %>
			<%
		if (employees != null) {
		%>

		<table id="tbl">
			<tr>

				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>SALARY</th>
				<th>ADDRESS</th>
			</tr>
			<%
			for (EmployeePOJO employee : employees) {
			%>
			<tr>
				<td><%=employee.getId()%></td>
				<td><%=employee.getName()%></td>
				<td><%=employee.getEmail()%></td>
				<td><%=employee.getContact()%></td>
				<td><%=employee.getSalary()%></td>
				<td><%=employee.getAddress()%></td>

			</tr>
			<%
			}
			%>
		</table>

		<%
		}
		%>
	</div>

</body>
</html>