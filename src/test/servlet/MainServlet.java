package test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 웹에서의 요청 = 주소를 통해 페이지 실행
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainServlet run");
		
		// 뷰페이지로 포워딩 = <jsp:forword>
		// view file = jsp / html
		// 처리결과를 request 속성에 저장
		request.setAttribute("msg", "hello hello");
		request.setAttribute("msg2", 700);
		
		// request 객체를 활용한 session 객체 생성
		HttpSession session = request.getSession();
		session.setAttribute("memId", "java");		
		
		request.getRequestDispatcher("/1124/main.jsp").forward(request, response);
	}
}
