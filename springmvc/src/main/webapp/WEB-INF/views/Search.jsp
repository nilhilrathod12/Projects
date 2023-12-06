<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="NavBar.jsp"/>
    <% StudentPOJO pojo=(StudentPOJO)request.getAttribute("student"); 
    String msg=(String) request.getAttribute("msg");%>
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
#std{
border: 1px solid black;
}

#std td,th{
border: 1px solid black;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
		<legend>Search Student</legend>
		<form action="./search" method="post" >
		  <table>
		  <tr>
		  <td>Enter Id :</td>
		  <td><input type="text" name="id"></td>
		  </tr>
		  </table>
		  <input type="submit" value="SEARCH">
		</form>
		</fieldset>
		<%if(msg != null){ %>
		<h3><%=msg %></h3>
		<%} %>
		<%if(pojo != null) {%>
		<table id="std">
		<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Contact</th>
		<th>Address</th>
		</tr>
		<tr>
		<td><%=pojo.getId() %></td>
		<td><%=pojo.getName() %></td>
		<td><%=pojo.getEmail()%></td>
		<td><%=pojo.getContact() %></td>
		<td><%=pojo.getAddress() %></td>
		</tr>
		</table>
		<%} %>
		
	</div>
</body>
</html>