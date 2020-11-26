<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String num = "100";
		int n = Integer.parseInt(num);
	%>
	
	<h1> id = <%=id %></h1>
	<h1> id = ${id}</h1>
	<h1> num = <%=num+100%></h1>
	<h1> num = ${num+"100"}</h1>
	
	<%--
	EL에서는 자동으로 형변환
	abcd를 int로 변환 시도해서 NumberFormatException 발생 
	
	<h1> num = ${num+"abcd"}</h1>

	EL은 대입기능이 불가능 
	비교연산자만 가능
	표현언어이기때문에 set기능 불가능
	null값 대신 공백이 출력
	
	<%String memId = (String)session.getAttribute("memId");%> -> ${memId}
	
	<%=dto.getId()%> -> ${dto.id}
	--%>
		
</body>
</html>