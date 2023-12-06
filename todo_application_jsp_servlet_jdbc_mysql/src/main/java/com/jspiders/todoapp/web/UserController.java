package com.jspiders.todoapp.web;

import java.io.IOException;

import com.jspiders.todoapp.dao.UserDao;
import com.jspiders.todoapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/register")
public class UserController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
    private UserDao userDao;
    
    public void init() {
    	userDao=new UserDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	register(req,resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.sendRedirect("register/register.jsp");
    }

	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User employee=new User();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);
		
		try {
			int result=UserDao.registerEmployee(employee);
			if (result==1) {
				req.setAttribute("NOTIFICATION", "User Registered Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jakarta.servlet.RequestDispatcher dispatcher=req.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	
	

}
