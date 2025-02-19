<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 로그인</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel = "stylesheet" href = "/TeamProject02/css/member/member.css">
	</head>
	<body>
		<!-- 회원가입 폼 -->
		<div class="container col-xl-10 col-xxl-8 px-4 py-5">
			<div class="row align-items-center g-lg-5 py-5">

				<!-- 오른쪽 회원가입 입력 구역 -->
				<div class="col-md-10 mx-auto col-lg-5">
					<form class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
						<div class = "mb-5 img-box">						
							<img src = "/TeamProject02/img/logo.png"/>
						</div>
						<!-- 아이디 -->
						<div class="form-floating mb-3">
							<input id="mid-input" class="form-control midinput" type="text" placeholder="계정아이디">
							<label for="floatingInput">아이디</label>
						</div>
						<!-- 비밀번호 -->
						<div class="form-floating mb-3">
							<input id="mpwd-input" class="form-control mpwdinput" type="password" placeholder="계정비밀번호">
							<label for="floatingPassword">비밀번호</label>
						</div>
						<!-- 로그인 버튼 -->
						<button class="w-100 btn btn-lg btn-primary mb-3" type="button" onclick = "memberLogin()">로그인</button>
						<!-- 회원 정보 찾기 -->
						<button class="w-100 btn btn-lg btn-primary" type="button" onclick="memberFind()">아이디/비밀번호 찾기</button>
					</form>
				</div>
			</div>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src = "/TeamProject02/js/member/member-login.js"></script>
		<script src = "/TeamProject02/js/member/member-header.js"></script>
	</body>
</html>