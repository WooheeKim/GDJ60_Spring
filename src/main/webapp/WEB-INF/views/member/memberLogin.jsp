<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
		<div class="container-fluid">
			<div class="row justify-content-center">
				<h1 class="col-md-7 my-5">Member Login</h1>
			</div>
			<div class="row justify-content-center my-5">
				<form class="col-md-7 mx-auto center" action="memberLogin" method="post">
				  <div class="mb-3">
				    <label for="exampleId" class="form-label">ID</label>
				    <input type="text" class="form-control" id="exampleId">
				    <div id="IdHelp" class="form-text">We'll never share your ID with anyone else.</div>
				  </div>
				  <div class="mb-3">
				    <label for="examplePassword" class="form-label">Password</label>
				    <input type="password" class="form-control" id="examplePassword" name="examplePassword">
				  </div>
				  <div class="mb-3 form-check">
				    <input type="checkbox" class="form-check-input" id="exampleCheck">
				    <label class="form-check-label" for="exampleCheck">ID Check</label>
				  </div>
				  <button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
		
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>