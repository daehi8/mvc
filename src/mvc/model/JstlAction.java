package mvc.model;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch11.logon.LogonDataBean;

public class JstlAction implements SuperAction{

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList list = new ArrayList();
			LogonDataBean dto = new LogonDataBean();
			dto.setId("java");
			dto.setPasswd("1234");
		list.add(dto);
		list.add(dto);
		
		Date day = new Date();
		
		request.setAttribute("day", day);
		request.setAttribute("list", list);
		
		return "/1126/jstl.jsp";
	}

}
