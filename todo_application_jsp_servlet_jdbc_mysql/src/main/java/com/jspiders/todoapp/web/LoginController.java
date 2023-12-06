package com.jspiders.todoapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import com.jspiders.todoapp.dao.LoginDao;
import com.jspiders.todoapp.model.LoginBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	
	public void init() {
		loginDao=new LoginDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login/login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		authenticate(req,resp);
	}

	private void authenticate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		LoginBean loginBean=new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if (loginDao.validate(loginBean)) {
				jakarta.servlet.RequestDispatcher dispatcher=req.getRequestDispatcher("todo/todo-list.jsp");
				dispatcher.forward(req, resp);
				
			}
			else {
				HttpSession httpSession=req.getSession();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	

}
