package com.kh.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/insert")
public class StudentInsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> sList = new ArrayList<Student>();
		sList.add(new Student("일용자", 99, 88));
		sList.add(new Student("이용자", 88, 77));
		String name = request.getParameter("name");
		String message = "";
		for(Student std: sList) {
			if(std.getName().equals(name)) {
				message = "이미 존재하는 이름입니다.";
				// 이미 존재
				// 페이지 생성 + 변수에 넣은 값을 출력 -> JSP로 가능
				request.setAttribute("message", message);
				RequestDispatcher view;
				view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
				view.forward(request, response);
				return;
			}
		}
		message = "존재하지 않습니다.";
		request.setAttribute("message", message);
		RequestDispatcher view;
		view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		return;
	}

}
