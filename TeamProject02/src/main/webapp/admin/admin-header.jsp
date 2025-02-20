<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="/TeamProject02/css/index.css" rel="stylesheet">
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
						<a id = "admin-member" class="nav-link" aria-current="page" onclick = "changeList('admin-member')">
							회원목록
						</a>
					</li>
					<li>
						<a id = "admin-brokerage" class="nav-link" onclick = "changeList('admin-brokerage')">
							중개한 매물 목록
						</a>
					</li>
					<li>
						<a id = "admin-sell-request" class="nav-link" onclick = "changeList('admin-sell-request')">
							신청 매물 목록
						</a>
					</li>
					<li>
						<a id = "admin-property" class="nav-link" onclick = "changeList('admin-property')">
							등록된 매물 목록
						</a>
					</li>
				</ul>
			  	<hr>
				<div class="dropdown">
					<div id = "login-name" class = "mb-3"></div>
					<button class = "btn bg-primary text-white logout-btn" type = "button" onclick = "logOut()">
			    		로그아웃
			    	</button>
				</div>
			</div>
			<!-- 사이드바 End -->
		</div>

		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src = "/TeamProject02/js/admin/admin-header.js"></script>
		<script src = "/TeamProject02/js/admin/login-check.js"></script>
	</body>
</html>