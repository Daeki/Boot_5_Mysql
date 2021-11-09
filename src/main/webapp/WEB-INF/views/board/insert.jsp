<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Insert Page</h1>
	
	
	<form:form modelAttribute="boardVO" enctype="multipart/form-data">
		<div>
			TITLE : <form:input path="title"/>
		</div>
		<div>
			Writer : <form:input path="writer"/>
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
	
	
	
	
	
	
	
	

	
</body>
</html>