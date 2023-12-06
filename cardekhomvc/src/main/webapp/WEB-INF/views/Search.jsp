<%@page import="com.jspiders.cardekhomvc.pojo.CarPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="./NavBar.jsp"></jsp:include>
     <% String msg=( String)request.getAttribute("msg");
     CarPOJO pojo=(CarPOJO)request.getAttribute("car");%>
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
#disp {
	margin-top: -600px;
}
</style>
</head>
<body>

<div id="disp" align="center">
		<fieldset>
			<legend>Search Car Data</legend>
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Enter Id :</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" id="btn" value="SEARCH">
			</form>
		</fieldset>
		<%if(msg != null){ %>
		<h3><%=msg %></h3>
		<%} %>
		<%if(pojo != null){ %>
		<table>
		<tr>
		<th>Car Id</th>
		<th>Car Name </th>
		<th>Car Brand</th>
		<th>Car Price</th>
		<th>Car FuelType</th>
		<th>Car AirBags</th>
		</tr>
		<tr>
		<td><%=pojo.getId() %></td>
		<td><%=pojo.getName() %></td>
		<td><%=pojo.getBrand() %></td>
		<td><%=pojo.getPrice() %></td>
		<td><%=pojo.getFueltype() %></td>
		<td><%=pojo.getAirbags() %></td>
		</tr>
		</table>
		<%} %>
</div>

</body>
</html>