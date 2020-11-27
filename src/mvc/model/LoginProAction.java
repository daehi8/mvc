package mvc.model;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;

public class LoginProAction implements SuperAction {
	
	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
				
		String id = request.getParameter("id");
		String passwd  = request.getParameter("passwd");
		
		LogonDBBean dao = LogonDBBean.getInstance();
	    try {
			int check= dao.userCheck(id,passwd);
			if(check == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("memId", id);
			}
			request.setAttribute("check", check);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	    
		return "/WEB-INF/views/member/loginPro.jsp";
	}
}
