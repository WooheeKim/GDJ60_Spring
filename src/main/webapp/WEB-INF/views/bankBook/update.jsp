<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">

	<div class="row justify-content-center my-4">
		<h1 class="col-md-7 text-center">상품 수정 Page</h1>
	</div>
	
	<div class="row justify-content-center my-4">
		<form class="col-md-7" action="./update" method="post">
			<input type="hidden" name="bookNumber" value="${dto.bookNumber}">
			<div class="mb-3">
			  <label for="bookName" class="form-label">제품명</label>
			  <input type="text" name="bookName" class="form-control" value="${dto.bookName}" id="bookName" placeholder="제품명 입력">
			</div>
			
			<div class="mb-3">
			  <label for="bookRate" class="form-label">이자율</label>
			  <input type="text" name="bookRate" class="form-control" value="${dto.bookRate}" id="bookRate" placeholder="이자율 입력">
			</div>
	
			<div class="mb-3">
			  <label for="bookDetail" class="form-label">상세설명</label>
			  <textarea name="bookDetail" class="form-control" id="bookDetail" placeholder="설명 입력" rows="7">${dto.bookDetail}</textarea>
			</div>	
<!-- 	
			<div class="mb-3">
				<label class="form-label">판매여부</label>
				<div class="form-check">
				  <input class="form-check-input" checked type="radio" name="bookSale" id="bookSale1" value="1">
				  <label class="form-check-label" for="bookSale1">
				    판매중
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="bookSale" id="bookSale2" value="0">
				  <label class="form-check-label" for="bookSale2">
				    판매중단
				  </label>
				</div>		
			</div>
	 -->		
			<div class=" mb-3 form-check form-switch">
			   <label class="form-check-label" for="bookSale">판매여부</label>
			   <input name="bookSale" class="form-check-input" ${dto.bookSale==1?'checked':''} value="1" type="checkbox" role="switch" id="bookSale">
			</div>
			
			<div class="mb-3">
				<button class="my btn btn-danger" type="submit">수정</button>
			</div>
		
		</form>
	</div>
</div>	
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>