<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body style = "height : 100%;">
		<div id = "sidebar" class = "sidebar">	
			<!-- 사이드바 Start -->
			<div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary" style="width: 280px; height : 100vh;">
			  <a href="admin.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
			    <img class="bi pe-none me-2" width="40" height="40" src = "/TeamProject02/img/logo.png"/>
			    <span class="fs-4">관리자 페이지</span>
			  </a>
			  <hr>
			  <ul class="nav nav-pills flex-column mb-auto">
			    <li class="nav-item">
			      <a href="#" class="nav-link active" aria-current="page">회원목록</a>
			    </li>
			    <li>
			      <a href="#" class="nav-link link-body-emphasis">매물 등록</a>
			    </li>
			    <li>
			      <a href="#" class="nav-link link-body-emphasis">중개한 매물 목록</a>
			    </li>
			    <li>
			      <a href="#" class="nav-link link-body-emphasis">신청 매물 목록</a>
			    </li>
			    <li>
			      <a href="#" class="nav-link link-body-emphasis">등록된 매물 목록</a>
			    </li>
			  </ul>
			  <hr>
			  <div class="dropdown">
			    <a href="#" class="d-flex align-items-center link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			      <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
			      <strong>mdo</strong>
			    </a>
			    <ul class="dropdown-menu text-small shadow">
			      <li><a class="dropdown-item" href="#">New project...</a></li>
			      <li><a class="dropdown-item" href="#">Settings</a></li>
			      <li><a class="dropdown-item" href="#">Profile</a></li>
			      <li><hr class="dropdown-divider"></li>
			      <li><a class="dropdown-item" href="#">Sign out</a></li>
			    </ul>
			  </div>
			</div>
			<!-- 사이드바 End -->
		</div>

		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>