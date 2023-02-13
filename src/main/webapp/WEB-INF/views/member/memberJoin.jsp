<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Member Join Page</h1>
	
	<div class="col-6">
		<form action="./join" method="post">
			아이디
			<input type="text" name="id" value="test"><br>
			비밀번호
			<input type="password" name="pw"><br>
			
			<button type="submit">회원가입</button>
			
		</form>
	</div>
</body>
</html>