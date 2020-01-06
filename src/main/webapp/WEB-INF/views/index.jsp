<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="template/BS.jsp" />
</head>
<body>
<c:import url="template/nav.jsp" />
<div class="container">
<spring:message code="hello"></spring:message>
	<form action="./">
		<select name="locale">
			<option>KO</option>
			<option>EN</option>
		</select>
		<button class="btn btn-success">Change</button>
	</form>
<h1>
</h1>

<div class="container">
	<img src="./images/iu1.jpg">
</div>
</div>
</body>
</html>