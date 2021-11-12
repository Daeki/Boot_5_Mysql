<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/test.css">
</head>
<body>
	<!-- HTML 주석 -->
	<h1>Index Page <spring:message code="hello.hi"></spring:message></h1>
	<div>
		<spring:message code="hello" var="m" text="Default Message"></spring:message>

			
		<sec:authorize access="isAuthenticated()" var="result">
			<a href="./member/usePrincipal">usePrincipal</a>
			<a href="./member/useSession">useSession</a>
		
			<h3>${result}</h3>
			<h3>MemberVO : <sec:authentication property="principal" var="memberVO"/></h3>
			<h3>MemberVO.ID : <sec:authentication property="principal.id" var="id"/></h3>
			<h3>${memberVO}</h3>
			<h3>${id}</h3>
			<h3>${memberVO.email}</h3>
			<a href="./member/memberLogout">Logout</a>
		</sec:authorize>
		
		<sec:authorize access="!isAuthenticated()" var="result">
			<h3>${result}</h3>
			<a href="./member/memberLogin">Login</a>
			<a href="./member/memberJoin">Join</a>
		</sec:authorize>
	</div>
	<h1>${m}</h1>
	<img alt="iu1.jpg" src="./images/iu1.jpg">
	<img alt="front" src="./front/iu2.jpg">
</body>
</html>