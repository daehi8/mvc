package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.SuperAction;

public class MvcController extends HttpServlet {
	
	// 사용자가 접속하면 객체를 모두 자동생성
	private Map action = new HashMap();	
	public void init(ServletConfig config) {
		System.out.println("init start");
		// web.xml에서 설정한 init parameter 값을 받음
		String uri = config.getInitParameter("action");
		// java.util.Properties Class - properties file 로딩 
		// properties Class = Map (key , value), 1byte file(영어와 숫자만 사용)
		try {
			Properties p = new Properties();
			InputStream is = new FileInputStream(uri);
			p.load(is);
			
			// 모든 값을 enu에 저장한 후 key와 value로 나눠서 꺼낸다
			// 객체를 생성한 후 obj에 저장한다
			// Map에 값을 보낸다
			Enumeration enu = p.keys();
			while(enu.hasMoreElements()) {
				String key = (String)enu.nextElement();
				String value = p.getProperty(key);
				Class c = Class.forName(value);
				Object obj = c.newInstance();
				action.put(key, obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// SuperAction interface에 추상메소드를 만든 후
	// Action Class에서 상속
	// 접속한 URI를  key로 obj class에 대입 (key에 맞는 value 찾기)
	// init에서 value를 이름으로 한  Class를 객체 생성한 후 obj로 만들었었다.
	// interface 다형성 -> SuperAction의 method가 실행되지만 obj에 따라 바뀐다.
	// Action Class의 return 값을  view에 저장 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service start");
		String key = request.getRequestURI();
		String view = "";
		if(key != null) {
			Object obj = action.get(key);
			if(obj!= null) {
				SuperAction sa = (SuperAction)obj;
				view = sa.requestAction(request, response);
			}
		}
		request.getRequestDispatcher(view).forward(request, response);
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
