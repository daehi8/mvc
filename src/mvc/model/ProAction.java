package mvc.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch11.logon.LogonDataBean;

public class ProAction implements SuperAction{

	@Override
	public String requestAction(HttpServletRequest request, HttpServletResponse response) {
		
		// form에서 받은 값 확인
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		int n = Integer.parseInt(num) + 100;
		
		// dto 사용
		LogonDataBean dto = new LogonDataBean();
		dto.setId("java");
		dto.setPasswd("1234");
		dto.setName("web");
		
		// ArrayList 사용
		ArrayList list = new ArrayList();
		list.add("hello");
		list.add(123);
		list.add(dto);
		
		// view로 값 전달
		request.setAttribute("list", list);
		request.setAttribute("dto", dto);
		request.setAttribute("result", n);
		request.setAttribute("name", name);
		
		// session.setAttribute("result", "aaa");
		
		return "/1126/pro.jsp";
	}

}
