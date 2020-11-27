package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormAction implements SuperAction {
	
	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("LoginFormAction Start");
		return "/WEB-INF/views/member/loginForm.jsp";
	}
}
