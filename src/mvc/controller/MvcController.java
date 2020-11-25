package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcController extends HttpServlet {
	
	public void init(ServletConfig config) {
		// web.xml에서 설정한 init parameter 값을 받음
		String uri = config.getInitParameter("action");
		// java.util.Properties Class - properties file 로딩 
		// properties Class = Map (key , value), 1byte file(영어와 숫자만 사용)
		try {
			Properties p = new Properties();
			InputStream is = new FileInputStream(uri);
			p.load(is);
			System.out.println(p);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		System.out.println("controller start");
		// 사용자 요청 주소(URI)
		String uri = request.getRequestURI();
		System.out.println("요청 URI = "+uri);
		
		// 컨트롤러 페이지 이동 방법 
		String view = "";
		if(uri.equals("/mvc/member/loginForm.do")) {
			// java code (model 처리 영역)
			// DAO / DTO (요청 처리를 위한 클래스 사용)
			// Controller 에서 처리 해야할 로직을 따로 분리 -> 액션클래스(비즈니스 로직 처리용)
			// view 파일과 action 파일 같이 사용
		}else if(uri.equals("/mvc/member/loginPro.do")) {
			// java code
		}else if(uri.equals("/mvc/member/main.do")) {
			// java code
		}
		request.getRequestDispatcher(view).forward(request, response);
		*/
	}
}
