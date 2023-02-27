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
	
		<div class="row justify-content-center my-4">
			<h1 class="col-md-7 text-center my-4">${boardName} 상품등록 페이지</h1>
		</div>
		
		<div class="row justify-content-center my-4">
			<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
				<div class="mb-3">
		   			<label for="writer" class="form-label">작성자</label>		   			
		     		<input name="writer" type="text" class="form-control" id="writer">		   			
		 		</div>
			
				<div class="mb-3">
		   			<label for="title" class="form-label">제목</label>			
					<input name="title" type="text" class="form-control" id="title" placeholder="제목을 입력하세요">			
				</div>
				
				<div class="mb-3">
		   			<label for="contents" class="form-label">내용</label>  			
		   			<textarea name="contents" class="form-control" id="contents" placeholder="내용을 입력하세요" rows="7"></textarea>   			
				</div>
				
				<div id="fileList" class="my-5">
					<!-- <div class="input-group mb-3">
						<input type="file" class="form-control" id="files" name="files">
						<button type="button" class="btn btn-danger"></button>
					</div> -->
					<button type="button" class="btn btn-primary" id="fileAdd">Add</button>
				</div>
				
				<div class="mb-3">		
					<button class="my btn btn-danger" type="submit">글쓰기</button>
				</div>
			
			</form>
		</div>
	</div>
		<script src="../resources/js/fileManager2.js"></script>
		<script>
			setMax(5);
			setParam('files');
		</script>
		<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>