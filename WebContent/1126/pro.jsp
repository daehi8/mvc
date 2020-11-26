<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	<h1>이름 : <%= request.getParameter("name") %></h1>
	<h1>이름 : ${param.name}</h1>
	<h1>번호 : ${param.num}</h1>
	<h1>번호+100 : ${param.num+100}</h1>
	--%>
	
	<!-- ActionClass의 setAttribute 값 확인 -->
	<h1>이름 : ${requestScope.name}</h1>
	<h1>번호 : ${requestScope.result}</h1>
	
	<!-- request와 같은 이름을 가진 setAttribute가 없을경우 Scope 생략가능 -->
	<h1>번호 : ${result}</h1>
	
	<!-- dto get method 생략 가능-->
	<h1>id : ${dto.id}</h1>
	<h1>passwd : ${dto.passwd}</h1>
	<h1>name : ${dto.name}</h1>
	<h1>name : ${dto.getName()}</h1>
	
	<!-- ArrayList get method 생략 가능 -->
	<h1>list : ${list[0]}</h1>
	<h1>list : ${list.get(1)}</h1>
	
	<!-- ArrayList DTO 사용 -->
	<h1>dto : ${list[2]}</h1>
	<h1>dto : ${list[2].id}</h1>
	<h1>dto : ${list[2].passwd}</h1>
</body>
</html>