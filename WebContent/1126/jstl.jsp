<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSTL 선언 --%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl page</h1>
	
	<%-- 변수 선언 태그 setAttribut("msg","hello"); --%>
	<c:set var="msg" value="hello"/>
	<c:set var="num" value="100"/>
	<h1>msg = ${msg}</h1>
	
	<!--
	실제 많이 사용되는 if문 태그
	else문 사용 불가능 
	-->
	<c:if test="${num > 0 }">
		0보다 크다
	</c:if>
	<c:if test="${num < 0 }">
		0보다 작다
	</c:if>
	<c:if test="${num == 0 }">
		0보다 작다
	</c:if><br />
	
	<!-- 조건문 태그 if문과 유사 -->
	<c:choose>	
		<%-- if --%>
		<c:when test="${num > 0}">
			0보다 크다
		</c:when>
		
		<%-- else if --%>
		<c:when test="${nim < 0}">
			0보다 작다
		</c:when>
		
		<%-- else --%>
		<c:otherwise>
			0과 같다
		</c:otherwise>		
	</c:choose><br />
	
	<!-- for 반복문 -->
	<c:forEach var="a" begin="1" end="10" step="2">
		${a}
	</c:forEach><br />
	
	<!-- forEach 반복문 ArrayList와 DTO 사용-->
	<c:forEach var="x" items="${list}">
		${x.id}====${x.passwd} <br />
	</c:forEach>
	
	<!-- 특정 부분을 구분으로 나눠서 반복 -->
	<c:forTokens var = "y" items="aaa,bbb,ccc,ddd" delims=",">
	${y} <br />
	</c:forTokens>
	
	<!-- page include -->
	<c:import var="test" url="http://localhost:8080/mvc/form.do" />
	${test} <br />
	
	<!-- 날짜형식 설정 -->
	<h1>${day}</h1>
	default = <fmt:formatDate value="${day}"/>
	both = <fmt:formatDate value="${day}" type="both"/><br />
	date = <fmt:formatDate value="${day}" type="date"/><br />
	time = <fmt:formatDate value="${day}" type="time"/><br /><br />
	
	<!-- dateStyle 설정 -->
	medium = <fmt:formatDate value="${day}" type="both" dateStyle="medium"/><br />
	full = <fmt:formatDate value="${day}" type="both" dateStyle="full"/><br />
	short = <fmt:formatDate value="${day}" type="both" dateStyle="short"/><br />
	long = <fmt:formatDate value="${day}" type="both" dateStyle="long"/><br />
	default = <fmt:formatDate value="${day}" type="both" dateStyle="default"/><br /><br />
	
	<!-- timeStyle 설정 -->
	medium = <fmt:formatDate value="${day}" type="both" timeStyle="medium"/><br />
	full = <fmt:formatDate value="${day}" type="both" timeStyle="full"/><br />
	short = <fmt:formatDate value="${day}" type="both" timeStyle="short"/><br />
	long = <fmt:formatDate value="${day}" type="both" timeStyle="long"/><br />
	default = <fmt:formatDate value="${day}" type="both" timeStyle="default"/><br /><br />
	
	<!-- 날짜형식을 직접 설정 -->
	pattern = <fmt:formatDate value="${day}" type="both" pattern="yyyyMMdd"/><br />
	
	<!-- 시간기준 GMT 설정 -->	
	<fmt:timeZone value="GMT">
		<fmt:formatDate value="${day}" type="both" dateStyle="full"/><br /><br />
	</fmt:timeZone>
	
	<!-- number 설정 -->
	<fmt:formatNumber value="123456.789" type="number"/><br />
	<fmt:formatNumber value="123456.789" type="currency" currencySymbol="\\"/><br />
	<fmt:formatNumber value="123456.789" type="currency" currencySymbol="$"/><br />
	<fmt:formatNumber value="123456.789" type="percent"/><br />
	<fmt:formatNumber value="123456.789" pattern=".00"/><br />
	
	<!-- encoding 설정 -->
	<fmt:requestEncoding value="UTF-8"/>
</body>
</html>