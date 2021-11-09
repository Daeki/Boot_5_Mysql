<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrapCDN.jsp"></c:import>
</head>
<body>
	
	<div class="container mt-3">
		<h1>${board} Insert Page</h1>
	
		<form:form modelAttribute="boardVO" enctype="multipart/form-data">
			<div class="mb-3 mt-3">
				<label for="title">Title:</label>
				<form:input path="title" id="title" cssClass="form-control"/>
			</div>
			<div>
				Writer : <form:input path="writer" cssClass=""/>
			</div>
			<div>
				Contents : <form:textarea path="contents"/>
			</div>
			
			<div>
				<input type="file" name="files"><br>
				<input type="file" name="files">
			</div>
			
			<div>
				<button type="submit">Write</button>
			</div>
			
		
		</form:form>
	
	</div>
	
	
	
	
	
	

	
</body>
</html>