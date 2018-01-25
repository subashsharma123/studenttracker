package com.jdbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.servlet.model.Student;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		// printWriter.println("Hello");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
			String userName = "root";
			String password = "test";
			int id = Integer.parseInt(request.getParameter("studentId"));
			Connection connection = (Connection) DriverManager.getConnection(url, userName, password);

			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(" delete from student where id=?");
			statement.setInt(1, id);
			int resultSet = statement.executeUpdate();
			if (resultSet > 0) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("GetStudent");
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
