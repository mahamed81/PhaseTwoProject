package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hibername.AddUsers;
import com.model.Registration;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AddUsers user = new AddUsers();

		if (user.verifyUser(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", username);
			
			response.sendRedirect("loginSuccess.jsp");
		} else {
			response.sendRedirect("loginFail.jsp");
		}

	}

}
