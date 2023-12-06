<%@page import="java.util.List"%>
<%@page import="com.jspiders.cardekhomvc.pojo.CarPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="./NavBar.jsp"></jsp:include>
     <% List<CarPOJO> cars=(List<CarPOJO>) request.getAttribute("cars");
String msg=(String)request.getParameter("msg");
CarPOJO pojo= (CarPOJO) request.getAttribute("car");%>
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
#cars{
margin-top: 50px;

}
#cars,tr,td,th:hover{
background-color: red;
color: white;
border: 2px solid black;
}
#disp {
	margin-top: -600px;
}

</style>

</head>
<body>
<div align="center" id="disp">
		<% if(pojo == null){ %>
		<fieldset>
			<legend> Select Car To Update </legend>
			<form action="./update" method="post">
				<table id="tbl">
					<tr>
						<td>Enter Id:</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input id="btn" type="submit" value="SELECT">
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
		if (cars != null) {
		%>
		<table id="cars">
			<tr>
				<th>Car Id</th>
				<th>Car NAME</th>
				<th>Car Brand</th>
				<th>Car Price</th>
				<th>Car FuelType</th>
				<th>Car AirBags</th>
			</tr>
			<%
			for (CarPOJO car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getPrice()%></td>
				<td><%=car.getFueltype()%></td>
				<td><%=car.getAirbags() %></td>
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
		<legend>Update Car Data</legend>
		<form action="./updateCar" method="post">
			<table id="cars">
				<tr>
					<td>ID :</td>
					<td><%=pojo.getId() %></td>
					<td> <input type="text" name="id" hidden="true" value="<%=pojo.getId() %> "></td>
				</tr>
				<tr>
					<td> Car NAME :</td>
					<td><input type="text" name="name" value="<%=pojo.getName()%>"></td>
				</tr>
				<tr>
					<td>Car Brand :</td>
					<td><input type="text" name="brand" value="<%=pojo.getBrand() %>"></td>
				</tr>
				<tr>
					<td>Car Price :</td>
					<td><input type="text" name="price" value="<%=pojo.getPrice() %>"></td>
				</tr>
				<tr>
					<td>Car FuelType :</td>
					<td><input type="text" name="fueltype" value="<%=pojo.getFueltype() %>"></td>
				</tr>
				<tr>
					<td>Car AirBags :</td>
					<td><input type="text" name="airbags" value="<%=pojo.getAirbags() %>"></td>
				</tr>
			</table>
			<input  id="btn" type="submit" value="UPDATE">
		</form>
		</fieldset>
		<% }%>

	</div>

</body>
</html>