<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${boardName} Add Page</title>
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row md-6">
			<h1 class="col-md-7 mx-auto text-center border-bottom border-dark-pb-3">상품등록 페이지</h1>
		</div>
	
	<form class="col-md-7 mx-auto center" action="./add" method="post" enctype="multipart/form-data">
		<div class="row mb-3">
   			<label for="writer" class="col-sm-0 col-form-label">작성자</label>
   			<div class="col-sm-6">
     			<input name="writer" type="text" class="form-control" id="writer">
   			</div>
 		</div>
	
		<div class="row mb-3">
   			<label for="title" class="col-sm-0 col-form-label">제목</label>
			<div class="col-sm-6">
				<input name="title" type="text" class="form-control" id="title" placeholder="제목을 입력하세요">
			</div>
		</div>
		
		<div class="row mb-3">
   			<label for="contents" class="col-sm-0 col-form-label">내용</label>
  			<div class="col-sm-6">
   				<textarea name="contents" class="form-control" id="contents" placeholder="내용을 입력하세요"></textarea>
   			</div>
		</div>
		
		<!-- <div id="fileList">
			<div class="row mb-3">
				<label for="files" class="form-label">이미지</label>
				<input type="file" class="form-control" id="files" name="pic">
			</div>
			<button type="button" id="fileAdd">Add</button>
		</div> -->
		
		<fieldset>
			<!-- <input type="submit" value="등록"> -->
			<button type="submit">글쓰기</button>
		</fieldset>
		
		</form>
	</div>
		<script src="../resources/js/fileManager.js"></script>
		<script>
			setMax(3);
			setParam('f');
		</script>
		<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>