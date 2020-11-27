package mvc.model;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

public class InputProAction implements SuperAction{

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		LogonDataBean dto = new LogonDataBean();
		dto.setId(request.getParameter("id"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setName(request.getParameter("name"));
		dto.setJumin1(request.getParameter("jumin1"));
		dto.setJumin2(request.getParameter("jumin2"));
		dto.setEmail(request.getParameter("email"));
		dto.setBlog(request.getParameter("blog"));
		
		LogonDBBean dao = LogonDBBean.getInstance();
	    try {
			dao.insertMember(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return "/WEB-INF/views/member/inputPro.jsp";
	}

}
