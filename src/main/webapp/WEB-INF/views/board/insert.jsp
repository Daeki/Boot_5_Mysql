<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrapCDN.jsp"></c:import>
</head>
<body>
	
	<div class="container mt-3 col-6" >
		<h1>${board} Insert Page</h1>
	
		<form:form cssClass="needs-validation" modelAttribute="boardVO" enctype="multipart/form-data">
			<div class="form-floating mb-3 mt-3">
				<form:input path="title" id="title" placeholder="Enter title" cssClass="form-control"/>
				<label for="title">Title</label>
				<form:errors path="title" cssStyle="invalid-feedback"></form:errors>
				
			</div>
			<sec:authentication property="principal.id" var="id" />
			<div class=" form-floating mb-3">
				<input type="text" id="writer" value="${id}" placeholder="Enter writer" class="form-control"/>
				<label for="writer">Writer</label>
			</div>
			<div class= "mb-3">
				<form:textarea path="contents" rows="10" id="contents" placeholder="Enter contents" cssClass="form-control"/>
			</div>
			
			<div class="mb-3 input-group-sm">
				<input type="file" name="files">
			</div>
			<div class="mb-3 input-group-sm">
				<input type="file" name="files">
			</div>
			
			<div class="mb-3 input-group-sm">
				<button class="btn btn-dark" type="submit">Write</button>
			</div>
			
		
		</form:form>
	
	</div>
	
	
	
	
	
	

	
</body>
</html>