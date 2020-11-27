package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	Action Class 생성 조건
	1. SuperAction interface 구현
	
 */
public class MainAction implements SuperAction {

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MainAction Start");
		return "/WEB-INF/views/member/main.jsp";
	}

}
