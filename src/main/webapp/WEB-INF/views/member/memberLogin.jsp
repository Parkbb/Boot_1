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
<form action="./memberLogin" method="post">
  <div class="form-group  col-sm-3">
    <label for="id">Email address:</label>
    <input type="id" class="form-control" placeholder="Enter id" id="id" name="id">
  </div>
  <div class="form-group  col-sm-3">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pw">
  </div>
  <div class="form-group form-check  col-sm-3">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>