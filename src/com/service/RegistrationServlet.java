package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;

import com.hibername.AddUsers;
import com.model.Registration;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Registration regis = new Registration(request.getParameter("name"), request.getParameter("username"),
				request.getParameter("email"), request.getParameter("password"));

		AddUsers user = new AddUsers();
		
		if (user.Register(regis) > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("name", request.getParameter("name"));
			response.sendRedirect("registerSuccess.jsp");
		} else {
			response.sendRedirect("registerFail.jsp");
		}
	}

}
