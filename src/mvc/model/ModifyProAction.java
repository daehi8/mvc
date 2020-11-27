package mvc.model;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class ModifyProAction implements SuperAction{

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		
		System.out.println(sessionId + "/");
		LogonDataBean dto = new LogonDataBean();
		dto.setPasswd(request.getParameter("passwd"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setBlog(request.getParameter("blog"));
		dto.setId(sessionId);
		
		LogonDBBean dao = LogonDBBean.getInstance();	
		
		try {
			dao.updateMember(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/WEB-INF/views/member/modifyPro.jsp";
	}

}
