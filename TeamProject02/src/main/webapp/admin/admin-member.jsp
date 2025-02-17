<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원목록</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel = "stylesheet" href = "/TeamProject02/css/admin/admin.css">
	</head>
	<body style = "height : 100%;">
		<div class = "wrap"> 		
			<jsp:include page = "/admin/admin-header.jsp"></jsp:include>
			<div id = "content" class = "content">
				<h1>회원목록</h1>
				<table id = "member-table" class="table text-center table-bordered align-middle table-scroll">
					<thead class = "table-light">
						<tr>
							<th scope="col">회원번호</th>
							<th scope="col">아이디</th>
							<th scope="col">성명</th>
							<th scope="col">전화번호</th>
							<th scope="col">가입일자</th>
							<th scope="col">판매권한</th>
							<th scope="col">권한부여</th>
							<th scope="col">탈퇴</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>

		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src = "/TeamProject02/js/admin/admin-login.js"></script>
		<script src = "/TeamProject02/js/admin/admin-member.js"></script>
	</body>
</html>
