package com.jspiders.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jspiders.todoapp.model.User;
import com.jspiders.todoapp.utils.JDBCUtils;

public class UserDao {
	
	public static int registerEmployee(User employee) {
		
		String INSERT_USERS_SQL="INSERT INTO users (first_name,last_name,username,password) values(?,?,?,?);";
		
		int result=0;
		
		try {
			Connection connection=JDBCUtils.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			
			System.out.println(preparedStatement);
			
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			JDBCUtils.printSQLException(e);
		}
		return result;
		
	}

}
