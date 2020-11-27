package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProAction implements SuperAction {
	
	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ProAction Start");
		return "/WEB-INF/views/member/loginPro.jsp";
	}
}
