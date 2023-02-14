<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  <div class="container-fluid">
  	<a href="/" class="navbar-brand"><img src="/resources/images/logo.png" alt=""></a>
  	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item"><a class="nav-link active" href="#">공지사항</a></li>
			<li class="nav-item"><a class="nav-link active" href="/product/list">제품</a></li>
			<li class="nav-item"><a class="nav-link active" href="/bankBook/list">저축상품</a></li>
			<li class="nav-item"><a class="nav-link active" href="#">기타메뉴</a></li>
		</ul>
		
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">LOGIN</a></li>
			<li class="nav-item"><a class="nav-link" href="/member/join">JOIN</a></li>
			<li class="nav-item"><a class="nav-link" href="#">KO</a></li>
			<li class="nav-item"><a class="nav-link" href="#">EN</a></li>
			<li class="nav-item"><a class="nav-link" href="#">JP</a></li>
			<li class="nav-item"><a class="nav-link" href="#">CN</a></li>
		</ul>
    </div>
  </div>
</nav>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="./resources/css/reset.css">
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
	<header>
		<div class="header_wrap">
			<div class="header_logo">
				<a href="/"><img src="/resources/images/logo.png" alt=""></a>
			</div>			
			<nav class="header_nav">
				<ul>
					<li><a href="#">공지사항</a></li>
					<li><a href="/product/list">제품</a></li>
					<li><a href="/bankBook/list">저축상품</a></li>
					<li><a href="#">기타메뉴</a></li>
				</ul>
			</nav>
			<div class="header_sub">
				<ul>
					<li><a href="#">LOGIN</a></li>
					<li><a href="/member/memberAdd">JOIN</a></li>
					<li><a href="#">KO</a></li>
					<li><a href="#">EN</a></li>
					<li><a href="#">JP</a></li>
					<li><a href="#">CN</a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>
