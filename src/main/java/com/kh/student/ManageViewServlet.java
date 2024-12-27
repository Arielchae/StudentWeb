package com.kh.student;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 * 관리 페이지를 보여줄 url
 * url : /student/manage
 */
@WebServlet("/student/manage")
public class ManageViewServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view;
		view = request.getRequestDispatcher("/WEB-INF/views/student/manage1.jsp");
		view.forward(request, response);
	}
}
