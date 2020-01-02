<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/BS.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />
<div class="card" style="width:400px">
  <img class="card-img-top" src="../upload/${member.fname}" alt="Card image">
  <div class="card-body">
    <h4 class="card-title">${member.name}</h4>
    <p class="card-text">${member.email}</p>
    ${member.fnum}
    <a href="#" class="btn btn-primary">정보 수정</a>
    <a class="btn btn-primary" href="./memberFileDown?fnum=${member.fnum}">FileDown</a>
  </div>
</div>
</body>
</html>