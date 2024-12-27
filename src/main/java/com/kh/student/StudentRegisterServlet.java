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
/*
 * 학생 정보 등록
 * url : /student/register
 */
@WebServlet("/student/register")
public class StudentRegisterServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> sList = new ArrayList<Student>();
		String name = request.getParameter("name");
		int firstScore, secondScore;
		firstScore = Integer.parseInt(request.getParameter("firstScore")); // 원인 및 해결방안
		secondScore = Integer.parseInt(request.getParameter("secondScore"));
		// 원인 : 문자열을 int로 변환할 수 없음.
		// 해결방안 : 문자열을 int로 변환해주면 됨. 어떻게?
		// => Integer.parseInt("")
		sList.add(new Student("일용자", 99, 88));
		sList.add(new Student("이용자", 88, 77));
		RequestDispatcher view;
		for(Student std: sList) {
			if(std.getName().equals(name)) {
//				System.out.println("이미 존재하는 이름입니다.");
				view = request.getRequestDispatcher("/WEB-INF/views/common/duplicate.html");
				view.forward(request, response);
				return;		// 메소드를 종료하여 밑에 코드가 안돌아가도록 함.
			}
		}
//		System.out.println("==========================");
		sList.add(new Student(name, firstScore, secondScore));
		view = request.getRequestDispatcher("/WEB-INF/views/common/success.html");
		view.forward(request, response);
//		System.out.println("가입이 완료되었습니다.");
//		for(Student std: sList)
//			System.out.println(std);
	}
}
