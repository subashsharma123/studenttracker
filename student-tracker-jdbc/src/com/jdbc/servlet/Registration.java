package com.jdbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		// printWriter.println("Hello");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
			String userName = "root";
			String password = "test";
			Connection connection = (Connection) DriverManager.getConnection(url, userName, password);

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement("insert into student(first_name,last_name, email) values (?,?,?)");

			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);

			int rSet = statement.executeUpdate();
			if (rSet > 0) {
				printWriter.println("User added successfully");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/GetStudent");
				requestDispatcher.forward(request, response);

			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		catch (

		SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
