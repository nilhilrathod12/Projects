package com.jspiders.todoapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.jspiders.todoapp.dao.TodoDao;
import com.jspiders.todoapp.dao.TodoDaoImpl;
import com.jspiders.todoapp.model.Todo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class TodoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TodoDao todoDAO;
	public void init() {
		todoDAO=new TodoDaoImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getServletPath();
		switch (action) {
		case "/new":
			showNewForm(req,resp);
			break;
		case "/insert":
			try {
				insertTodo(req,resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteTodo(req,resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit":
			showEditFrom(req,resp);
			break;
		case "/update":
			try {
				updateTodo(req,resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/list":
			listTodo(req,resp);
			break;

		default:
			jakarta.servlet.RequestDispatcher dispatcher=req.getRequestDispatcher("login/login.jsp");
			dispatcher.forward(req, resp);
			break;
		}
	}
	private void listTodo(HttpServletRequest req, HttpServletResponse resp) {
		 try {
			List<Todo> todos=todoDAO.selectAllTodos();
			req.setAttribute("listTodo", todos);
			RequestDispatcher dispatcher=req.getRequestDispatcher("todo/todo-list.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private void updateTodo(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 String titile=req.getParameter("title");
			String username=req.getParameter("username");
			String description=req.getParameter("description");
			LocalDate targetDate=LocalDate.parse(req.getParameter("targetDate"));
			boolean isDone=Boolean.valueOf(req.getParameter("isDone"));
			Todo updateTodo =new Todo(null, titile, username, description, targetDate, isDone);
			todoDAO.updateTodo(updateTodo);
			resp.sendRedirect("list");
		
	}
	private void showEditFrom(HttpServletRequest req, HttpServletResponse resp) {
	   int id=Integer.parseInt(req.getParameter("id"));
	   try {
		Todo existingTodo=todoDAO.selectTodo(id);
		RequestDispatcher dispatcher=req.getRequestDispatcher("todo/todo-form.jsp");
		req.setAttribute("todo", existingTodo);
		
		dispatcher.forward(req, resp);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	private void deleteTodo(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 todoDAO.deleteTodo(id);
		 resp.sendRedirect("list");
		
		
	}
	private void insertTodo(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		String titile=req.getParameter("title");
		String username=req.getParameter("username");
		String description=req.getParameter("description");
		boolean isDone=Boolean.valueOf(req.getParameter("isDone"));
		Todo todo=new Todo(titile, username, description, LocalDate.now(), isDone);
		
			todoDAO.insertTodo(todo);
			resp.sendRedirect("list");
		
		
	}
	private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("todo/todo-form.jsp");
		dispatcher.forward(req, resp);
		
	}
	

}
