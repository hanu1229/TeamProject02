<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
	<link rel = "stylesheet" href = "/TeamProject02/css/member/member.css">
</head>
<body>

		<jsp:include page="/header.jsp" />
		
		<!-- 회원가입 폼 -->
		<div class="container col-xl-10 col-xxl-8 px-4 py-5">
			<div class="row align-items-center g-lg-5 py-5">

				<!-- 회원가입 입력 구역 -->
				<div class="col-md-10 mx-auto col-lg-5">
					<form id="signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
						<div class = "mb-5 img-box">						
							<img src = "/TeamProject02/img/logo.png"/>
						</div>
						<!-- 아이디 -->
						<div class="form-floating mb-3">
							<input id="mid-input" name="mid" class="form-control midinput" type="text" placeholder="계정아이디">
							<label for="floatingInput">아이디</label>
						</div>
						<!-- 비밀번호 -->
						<div class="form-floating mb-3">
							<input id="mpwd-input" name="mpwd" class="form-control mpwdinput" type="password" placeholder="계정비밀번호">
							<label for="floatingPassword">비밀번호</label>
						</div>
						<div class="form-floating mb-3">
							<input id="mname-input" name="mname" class="form-control mnameinput" type="text" placeholder="사용자 이름">
							<label for="floatingInput2">이름</label>
						</div>
						<div class="form-floating mb-3">
							<input id="mphone-input" name="mphone" class="form-control mphoneinput" type="text" placeholder="사용자 전화번호">
							<label for="floatingInput3">전화번호</label>
						</div>
						<!-- 회원가입 버튼 -->
						<button class="w-100 btn btn-lg btn-primary mb-3" type="button" onclick ="memberSignUp()">가입</button>
						<!-- 로그인페이지 이동 -->
						<button class="w-100 btn btn-lg btn-primary" type="button" onclick="window.location.href='/TeamProject02/member/memberLogin.jsp'">로그인</button>
					</form>
				</div>
			</div>
		</div>
	
	<!-- js -->
	<script src = "/TeamProject02/js/member/member-signup.js"></script>
	
</body>
</html>