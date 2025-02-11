<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="/TeamProject02/css/index.css" rel="stylesheet">
</head>
<body>
	<div id=header>
	<!-- 부트스트랩 nav -->
		<nav class="navbar navbar-expand-lg">
	  		<div class="container-fluid">
	  			<div class="header_logo">
		    		<a class="navbar-brand" href="#"> <!-- 로고 -->
		    			<img class="header_logo" src="/TeamProject02/img/logo.png">
		    		</a>
		    	</div>
	    		<div class="container"> <!-- 중앙배치 -->
	    		<form class="container-fluid"> <!-- 검색기능 -->
	    			<div class="input-group">
	      				<span class="input-group-text search_box" id="basic-addon1">
	      					<img class="search_img" src="/TeamProject02/img/search.png">
	      				</span>
	      				<input type="text" class="form-control" placeholder="검색할 주소 입력" aria-label="Username" aria-describedby="basic-addon1">
	    			</div>
	  			</form>
	  			</div>
    <!-- 반응형 토큰(버튼) : 디바이스가 작아지면 메뉴를 보여주는 버튼 -->
	    		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      			<span class="navbar-toggler-icon"></span>
	    		</button>
    <!-- 메뉴박스 -->
		   	 	<div class="collapse navbar-collapse menu" id="navbarSupportedContent">
		     		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        		<li class="nav-item">
		          			<a class="nav-link" href="#">지도</a>
		        		</li>
		        		<li class="nav-item">
		         			<a class="nav-link" href="#">로그인</a>
		        		</li>
		        		<li class="nav-item" >
		          			<a class="nav-link" href="#">회원가입</a>
		        		</li>
		      		</ul>
		   		</div>
			</div>
		</nav>
	</div>

<!-- 부트스트랩 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	
</body>
</html>