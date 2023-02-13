<%@page import="java.util.List"%>
<%@page import="com.woo.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트 페이지</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1 class="col-md-7 mx-auto text-center border-bottom border-dark-pb-3">Product List Page</h1>
	
	<div class="row col-md-7 mx-auto">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품명</th>
					<th>평점</th>
				</tr>
			</thead>
			
			<tbody>		
				<c:forEach items="${list}" var="dto"> <!-- dto는 page영역에 담김 -->
					<tr>
						<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
						<td>${dto.productJumsu}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row col-md-7 mx-auto">
			<a href="./add" class="btn btn-primary col-2">상품등록</a>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>