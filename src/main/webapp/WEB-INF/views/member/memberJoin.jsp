<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/BS.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />

<form:form action="./memberJoin" method="post" enctype="multipart/form-data" modelAttribute="memberVO">
	<div class="form-group col-sm-3">
    	<label for="id">ID:</label>
    	<form:input path="id" id="id" class="form-control" placeholder="Enter ID"/>
    	<form:errors path="id" cssStyle="color:red;"></form:errors>
  	</div>
	
	<div class="form-group col-sm-3">
    	<label for="pw">PW:</label>
    	<form:password path="pw" id="pw" class="form-control" placeholder="Enter PW"/>
  	</div>
  	
  	<div class="form-group col-sm-3">
    	<label for="pw">PW:</label>
    	<form:password path="pw2" id="pw2" class="form-control" placeholder="Enter PW"/>
  	</div>
	
	<div class="form-group col-sm-3">
    	<label for="name">NAME:</label>
    	<form:input path="name" id="name" class="form-control" placeholder="Enter NAME"/>
  	</div>
  	
  	<div class="form-group col-sm-3">
    	<label for="email">EMAIL:</label>
    	<form:input path="email" id="email" class="form-control" placeholder="Enter EMAIL"/>
  	</div>
	
	<div class="form-group col-sm-3">
    	<label for="files">Name:</label>
    	<input type="file" class="form-control" id="files" name="files">
	</div>
	
	<form:button class="btn btn-primary">SUBMIT</form:button>
	<button type="submit" class="btn btn-primary">Submit</button>
	
</form:form>

</body>
</html>