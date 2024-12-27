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
 * 학생 정보 삭제
 * url : /student/remove
 */
@WebServlet("/student/remove")
public class StudentRemoveServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> sList = new ArrayList<Student>();
		sList.add(new Student("일용자", 99, 88));
		sList.add(new Student("이용자", 88, 77));
		sList.add(new Student("삼용자", 77, 66));
		sList.add(new Student("사용자", 88, 76));
//		for(Student std: sList)
//			System.out.println(std);
		//sList.remove(0);
		// 이름이 입력된다고 했을 떄
		// 해당 이름이 있으면 지우고, 없으면 이름이 없다고 메시지 출력하도록
		// 코드를 작성해보세요~
		String name = request.getParameter("name");
		String message = "";
		boolean isExist = false;
		RequestDispatcher view;
		for(Student std: sList) {
			if(std.getName().equals(name)) {
//				System.out.println(std);
//				sList.remove(std);
				isExist = true;
				break;
				//System.out.println(std.getName() + "학생의 데이터가 삭제되었습니다.");
//				return;
			}
		}
		//데이터가 있으면 isExist는 true가 되고 삭제되었다는 내용이 message 변수에 담김
		if(isExist) {
			message = "학생의 데이터가 삭제되었습니다.";
		}else {
			// 데이터가 없으면 isExist는 false가 되고 검색한 것이 없다는 내용이 message 변수에 담김
			message = "검색한 이름이 존재하지 않습니다.";
		}
		// message 값이 request 에 저장 됨.
		request.setAttribute("message", message);
		// 해당 jsp로 페이지 이동이 되는데 message 내용도 함께 전달되는 것으로 볼 수 있음.
		view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		//System.out.println("검색한 이름이 존재하지 않습니다.");
//		sList.remove(0);
//		for(Student std: sList)
//			System.out.println(std);
			
	}
}
