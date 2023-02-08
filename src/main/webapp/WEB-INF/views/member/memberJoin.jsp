<%@page import="java.util.List"%>
<%@page import="com.woo.s1.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join Page</h1>
	
		<form action="./memberJoin" method="post">
			아이디
			<input type="text" name="id" placeholder="아이디를 입력하세요"><br>
			비밀번호
			<input type="password" name="pw" placeholder="비밀번호를 입력하세요"><br>
			이름
			<input type="text" name="name" placeholder="이름을 입력하세요"><br>
			휴대폰
			<input type="tel" name="phone" placeholder="휴대폰 번호를 입력하세요"><br>
			이메일
			<input type="email" name="email" placeholder="이메일을 입력하세요">
			
			<button type="submit">회원가입</button>
			
		</form>
</body>
</html>