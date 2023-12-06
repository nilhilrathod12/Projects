package com.jspiders.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/MyServlet2")
public class MyServlet2 extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Hellow World</h1>");
		
	}

}
