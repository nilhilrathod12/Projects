<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String firstName=request.getParameter("firstname");
String lastName=request.getParameter("lastname");
String email=request.getParameter("email");
String qualification=request.getParameter("qualification");

Connection connection;
PreparedStatement preparedStatement;
ResultSet  resultSet;

String query="insert into registration values (?,?,?,?)";

try{
	Class.forName("com.mysql.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja2", "root", "root");
	preparedStatement=connection.prepareStatement(query);
	
	preparedStatement.setString(1, firstName);
	preparedStatement.setString(2, lastName);
	preparedStatement.setString(3, email);
	preparedStatement.setString(4, qualification);
	
	int result=preparedStatement.executeUpdate();
	if(result>0){
		out.print("<h1>Data Successfully updated</h1>");
	}
	else{
		out.print("<h1>Erro message</h1>");
	}
}
catch(Exception e){
	out.print(e);
}

%>
</body>
</html>