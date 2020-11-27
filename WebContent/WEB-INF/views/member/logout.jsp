<% 
	session.invalidate();
	response.sendRedirect("/mvc/member/main.do");
	%>