package mvc.model;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;

public class ConfirmIdAction implements SuperAction{

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
	    String id = request.getParameter("id");
		LogonDBBean dao = LogonDBBean.getInstance();
	    try {
			int check= dao.confirmId(id);
			request.setAttribute("check", check);
			request.setAttribute("id", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/member/confirmId.jsp";
	}

}
