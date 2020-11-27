package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyAction implements SuperAction{

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		
		return "/WEB-INF/views/member/modify.jsp";
	}

}
