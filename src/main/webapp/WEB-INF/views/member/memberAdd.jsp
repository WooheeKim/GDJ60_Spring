<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<c:import url="../template/common_css.jsp"></c:import>
	
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid my-5">
		<div class="row mb-4">
			<h1 class="col-md-5 mx-auto text-center border-bottom border-dark-pb-3">회원가입 페이지</h1>
		</div>
	
	<form action=""></form>
	  	<div class="col-md-4 mb-3">
	    	<label for="exampleId" class="form-label">아이디</label>
	    	<input type="text" class="form-control" name="exampleId" placeholder="사용 할 아이디를 입력해주세요">
  		</div>
  		<div class="col-md-4 mb-3">
		    <label for="examplePassword" class="form-label">패스워드</label>
		    <input type="password" class="form-control" name="examplePw" placeholder="사용 할 패스워드를 입력해주세요">
  		</div>
  		<button type="submit" class="btn btn-primary">회원가입</button>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>