package mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller start");
		// 사용자 요청 주소(URI)
		String uri = request.getRequestURI();
		System.out.println("요청 URI = "+uri);
		
		// 컨트롤러 페이지 이동 방법 
		String view = "";
		if(uri.equals("/mvc/member/loginForm.do")) {
			// java code (model 처리 영역)
		}else if(uri.equals("/mvc/member/loginPro.do")) {
			// java code
		}else if(uri.equals("/mvc/member/main.do")) {
			// java code
		}
		request.getRequestDispatcher(view).forward(request, response);
	}
}
