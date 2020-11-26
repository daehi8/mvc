package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormAction implements SuperAction{

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		
		return "/1126/form.jsp";
	}

}
