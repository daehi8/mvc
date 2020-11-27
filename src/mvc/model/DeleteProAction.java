package mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch11.logon.LogonDBBean;

public class DeleteProAction implements SuperAction{

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
	    
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		String passwd  = request.getParameter("passwd");
		
		LogonDBBean dao = LogonDBBean.getInstance();
		try {
			int check = dao.deleteMember(id,passwd);
			if(check==1){
				session.invalidate();
			}
			request.setAttribute("check", check);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/WEB-INF/views/member/deletePro.jsp";
	}

}
