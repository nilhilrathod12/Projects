<%@page import="com.jspiders.cardekhomvc.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="./NavBar.jsp"></jsp:include>
<% String msg=(String )request.getAttribute("msg");
List<CarPOJO> cars=(List<CarPOJO> )request.getAttribute("cars");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#disp {
	margin-top: -600px;
}

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
</style>
</head>
<body>

	<div id="disp" align="center">
		<fieldset>
			<legend>Add Car Data</legend>
			<form action="./add" method="post">
				<table id="tbl">
					<tr>
						<td>Car Name :</td>
						<td><input type="text" name="name"></td>

					</tr>
					<tr>
						<td>Car Brand :</td>
						<td><input type="text" name="brand"></td>

					</tr>
					<tr>
						<td>Car Price :</td>
						<td><input type="text" name="price"></td>

					</tr>
					<tr>
						<td>Fuel Type :</td>
						<td><input type="text" name="fueltype"></td>

					</tr>

					<tr>
						<td>Air Bags :</td>
						<td><input type="text" name="airbags"></td>

					</tr>

				</table>
				<input id="btn" type="submit" value="ADD">
			</form>
		</fieldset>
        <%if(msg != null){ %>
        <h3><%=msg %></h3>
        <%} %>
        <%if(cars != null){ %>
        <table id="cars">
        <tr>
        <th>Car Id</th>
         <th>Car Name</th>
         <th>Car Brand</th>
         <th>Car Price</th>
         <th>Car FuelType</th>
         <th>Car AirBags</th>  
        </tr>
        <%for(CarPOJO car:cars){ %>
        <tr>
        <td><%=car.getId() %>
        <td><%=car.getName() %></td>
        <td><%=car.getBrand() %></td>
        <td><%=car.getPrice() %></td>
        <td><%=car.getFueltype() %></td>
        <td><%=car.getAirbags() %></td>
        </tr>
        <%} %>
        </table>
        <%} %>
	</div>
</body>
</html>