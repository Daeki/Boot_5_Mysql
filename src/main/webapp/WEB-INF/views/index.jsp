<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/test.css">
</head>
<body>
	<!-- HTML 주석 -->
	<h1>Index Page</h1>
	<div>
	<c:choose>
		<%-- jsp 주석 --%>
		<c:when test="${not empty member}">
			<h3> ${member.name}님 환영합니다 </h3>
			<a href="./member/memberLogout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="./member/memberLogin">Login</a>
			<a href="./member/memberJoin">Join</a>
		</c:otherwise>
	</c:choose>	
	</div>
	<img alt="iu1.jpg" src="./images/iu1.jpg">
	<img alt="front" src="./front/iu2.jpg">
</body>
</html>