
<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<% List<StudentPOJO> students=(List<StudentPOJO>) request.getAttribute("students");
String msg=(String)request.getParameter("msg");
StudentPOJO pojo= (StudentPOJO) request.getAttribute("student");%>
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
#field {
	margin: 15px 600px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

#std {
	border: 1px solid black;
}

#std td, th {
	border: 1px solid black;
}
#stud{
border: 1px solid black;
}
</style>
</head>
<body>
	<div align="center">
		<% if(pojo == null){ %>
		<fieldset>
			<legend> Select Student To Update </legend>
			<form action="./update" method="post">
				<table>
					<tr>
						<td>Enter Id:</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="SELECT">
			</form>
		</fieldset>

		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
		<%
		if (students != null) {
		%>
		<table id="std">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<%
			for (StudentPOJO student : students) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getContact()%></td>
				<td><%=student.getAddress()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
		<%}else{ %>
		<fieldset id="field">
		<legend>Update Student</legend>
		<form action="./updateStudent" method="post">
			<table id="std">
				<tr>
					<td>ID :</td>
					<td><%=pojo.getId() %></td>
					<td> <input type="text" name="id" hidden="true" value="<%=pojo.getId() %> "></td>
				</tr>
				<tr>
					<td>NAME :</td>
					<td><input type="text" name="name" value="<%=pojo.getName()%>"></td>
				</tr>
				<tr>
					<td>EMAIL :</td>
					<td><input type="text" name="email" value="<%=pojo.getEmail() %>"></td>
				</tr>
				<tr>
					<td>CONTACT :</td>
					<td><input type="text" name="contact" value="<%=pojo.getContact() %>"></td>
				</tr>
				<tr>
					<td>ADDRESS :</td>
					<td><input type="text" name="address" value="<%=pojo.getAddress() %>"></td>
				</tr>
			</table>
			<input type="submit" value="UPDATE">
		</form>
		</fieldset>
		<% }%>

	</div>
</body>
</html>