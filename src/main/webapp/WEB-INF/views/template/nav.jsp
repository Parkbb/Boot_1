<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- A grey horizontal navbar that becomes vertical on small screens -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-end">
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
    </li>
    
   <c:if test="${empty sessionScope.memberVO}">
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/member/memberJoin">Join</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogin">Login</a>
    </li>
   </c:if>
   
   <c:if test="${not empty sessionScope.memberVO}">
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/member/Mypage">MyPage</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/member/memberLogOut">LogOut</a>
    </li>
   </c:if>
    
  </ul>
</nav>
