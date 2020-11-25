<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
	<h1>/1124/main page</h1>
	<h1> <%=request.getAttribute("msg") %></h1>
	<h1> <%=request.getAttribute("msg2") %></h1>
	<h1> <%=session.getAttribute("memId") %></h1>
</body>
</html>