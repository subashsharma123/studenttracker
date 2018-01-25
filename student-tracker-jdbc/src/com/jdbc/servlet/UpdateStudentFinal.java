package com.jdbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.jdbc.servlet.model.Student;
import com.mysql.jdbc.PreparedStatement;

import jdk.nashorn.internal.objects.annotations.Where;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/UpdateStudentFinal")
public class UpdateStudentFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateStudentFinal() {
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
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");

			Connection connection = (Connection) DriverManager.getConnection(url, userName, password);
			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("update student set first_name=? ,last_name=? ,email=? where id =?");
			preparedStatement.setInt(4, id);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			int resultSet = preparedStatement.executeUpdate();
			if (resultSet > 0) {

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
